package manage.model.VO;

/**
 * 用户档案管理
 */
public class StaffProfileVO{
    private String staff_id;

	public String getStaff_id() {
		return this.staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

    private String remark;

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    private String abstracts;

	public String getAbstracts() {
		return this.abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

}