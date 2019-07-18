package manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.util.BeanUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.dao.AttendanceMapper;
import manage.dao.ContractMapper;
import manage.dao.DepartmentMapper;
import manage.dao.PeopleMapper;
import manage.dao.PositionLogMapper;
import manage.dao.ProfileMapper;
import manage.dao.ProgramMapper;
import manage.dao.StaffMapper;
import manage.dao.TrainMapper;
import manage.dao.UserAuthMapper;
import manage.model.DO.Attendance;
import manage.model.DO.Contract;
import manage.model.DO.Department;
import manage.model.DO.People;
import manage.model.DO.Profile;
import manage.model.DO.Program;
import manage.model.DO.Staff;
import manage.model.DO.Train;
import manage.model.DO.UserAuth;
import manage.model.VO.AttendantListVO;
import manage.model.VO.AttendantSelectVO;
import manage.model.VO.ContractListVO;
import manage.model.VO.ContractSelectVO;
import manage.model.VO.DepartmentListVO;
import manage.model.VO.PeopleListVO;
import manage.model.VO.PeopleSelectVO;
import manage.model.VO.ProfileListVO;
import manage.model.VO.ProfileSelectVO;
import manage.model.VO.StaffListVO;
import manage.model.VO.StaffSelectVO;
import manage.model.VO.TrainInfoVO;
import manage.model.VO.TrainProgramVO;
import manage.model.VO.TrainSelectVO;
import manage.service.ListService;
import manage.util.DateUtil;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    PeopleMapper peopleMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    UserAuthMapper userAuthMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    PositionLogMapper positionLogMapper;
    @Autowired
    ProgramMapper programMapper;
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    ProfileMapper profileMapper;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    AttendanceMapper attendanceMapper;

    // 若 pvo 设置了 peole_id，选择特定用户的ID
    public List<PeopleListVO> people(PeopleSelectVO pVo) {
        List<PeopleListVO> list = new ArrayList();
        if (pVo.getPeople_id() != null && pVo.getPeople_id() != "") {
            People oldPeople = peopleMapper.selectByPrimaryKey(pVo.getPeople_id());
            if (oldPeople == null) {
                return list;
            }
            PeopleListVO pListVO = new PeopleListVO();

            pListVO.setId(oldPeople.getId());
            // HECK
            try {
                pListVO.setBirth(DateUtil.reverse(oldPeople.getBirth()));
                pListVO.setRegister_date(DateUtil.reverse(oldPeople.getRegisterDate()));
            } catch (Exception e) {
                e.printStackTrace();
                return list;
            }

            pListVO.setDegree(oldPeople.getDegree());
            pListVO.setEmail(oldPeople.getEmail());
            pListVO.setName(oldPeople.getName());
            pListVO.setRemark(oldPeople.getRemark());
            pListVO.setSex(oldPeople.getSex());
            pListVO.setTel(oldPeople.getTel());
            list.add(pListVO);
            return list;
        }
        List<People> peoples = peopleMapper.selectAll();
        for (People oldPeople : peoples) {
            PeopleListVO pListVO = new PeopleListVO();

            pListVO.setId(oldPeople.getId());
            // HECK
            try {
                pListVO.setBirth(DateUtil.reverse(oldPeople.getBirth()));
                pListVO.setRegister_date(DateUtil.reverse(oldPeople.getRegisterDate()));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            pListVO.setDegree(oldPeople.getDegree());
            pListVO.setEmail(oldPeople.getEmail());
            pListVO.setName(oldPeople.getName());
            pListVO.setRemark(oldPeople.getRemark());
            pListVO.setSex(oldPeople.getSex());
            pListVO.setTel(oldPeople.getTel());
            list.add(pListVO);
        }
        return list;
    }

    public List<StaffListVO> staff(StaffSelectVO sVo) {
        List<StaffListVO> list = new ArrayList();
        if (sVo.getStaff_id() != null && sVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(sVo.getStaff_id());
            if (oldStaff == null) {
                return list;
            }
            StaffListVO sListVO = new StaffListVO();

            sListVO.setId(oldStaff.getId());
            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                sListVO.setAvatar("");
            } else {
                sListVO.setAvatar(userAuth.getAvatar());
            }
            sListVO.setDepartment(departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId()).getName());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            sListVO.setEmail(oldPeople.getEmail());
            sListVO.setName(oldPeople.getName());
            sListVO.setPeople_id(oldStaff.getPid());
            sListVO.setPosition(positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId()).getTo());
            sListVO.setRemark(oldPeople.getRemark());
            sListVO.setSex(oldPeople.getSex());
            sListVO.setTel(oldPeople.getTel());
            list.add(sListVO);
            return list;
        }
        List<Staff> staffs = staffMapper.selectAll();
        for (Staff oldStaff : staffs) {
            StaffListVO sListVO = new StaffListVO();

            sListVO.setId(oldStaff.getId());
            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                sListVO.setAvatar("");
            } else {
                sListVO.setAvatar(userAuth.getAvatar());
            }
            sListVO.setDepartment(departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId()).getName());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            sListVO.setEmail(oldPeople.getEmail());
            sListVO.setName(oldPeople.getName());
            sListVO.setPeople_id(oldStaff.getPid());
            sListVO.setPosition(positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId()).getTo());
            sListVO.setRemark(oldPeople.getRemark());
            sListVO.setSex(oldPeople.getSex());
            sListVO.setTel(oldPeople.getTel());
            list.add(sListVO);
        }
        return list;
    }

    /**
     * 
     * @return 如果没有返回空 List
     */
    public List<TrainProgramVO> program() {
        List<Program> programs = programMapper.selectAll();
        List<TrainProgramVO> trainProgramVOs = new ArrayList<TrainProgramVO>();
        for (Program program : programs) {
            TrainProgramVO trainProgramVO = new TrainProgramVO();
            trainProgramVO.setId(program.getId());
            trainProgramVO.setName(program.getName());
        }
        return trainProgramVOs;
    };

    /**
     * 根据过滤条件得到培训信息
     */
    public List<TrainInfoVO> train(TrainSelectVO tVo) {
        List<TrainInfoVO> list = new ArrayList();
        if (tVo.getStaff_id() != null && tVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(tVo.getStaff_id());
            if (oldStaff == null) {
                return list;
            }
            TrainInfoVO tIVo = new TrainInfoVO();

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                tIVo.setAvatar("");
            } else {
                tIVo.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            tIVo.setName(oldPeople.getName());

            Train train = trainMapper.selectByStaffId(tVo.getStaff_id());
            if (train == null) {
                return list;
            }

            tIVo.setProgram(programMapper.selectByPrimaryKey(train.getProgramId()).getName());
            tIVo.setResult(train.getResult());
            tIVo.setSex(oldPeople.getSex());
            tIVo.setStaff_id(oldStaff.getId());

            list.add(tIVo);
            return list;
        }
        List<Train> trains = trainMapper.selectAll();
        for (Train oldTrain : trains) {
            Staff oldStaff = staffMapper.selectByPrimaryKey(oldTrain.getStaffId());
            if (oldStaff == null) {
                return list;
            }
            TrainInfoVO tIVo = new TrainInfoVO();

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                tIVo.setAvatar("");
            } else {
                tIVo.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            tIVo.setName(oldPeople.getName());

            tIVo.setProgram(programMapper.selectByPrimaryKey(oldTrain.getProgramId()).getName());
            tIVo.setResult(oldTrain.getResult());
            tIVo.setSex(oldPeople.getSex());
            tIVo.setStaff_id(oldStaff.getId());

            list.add(tIVo);
            return list;
        }
        return list;
    }

    /**
     * 返回部门信息
     */
    public List<DepartmentListVO> department() {
        List<Department> departments = departmentMapper.selectAll();
        List<DepartmentListVO> departmentListVOs = new ArrayList<DepartmentListVO>();
        for (Department department : departments) {
            DepartmentListVO departmentListVO = new DepartmentListVO();
            departmentListVO.setId(department.getId());
            departmentListVO.setName(department.getName());
            departmentListVOs.add(departmentListVO);
        }
        return departmentListVOs;
    }

    /**
     * 档案
     */
    public List<ProfileListVO> profile(ProfileSelectVO pVo) {
        List<ProfileListVO> list = new ArrayList();
        if (pVo.getStaff_id() != null && pVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(pVo.getStaff_id());
            if (oldStaff == null) {
                return list;
            }
            ProfileListVO profileListVO = new ProfileListVO();

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                profileListVO.setAvatar("");
            } else {
                profileListVO.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            profileListVO.setName(oldPeople.getName());

            Profile profile = profileMapper.selectByPrimaryKey(oldStaff.getProfileId());

            profileListVO.setContent(profile.getAbstracts());
            profileListVO.setName(profile.getName());
            profileListVO.setRemark(profile.getRemark());
            profileListVO.setSex(oldPeople.getSex());
            profileListVO.setStaff_id(oldStaff.getId());

            list.add(profileListVO);

            return list;
        }
        List<Staff> staffs = new ArrayList<Staff>();
        for (Staff oldStaff : staffs) {
            Profile profile = profileMapper.selectByPrimaryKey(oldStaff.getProfileId());
            ProfileListVO profileListVO = new ProfileListVO();
            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                profileListVO.setAvatar("");
            } else {
                profileListVO.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            profileListVO.setName(oldPeople.getName());

            profileListVO.setContent(profile.getAbstracts());
            profileListVO.setName(profile.getName());
            profileListVO.setRemark(profile.getRemark());
            profileListVO.setSex(oldPeople.getSex());
            profileListVO.setStaff_id(oldStaff.getId());

            list.add(profileListVO);
        }
        return list;
    }

    /**
     * 合同
     */
    public List<ContractListVO> contarct(ContractSelectVO cVo) {
        List<ContractListVO> list = new ArrayList();
        if (cVo.getStaff_id() != null && cVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(cVo.getStaff_id());
            if (oldStaff == null) {
                return list;
            }
            ContractListVO contractListVO = new ContractListVO();

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                contractListVO.setAvatar("");
            } else {
                contractListVO.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            contractListVO.setName(oldPeople.getName());

            Contract oldContract = contractMapper.selectByPrimaryKey(oldStaff.getContractId());

            Department oldDepartment = departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId());
            contractListVO.setDepartment(oldDepartment.getName());

            try {
                contractListVO.setStart(DateUtil.reverse(oldContract.getBegin()));
                contractListVO.setEnd(DateUtil.reverse(oldContract.getEnd()));
            } catch (Exception e) {
                e.printStackTrace();
                return list;
            }
            contractListVO.setPostion(positionLogMapper.selectByPrimaryKey(oldStaff.getId()).getTo());
            contractListVO.setRemark(oldContract.getRemark());
            contractListVO.setSex(oldPeople.getSex());
            contractListVO.setStaff_id(oldStaff.getId());

            list.add(contractListVO);

            return list;
        }
        List<Staff> staffs = new ArrayList<Staff>();
        for (Staff oldStaff : staffs) {
            Contract oldContract = contractMapper.selectByPrimaryKey(oldStaff.getProfileId());
            ContractListVO contractListVO = new ContractListVO();

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                contractListVO.setAvatar("");
            } else {
                contractListVO.setAvatar(userAuth.getAvatar());
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());
            contractListVO.setName(oldPeople.getName());

            Department oldDepartment = departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId());
            contractListVO.setDepartment(oldDepartment.getName());

            try {
                contractListVO.setStart(DateUtil.reverse(oldContract.getBegin()));
                contractListVO.setEnd(DateUtil.reverse(oldContract.getEnd()));
            } catch (Exception e) {
                e.printStackTrace();
                return list;
            }
            contractListVO.setPostion(positionLogMapper.selectByPrimaryKey(oldStaff.getId()).getTo());
            contractListVO.setRemark(oldContract.getRemark());
            contractListVO.setSex(oldPeople.getSex());
            contractListVO.setStaff_id(oldStaff.getId());

            list.add(contractListVO);

        }
        return list;
    }

    /**
     * 考勤
     */
    public List<AttendantListVO> attendant(AttendantSelectVO aVo) {
        List<AttendantListVO> list = new ArrayList();
        if (aVo.getStaff_id() != null && aVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(aVo.getStaff_id());
            if (oldStaff == null) {
                return list;
            }

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<Attendance> oldAttendances = attendanceMapper.selectByStaffId(oldStaff.getId());

            for (Attendance a : oldAttendances) {
                AttendantListVO attendantListVO = new AttendantListVO();

                if (userAuth == null) {
                    attendantListVO.setAvatar("");
                } else {
                    attendantListVO.setAvatar(userAuth.getAvatar());
                }
                attendantListVO.setName(oldPeople.getName());

                attendantListVO.setSex(oldPeople.getSex());
                attendantListVO.setStaff_id(oldStaff.getId());
                attendantListVO.setStatus(a.getType());
                attendantListVO.setTel(oldPeople.getTel());
                try {
                    attendantListVO.setTime(DateUtil.reverse(a.getTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                list.add(attendantListVO);
            }

            return list;
        }
        List<Attendance> attendances = attendanceMapper.selectAll();
        for (Attendance oldAttendance : attendances) {

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldAttendance.getStaffId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldAttendance.getStaffId());

            AttendantListVO attendantListVO = new AttendantListVO();

            if (userAuth == null) {
                attendantListVO.setAvatar("");
            } else {
                attendantListVO.setAvatar(userAuth.getAvatar());
            }
            attendantListVO.setName(oldPeople.getName());

            attendantListVO.setSex(oldPeople.getSex());
            attendantListVO.setStaff_id(oldAttendance.getStaffId());
            attendantListVO.setStatus(oldAttendance.getType());
            attendantListVO.setTel(oldPeople.getTel());
            try {
                attendantListVO.setTime(DateUtil.reverse(oldAttendance.getTime()));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            list.add(attendantListVO);
        }
        return list;
    }
}