package manage.model.VO;

/**
 * 用户信息验证结果
 */
public class AuthResultVO {
    private String token;
    private Integer identity;

    public AuthResultVO(String token, Integer identity) {
        this.token = token;
        this.identity = identity;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIdentity() {
        return this.identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
}