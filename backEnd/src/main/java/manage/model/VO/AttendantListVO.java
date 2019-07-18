package manage.model.VO;

public class AttendantListVO {
    private String staff_id;

    private String sex;

    private String name;

    private String status;

    private String time;

    private String tel;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return this.tel;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

}