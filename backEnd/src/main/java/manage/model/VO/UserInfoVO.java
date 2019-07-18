package manage.model.VO;

/**
 * 验证 token 后生成的用户登录信息
 */
public class UserInfoVO {
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoVO(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}