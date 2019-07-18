package manage.model.DTO;

public class LoginDTO {
    private boolean validated;
    private String token;
    private Integer identity;

    public Integer getIdentity() {
        return this.identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public boolean getValidated() {
        return this.validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}