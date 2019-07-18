package manage.service;

import java.util.List;

import manage.model.VO.AttendantSelectVO;
import manage.model.VO.ContractSelectVO;
import manage.model.VO.DepartmentListVO;
import manage.model.VO.ProfileListVO;
import manage.model.VO.ProfileSelectVO;
import manage.model.VO.TrainInfoVO;
import manage.model.VO.TrainProgramVO;
import manage.model.VO.TrainSelectVO;

public interface ListService {
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
    List<ProfileSelectVO> contarct(ContractSelectVO pVo);

    /**
     * 考勤
     */
    List<ProfileSelectVO> attendant(AttendantSelectVO pVo);
}