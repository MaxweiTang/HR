package manage.model.VO;

/**
 * 员工合同信息管理
 */
public class StaffContractVO {
    private String staff_id;

    private String position;

    private String begin;

    private String end;

    private String content;

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_id() {
        return this.staff_id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getBegin() {
        return this.begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd() {
        return this.end;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

}