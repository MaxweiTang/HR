package manage.service;

import java.util.List;

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

public interface ListService {

    // 若 pvo 设置了 peole_id，选择特定用户的ID
    List<PeopleListVO> people(PeopleSelectVO pVo);

    List<StaffListVO> staff(StaffSelectVO sVo);

    /**
     * 
     * @return 如果没有返回空 List
     */
    List<TrainProgramVO> program();

    /**
     * 根据过滤条件得到培训信息
     */
    List<TrainInfoVO> train(TrainSelectVO tVo);

    /**
     * 返回部门信息
     */
    List<DepartmentListVO> department();

    /**
     * 档案
     */
    List<ProfileListVO> profile(ProfileSelectVO pVo);

    /**
     * 合同
     */
    List<ContractListVO> contarct(ContractSelectVO cVo);

    /**
     * 考勤
     */
    List<AttendantListVO> attendant(AttendantSelectVO aVo);

    /**
     * 职位记录
     */
    List<PositionLogListVO> positionLog(PositionLogSelectVO aVo);

    /**
     * 应聘人员记录
     */
    List<PeopleListVO> peopleUList();

    /**
     * 工资
     */
    List<SalaryListVO> salary(SalarySelectVO sVo);
}