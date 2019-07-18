package manage.model.VO;

/**
 * 用户信息验证结果
 */
public class AuthResultVO {
    private String token;
    private String identity;

    public AuthResultVO(String token, String identity) {
        this.token = token;
        this.identity = identity;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}