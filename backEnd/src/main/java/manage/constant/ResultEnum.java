package manage.constant;

public enum ResultEnum {
    SUCCESS(0, "成功"), BUSINESS_EXCEPTION(1, "错误");
    Integer code;
    String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

}