package manage.service;

import java.util.List;

import manage.model.VO.StaffAttendantVO;
import manage.model.VO.StaffContractVO;
import manage.model.VO.StaffInfoVO;
import manage.model.VO.StaffListVO;
import manage.model.VO.StaffNewVO;
import manage.model.VO.StaffProfileVO;
import manage.model.VO.StaffSelectVO;
import manage.model.VO.StaffTrainVO;
import manage.model.VO.StaffTransferVO;

/**
 * 职员的服务
 */
public interface StaffService {

    List<StaffListVO> list(StaffSelectVO sVo);

    boolean update(StaffInfoVO sVo);

    boolean delete(String staffId);

    // 追加相关信息到原文档
    boolean updateProfile(StaffProfileVO sVo);

    // 添加合同信息，并根据新职位，添加职位变化记录，更新当前职位
    boolean addContract(StaffContractVO sVo);

    // 调动员工，记得更新 staff 表当前指向的职位
    boolean transfer(StaffTransferVO sVo);

    boolean train(StaffTrainVO sVo);

    boolean attendant(StaffAttendantVO sVo);

    boolean staffNew(StaffNewVO sVo);
}
