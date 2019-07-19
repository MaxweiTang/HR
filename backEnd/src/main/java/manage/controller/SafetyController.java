package manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;

import manage.model.DTO.LoginDTO;
import manage.model.VO.AuthResultVO;
import manage.model.VO.NewPassInVO;
import manage.model.VO.ResultVO;
import manage.model.VO.UserAuthVO;
import manage.model.VO.UserInfoVO;
import manage.service.UserService;
import manage.util.RedisUtil;
import manage.util.ResultVOUtil;
import manage.util.ValidationGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import manage.exception.*;
import manage.constant.*;

@RestController
@RequestMapping("safety")
// @CrossOrigin(origins = "*", maxAge = 3600)
public class SafetyController {
	private static Logger logger = LoggerFactory.getLogger(SafetyController.class);
	// Cache captchas
	private Map<String, String> captchas = new HashMap<String, String>();
	@Autowired
	private RedisUtil redisutil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "token", method = RequestMethod.GET)
	public ResultVO<Map<String,Object>> getToken() {
		String token = UUID.randomUUID().toString();
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("token", token);
		return ResultVOUtil.success(map);
	}

	@RequestMapping(value = "captcha/{token}", method = RequestMethod.GET)
	public Map<String, Object> getValidateCode(@PathVariable("token") String token, HttpServletResponse response) {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");

		ValidationGenerator vGenerator = new ValidationGenerator();
		String validationCode = vGenerator.getValidationCode();
		if (validationCode == null) {
			throw new BusinessException("获取验证码失败");
		}

		captchas.put(token, validationCode.toLowerCase());

		// 取得验证码图片并输出
		BufferedImage bufferedImage = vGenerator.getBufferedImage();
		if (bufferedImage == null) {
			throw new BusinessException("获取验证码失败");
		}
		OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage, "png", outputStream);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
			vGenerator.destroy();
		}
		return null;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResultVO login(@Valid @RequestBody UserAuthVO userAuthVO) {
		String oldCaptcha = captchas.get(userAuthVO.getToken());
		if (!userAuthVO.getCaptcha().toLowerCase().equals(oldCaptcha)) {
			return ResultVOUtil.retSysError("验证码不正确");
		}
		captchas.remove(userAuthVO.getToken());
		LoginDTO rs = userService.validateUser(userAuthVO);
		if (!rs.getValidated()) {
			return ResultVOUtil.retSysError("用户身份验证失败");
		}

		return ResultVOUtil.success(new AuthResultVO(rs.getToken(), rs.getIdentity()));
	}

	@RequestMapping(value = "newpassword", method = RequestMethod.POST)
	public ResultVO newPass(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody NewPassInVO pInVO) {
		String rs = userService.newPass(uVo.getUserId(), pInVO.getNewpasswd());
		if (rs != null) {
			return ResultVOUtil.retSysError(rs);
		}
		return ResultVOUtil.success();
	}

	@RequestMapping("logout")
	public ResultVO logout(@RequestAttribute("userid") UserInfoVO uVo) {

		redisutil.del(Constant.MODULE_TOKEN_REDIS_KEY + uVo.getToken());

		return ResultVOUtil.success();
	}

}