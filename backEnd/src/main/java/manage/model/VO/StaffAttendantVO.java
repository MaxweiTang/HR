package manage.model.VO;

/**
 * 员工考勤信息登记
 */
public class StaffAttendantVO {
    private String staff_id;

    private String time;

    private String status;

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_id() {
        return this.staff_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}