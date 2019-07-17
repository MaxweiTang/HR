package manage.model.VO;

import javax.validation.constraints.NotNull;


public class UserAuthVO {

    /**
     * 用户id
     */
	@NotNull
    private String username;


    public String getUsername() {
    	return this.username;
    }
    public void setUsername(String username) {
    	this.username = username;
    }

    /**
     * 登录凭证
     */
    @NotNull
    private String password;


    public String getPassword() {
    	return this.password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }

	/**
	 * 验证码
	 */
	@NotNull
    private String captcha;


    public String getCaptcha() {
    	return this.captcha;
    }
    public void setCaptcha(String captcha) {
    	this.captcha = captcha;
    }

	/**
	 * token
	 */
	@NotNull
	private String token;


	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	
}