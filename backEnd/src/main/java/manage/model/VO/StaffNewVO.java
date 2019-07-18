package manage.model.VO;

public class StaffNewVO {
    private String people_id;

    private String department_id;

    private String time;

    private String position;

    private String end;

    private String profile_name;

    private String contarct_content;

    public String getContarct_content() {
        return this.contarct_content;
    }

    public void setContarct_content(String contarct_content) {
        this.contarct_content = contarct_content;
    }

    public String getProfile_name() {
        return this.profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    private String profile_abstract;

    public String getProfile_abstract() {
        return this.profile_abstract;
    }

    public void setProfile_abstract(String profile_abstract) {
        this.profile_abstract = profile_abstract;
    }

    private String profile_remark;

    public String getProfile_remark() {
        return this.profile_remark;
    }

    public void setProfile_remark(String profile_remark) {
        this.profile_remark = profile_remark;
    }

    public void setPeople_id(String people_id) {
        this.people_id = people_id;
    }

    public String getPeople_id() {
        return this.people_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_id() {
        return this.department_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd() {
        return this.end;
    }

}