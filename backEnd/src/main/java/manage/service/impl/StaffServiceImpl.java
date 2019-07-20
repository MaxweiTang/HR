package manage.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.service.StaffService;
import manage.util.DateUtil;
import manage.util.RandomUtil;
import manage.dao.AttendanceMapper;
import manage.dao.ContractMapper;
import manage.dao.PeopleMapper;
import manage.dao.PositionLogMapper;
import manage.dao.ProfileMapper;
import manage.dao.StaffMapper;
import manage.dao.TrainMapper;
import manage.model.DO.Attendance;
import manage.model.DO.Contract;
import manage.model.DO.People;
import manage.model.DO.PositionLog;
import manage.model.DO.Profile;
import manage.model.DO.Staff;
import manage.model.DO.Train;
import manage.model.VO.*;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    PeopleMapper peopleMapper;
    @Autowired
    ProfileMapper profileMapper;
    @Autowired
    PositionLogMapper positionLogMapper;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    AttendanceMapper attendanceMapper;

    public boolean update(StaffInfoVO sVo) {
        Staff oldStaff = staffMapper.selectByPrimaryKey(sVo.getId());
        People people = new People();
        BeanUtils.copyProperties(sVo, people);
        people.setId(oldStaff.getPid());
        peopleMapper.updateByPrimaryKeySelective(people);
        return true;
    }

    public boolean delete(String staffId) {
        Staff staff = new Staff();
        staff.setId(staffId);
        staff.setDeleted((byte) 1);
        staffMapper.updateByPrimaryKeySelective(staff);
        return true;
    }

    // 追加相关信息到原文档
    public boolean updateProfile(StaffProfileVO sVo) {
        Staff staff = staffMapper.selectByPrimaryKey(sVo.getStaff_id());
        Profile profile = profileMapper.selectByPrimaryKey(staff.getProfileId());
        profile.setAbstracts(profile.getAbstracts() + "\n" + sVo.getAbstracts());
        profile.setRemark(profile.getRemark() + "\n" + sVo.getRemark());
        return true;
    }

    // 添加合同信息，并根据新职位，添加职位变化记录，更新当前职位
    public boolean addContract(StaffContractVO sVo) {
        // 找出旧员工
        Staff oldStaff = staffMapper.selectByPrimaryKey(sVo.getStaff_id());
        // 更新 position_log
        PositionLog oldPosition = positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId());
        PositionLog newPosition = new PositionLog();
        newPosition.setId(RandomUtil.generate());
        newPosition.setFrom(oldPosition.getTo());
        newPosition.setTo(sVo.getPosition());
        newPosition.setTime(new Date());
        newPosition.setStaffId(oldStaff.getId());
        newPosition.setReason("合同变更");
        // 更新员工职位信息
        Staff newStaff = new Staff();
        newStaff.setId(oldStaff.getId());
        newStaff.setPositionId(newPosition.getId());
        // 更新 contract
        Contract contract = new Contract();
        contract.setId(RandomUtil.generate());
        try {
            contract.setBegin(DateUtil.parse(sVo.getBegin()));
            contract.setEnd(DateUtil.parse(sVo.getEnd()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        contract.setPositionId(newPosition.getId());
        contract.setContent(sVo.getContent());

        staffMapper.updateByPrimaryKeySelective(newStaff);
        positionLogMapper.insert(newPosition);
        contractMapper.insertSelective(contract);
        return true;
    }

    // 调动员工，记得更新 staff 表当前指向的职位
    public boolean transfer(StaffTransferVO sVo) {
        // 更新 position_log
        Staff oldStaff = staffMapper.selectByPrimaryKey(sVo.getStaff_id());
        PositionLog oldPosition = positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId());

        PositionLog positionLog = new PositionLog();
        positionLog.setId(RandomUtil.generate());
        // HECK
        positionLog.setFrom(oldPosition.getTo());
        positionLog.setTo(sVo.getTo());
        try {
            positionLog.setTime(DateUtil.parse(sVo.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        positionLog.setReason(sVo.getReason());
        positionLog.setStaffId(sVo.getStaff_id());

        oldStaff.setPositionId(positionLog.getId());
        staffMapper.updateByPrimaryKeySelective(oldStaff);
        positionLogMapper.insert(positionLog);
        return true;
    }

    public boolean train(StaffTrainVO sVo) {
        Train train = new Train();
        train.setId(RandomUtil.generate());
        train.setProgramId(sVo.getProgram_id());
        train.setResult(sVo.getResult());
        train.setStaffId(sVo.getStaff_id());
        try {
            train.setTime(DateUtil.parse(sVo.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        trainMapper.insert(train);
        return true;
    }

    public boolean attendant(StaffAttendantVO sVo) {
        Attendance attendance = new Attendance();
        attendance.setId(RandomUtil.generate());
        attendance.setStaffId(sVo.getStaff_id());
        try {
            attendance.setTime(DateUtil.parse(sVo.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        attendance.setType(sVo.getStatus());
        attendanceMapper.insert(attendance);
        return true;
    }

    public boolean staffNew(StaffNewVO sVo) {
        // 新建员工
        Staff staff = new Staff();
        staff.setId(RandomUtil.generate());
        staff.setDepartmentId(sVo.getDepartment_id());
        staff.setPid(sVo.getPeople_id());
        staff.setStatus("在职");
        // 新建档案
        Profile profile = new Profile();
        profile.setId(RandomUtil.generate());
        profile.setName(sVo.getProfile_name());
        profile.setAbstracts(sVo.getProfile_abstract());
        profile.setRemark(sVo.getProfile_remark());
        // 新建 position_log
        PositionLog positionLog = new PositionLog();
        positionLog.setId(RandomUtil.generate());
        positionLog.setFrom("");
        positionLog.setTo(sVo.getPosition());
        positionLog.setStaffId(staff.getId());
        positionLog.setReason("入职");
        // 新建 contract
        Contract contract = new Contract();
        contract.setId(RandomUtil.generate());
        try {
            contract.setBegin(DateUtil.parse(sVo.getTime()));
            contract.setEnd(DateUtil.parse(sVo.getEnd()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        contract.setPositionId(positionLog.getId());
        contract.setContent(sVo.getContarct_content());
        // 设置员工 contractid positionid profileid
        staff.setProfileId(profile.getId());
        staff.setPositionId(positionLog.getId());
        staff.setContractId(contract.getId());

        staffMapper.insertSelective(staff);
        profileMapper.insertSelective(profile);
        positionLogMapper.insertSelective(positionLog);
        contractMapper.insertSelective(contract);
        return true;
    }
}