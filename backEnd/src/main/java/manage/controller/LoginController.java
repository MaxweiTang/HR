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

import manage.model.User;
import manage.model.VO.ResultVO;
import manage.model.VO.UserAuthVO;
import manage.service.UserService;
import manage.util.ResultVOUtil;


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

import manage.util.ValidationGenerator;
import manage.exception.*;
import manage.constant.*;

@RestController
@RequestMapping("login")
public class LoginController {
	private static Logger logger = LogManager.getLogger(BaseExceptionHandle.class);
	// Cache captchas
	private Map<String, String> captchas = new HashMap<String, String>();

	@Resource
	private UserService<User> userServiceImpl;

	@RequestMapping(value = "token", method = RequestMethod.GET)
	public ResultVO getToken() {
		String token = UUID.randomUUID().toString();
		Map<String, Object> map = new HashMap<>(16);
		map.put("token", token);
		return ResultVOUtil.success(map);
	}

	@RequestMapping(value="captcha/{token}",method = RequestMethod.GET)
	public Map<String, Object> getValidateCode(@PathVariable("token") String token, HttpServletResponse response) {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");

		ValidationGenerator vGenerator = new ValidationGenerator();
		String validationCode = vGenerator.getValidationCode();
		if (validationCode == null) {
			throw new BusinessException( "获取验证码失败");
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResultVO login(@Valid @RequestBody UserAuthVO userAuthVO) {
		String oldCaptcha = captchas.get(userAuthVO.getToken());
		captchas.remove(userAuthVO.getToken());
		if(oldCaptcha != userAuthVO.getCaptcha().toLowerCase()){
			return ResultVOUtil.retSysError("验证码不正确");
		}

	}

	@RequestMapping("logout")
	public String logout(@RequestParam(value = "username", required = false) String username,
			RedirectAttributes redirectAttributes) {

		return "redirect:/login";
	}

}