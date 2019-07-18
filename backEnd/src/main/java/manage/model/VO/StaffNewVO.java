package manage.model.VO;

public class StaffNewVO {
    private String people_id;

    private String department_id;

    private String time;

    private String position;

    private String end;

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