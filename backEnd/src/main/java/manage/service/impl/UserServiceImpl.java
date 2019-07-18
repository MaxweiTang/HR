package manage.service.impl;

import com.github.bingoohuang.patchca.random.RandUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.constant.Constant;
import manage.dao.UserAuthMapper;
import manage.model.DO.UserAuth;
import manage.model.DTO.LoginDTO;
import manage.model.VO.UserAuthVO;
import manage.service.UserService;
import manage.util.RandomUtil;
import manage.util.RedisUtil;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserAuthMapper userAuthMapper;
    @Autowired
    RedisUtil redisUtil;

    // 验证用户身份
    public LoginDTO validateUser(UserAuthVO uVo) {
        UserAuth oldUser = userAuthMapper.selectByPrimaryKey(uVo.getUsername());
        if (oldUser == null || !oldUser.getPassword().equals(uVo.getPassword())) {
            return new LoginDTO();
        } else {
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setValidated(true);
            loginDTO.setIdentity(oldUser.getAuthLevel());

            String token = RandomUtil.generate();
            loginDTO.setToken(token);
            redisUtil.set(Constant.MODULE_TOKEN_REDIS_KEY + token, uVo.getUsername());
            return loginDTO;
        }
    }

    /**
     * 修改密码 成功返回null，失败返回原因
     */
    public String newPass(String userId, String newPass) {
        UserAuth userAuth = new UserAuth();
        userAuth.setId(userId);
        userAuth.setPassword(newPass);
        userAuthMapper.updateByPrimaryKeySelective(userAuth);
        return null;
    }

}