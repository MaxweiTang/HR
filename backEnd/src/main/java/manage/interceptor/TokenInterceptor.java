package manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import manage.constant.Constant;
import manage.model.VO.UserInfoVO;
import manage.util.RedisUtil;
import manage.util.ResultVOUtil;

/**
 * Validate token
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RedisUtil redisutil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader("token");
        if (token == null) {
            errResponse(response);
            return false;
        }
        String userId = (String) redisutil.get(Constant.MODULE_TOKEN_REDIS_KEY + token);
        if (userId == null || userId == "") {
            errResponse(response);
            return false;
        }

        request.setAttribute("userid", new UserInfoVO(userId, token));
        return true;
    }

    private void errResponse(HttpServletResponse response) throws Exception {
        response.setContentType(Constant.JSON_CONTENT_TYPE);
        response.getWriter().write(JSONObject.toJSONString(ResultVOUtil.retSysError("登录信息失效，请重新登录")));
    }
}