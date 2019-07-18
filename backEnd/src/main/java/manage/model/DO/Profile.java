package manage.model.DO;

public class Profile {
    private String id;

    private String name;

    private String abstract;

    private String remark;

    private Byte deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAbstract() {
        return abstract;
    }

    public void setAbstract(String abstract) {
        this.abstract = abstract == null ? null : abstract.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}