package manage.model.VO;

/**
 * 员工培训信息
 */
public class StaffTrainVO {
    private String staff_id;
    
    private String program_id;
    
    private String time;
    
    private String result;
    
    public void setStaff_id(String staff_id){
    this.staff_id = staff_id;
    }
    public String getStaff_id(){
    return this.staff_id;
    }
    public void setProgram_id(String program_id){
    this.program_id = program_id;
    }
    public String getProgram_id(){
    return this.program_id;
    }
    public void setTime(String time){
    this.time = time;
    }
    public String getTime(){
    return this.time;
    }
    public void setResult(String result){
    this.result = result;
    }
    public String getResult(){
    return this.result;
    }
    
    }