package manage.model.VO;

/**
 * 返回的培训信息
 */
public class TrainInfoVO {
    private String staff_id;

    private String sex;

    private String name;

    private String program;

    private String result;

    private String avatar;

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_id() {
        return this.staff_id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return this.program;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

}