package manage.model.VO;

/**
 * 人事调度信息
 */
public class StaffTransferVO {
    private String staff_id;

    private String from;

    private String to;

    private String time;

    private String reason;

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_id() {
        return this.staff_id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return this.from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

}