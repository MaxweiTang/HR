package manage.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import manage.dao.SalaryMapper;
import manage.dao.StaffMapper;
import manage.dao.TrainMapper;
import manage.dao.UserAuthMapper;
import manage.model.DO.Attendance;
import manage.model.DO.Contract;
import manage.model.DO.Department;
import manage.model.DO.People;
import manage.model.DO.PositionLog;
import manage.model.DO.Profile;
import manage.model.DO.Program;
import manage.model.DO.Salary;
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
import manage.model.VO.PositionLogListVO;
import manage.model.VO.PositionLogSelectVO;
import manage.model.VO.ProfileListVO;
import manage.model.VO.ProfileSelectVO;
import manage.model.VO.SalaryListVO;
import manage.model.VO.SalarySelectVO;
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
    @Autowired
    SalaryMapper salaryMapper;

    // 若 pvo 设置了 peole_id，选择特定用户的ID
    public List<PeopleListVO> people(PeopleSelectVO pVo) {
        List<PeopleListVO> list = new ArrayList();
        if (pVo.getPeople_id() != null && pVo.getPeople_id() != "") {
            People oldPeople = peopleMapper.selectByPrimaryKey(pVo.getPeople_id());
            if (oldPeople == null || oldPeople.getDeleted() == 1) {
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
            if (oldPeople.getDeleted() == 1) {
                continue;
            }
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
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
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
            if (oldStaff.getDeleted() == 1) {
                continue;
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
            if (program.getDeleted() == 1) {
                continue;
            }
            TrainProgramVO trainProgramVO = new TrainProgramVO();
            trainProgramVO.setId(program.getId());
            trainProgramVO.setName(program.getName());
            trainProgramVOs.add(trainProgramVO);
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
            if (department.getDeleted() == 1) {
                continue;
            }
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
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
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
        List<Staff> staffs = staffMapper.selectAll();
        for (Staff oldStaff : staffs) {
            if (oldStaff.getDeleted() == 1) {
                continue;
            }
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
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
                return list;
            }

            String avatar;
            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                avatar = "";
            } else {
                avatar = userAuth.getAvatar();
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<Contract> contracts = contractMapper.selectByPrimaryKey(oldStaff.getContractId());

            for (Contract oldContract : contracts) {
                ContractListVO contractListVO = new ContractListVO();

                contractListVO.setAvatar(avatar);
                contractListVO.setName(oldPeople.getName());
                contractListVO.setContent(oldContract.getContent());
                Department oldDepartment = departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId());
                contractListVO.setDepartment(oldDepartment.getName());

                try {
                    contractListVO.setStart(DateUtil.reverse(oldContract.getBegin()));
                    contractListVO.setEnd(DateUtil.reverse(oldContract.getEnd()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return list;
                }
                contractListVO.setPostion(positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId()).getTo());
                contractListVO.setRemark(oldContract.getRemark());
                contractListVO.setSex(oldPeople.getSex());
                contractListVO.setStaff_id(oldStaff.getId());

                list.add(contractListVO);
            }

            return list;
        }
        List<Staff> staffs = staffMapper.selectAll();
        for (Staff oldStaff : staffs) {
            if (oldStaff.getDeleted() == 1) {
                continue;
            }
            String avatar;
            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            if (userAuth == null) {
                avatar = "";
            } else {
                avatar = userAuth.getAvatar();
            }

            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<Contract> contracts = contractMapper.selectByPrimaryKey(oldStaff.getContractId());

            for (Contract oldContract : contracts) {
                ContractListVO contractListVO = new ContractListVO();

                contractListVO.setAvatar(avatar);
                contractListVO.setName(oldPeople.getName());
                contractListVO.setContent(oldContract.getContent());
                Department oldDepartment = departmentMapper.selectByPrimaryKey(oldStaff.getDepartmentId());
                contractListVO.setDepartment(oldDepartment.getName());

                try {
                    contractListVO.setStart(DateUtil.reverse(oldContract.getBegin()));
                    contractListVO.setEnd(DateUtil.reverse(oldContract.getEnd()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return list;
                }
                contractListVO.setPostion(positionLogMapper.selectByPrimaryKey(oldStaff.getPositionId()).getTo());
                contractListVO.setRemark(oldContract.getRemark());
                contractListVO.setSex(oldPeople.getSex());
                contractListVO.setStaff_id(oldStaff.getId());

                list.add(contractListVO);
            }

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
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
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
            Staff oldStaff = staffMapper.selectByPrimaryKey(oldAttendance.getStaffId());
            if (oldStaff.getDeleted() == 1) {
                continue;
            }
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

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

    /**
     * 职位记录
     */
    public List<PositionLogListVO> positionLog(PositionLogSelectVO aVo) {
        List<PositionLogListVO> list = new ArrayList();
        if (aVo.getStaff_id() != null && aVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(aVo.getStaff_id());
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
                return list;
            }

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<PositionLog> oldPositions = positionLogMapper.selectByStaffId(oldStaff.getId());

            for (PositionLog a : oldPositions) {
                PositionLogListVO positionLogListVO = new PositionLogListVO();

                if (userAuth == null) {
                    positionLogListVO.setAvatar("");
                } else {
                    positionLogListVO.setAvatar(userAuth.getAvatar());
                }
                positionLogListVO.setName(oldPeople.getName());

                positionLogListVO.setSex(oldPeople.getSex());
                positionLogListVO.setStaff_id(oldStaff.getId());

                positionLogListVO.setFrom(a.getFrom());
                positionLogListVO.setReason(a.getReason());
                positionLogListVO.setTo(a.getTo());

                try {
                    positionLogListVO.setTime(DateUtil.reverse(a.getTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                list.add(positionLogListVO);
            }

            return list;
        }
        List<Staff> staffs = staffMapper.selectAll();
        for (Staff oldStaff : staffs) {
            if (oldStaff.getDeleted() == 1) {
                continue;
            }

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<PositionLog> oldPositions = positionLogMapper.selectByStaffId(oldStaff.getId());

            for (PositionLog a : oldPositions) {
                PositionLogListVO positionLogListVO = new PositionLogListVO();

                if (userAuth == null) {
                    positionLogListVO.setAvatar("");
                } else {
                    positionLogListVO.setAvatar(userAuth.getAvatar());
                }
                positionLogListVO.setName(oldPeople.getName());

                positionLogListVO.setSex(oldPeople.getSex());
                positionLogListVO.setStaff_id(oldStaff.getId());

                positionLogListVO.setFrom(a.getFrom());
                positionLogListVO.setReason(a.getReason());
                positionLogListVO.setTo(a.getTo());

                try {
                    positionLogListVO.setTime(DateUtil.reverse(a.getTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                list.add(positionLogListVO);
            }
        }
        return list;
    }

    /**
     * 应聘人员记录
     */
    public List<PeopleListVO> peopleUList() {
        // 找出所有没在 staff 中的 people id
        List<People> peoples = peopleMapper.selectAll();
        List<Object> pids = staffMapper.selectAll().stream().map((staff) -> staff.getPid())
                .collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Object obj : pids) {
            map.put((String) obj, 1);
        }
        List<PeopleListVO> list = new ArrayList<PeopleListVO>();
        for (People oldPeople : peoples) {
            if (!map.containsKey(oldPeople.getId())) {
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
        }
        return list;
    }

    /**
     * 工资
     */
    public List<SalaryListVO> salary(SalarySelectVO sVo) {
        List<SalaryListVO> list = new ArrayList();
        if (sVo.getStaff_id() != null && sVo.getStaff_id() != "") {
            Staff oldStaff = staffMapper.selectByPrimaryKey(sVo.getStaff_id());
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
                return list;
            }

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            List<Salary> salaries = salaryMapper.selectByStaffId(oldStaff.getId());

            for (Salary a : salaries) {
                SalaryListVO salaryListVO = new SalaryListVO();

                if (userAuth == null) {
                    salaryListVO.setAvatar("");
                } else {
                    salaryListVO.setAvatar(userAuth.getAvatar());
                }
                salaryListVO.setName(oldPeople.getName());

                salaryListVO.setSex(oldPeople.getSex());
                salaryListVO.setStaff_id(oldStaff.getId());

                salaryListVO.setBase(String.valueOf(a.getBase()));
                salaryListVO.setExtra(String.valueOf(a.getExtra()));
                salaryListVO.setBonus(String.valueOf(a.getBonus()));
                salaryListVO.setFine(String.valueOf(a.getFine()));
                salaryListVO.setTotal(String.valueOf(a.getTotal()));

                try {
                    salaryListVO.setTime(DateUtil.reverse(a.getTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                list.add(salaryListVO);
            }

            return list;
        }
        List<Salary> salaries = salaryMapper.selectAll();
        for (Salary a : salaries) {
            Staff oldStaff = staffMapper.selectByPrimaryKey(a.getStaffId());
            if (oldStaff == null || oldStaff.getDeleted() == 1) {
                return list;
            }

            UserAuth userAuth = userAuthMapper.selectByStaffId(oldStaff.getId());
            People oldPeople = peopleMapper.selectByPrimaryKey(oldStaff.getPid());

            SalaryListVO salaryListVO = new SalaryListVO();

            if (userAuth == null) {
                salaryListVO.setAvatar("");
            } else {
                salaryListVO.setAvatar(userAuth.getAvatar());
            }
            salaryListVO.setName(oldPeople.getName());

            salaryListVO.setSex(oldPeople.getSex());
            salaryListVO.setStaff_id(oldStaff.getId());

            salaryListVO.setBase(String.valueOf(a.getBase()));
            salaryListVO.setExtra(String.valueOf(a.getExtra()));
            salaryListVO.setBonus(String.valueOf(a.getBonus()));
            salaryListVO.setFine(String.valueOf(a.getFine()));
            salaryListVO.setTotal(String.valueOf(a.getTotal()));

            try {
                salaryListVO.setTime(DateUtil.reverse(a.getTime()));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            list.add(salaryListVO);
        }
        return list;

    }
}