package manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manage.model.VO.ResultVO;
import manage.model.VO.StaffAttendantVO;
import manage.model.VO.StaffContractVO;
import manage.model.VO.StaffInfoVO;
import manage.model.VO.StaffNewVO;
import manage.model.VO.StaffProfileVO;
import manage.model.VO.StaffSelectVO;
import manage.model.VO.StaffTrainVO;
import manage.model.VO.StaffTransferVO;
import manage.model.VO.UserInfoVO;
import manage.service.StaffService;
import manage.util.ResultVOUtil;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 职员管理的 Controller
 */
@RestController
// @CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultVO update(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffInfoVO sInfoVO) {
        // 验证操作用户权限
        // 修改目标用户信息
        if (!staffService.update(sInfoVO)) {
            return ResultVOUtil.retSysError("更新员工信息失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "del", method = RequestMethod.POST)
    public ResultVO delete(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffInfoVO sInfoVO) {
        // 验证操作用户权限
        // 修改目标用户信息
        String staffId = sInfoVO.getId();
        if (staffId == null || staffId == "") {
            return ResultVOUtil.retSysError("必须包含目标员工");
        }
        if (!staffService.delete(staffId)) {
            return ResultVOUtil.retSysError("删除员工信息失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public ResultVO profile(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffProfileVO sVo) {
        // 验证用户权限
        // 修改档案信息
        if (!staffService.updateProfile(sVo)) {
            return ResultVOUtil.retSysError("更新档案信息失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "contract", method = RequestMethod.POST)
    public ResultVO contract(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffContractVO sVo) {
        // 验证用户权限
        // 添加合同
        if (!staffService.addContract(sVo)) {
            return ResultVOUtil.retSysError("添加合同失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "transfer", method = RequestMethod.POST)
    public ResultVO transfer(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffTransferVO sVo) {
        // 验证用户权限
        // 调动
        if (!staffService.transfer(sVo)) {
            return ResultVOUtil.retSysError("调度员工失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "train", method = RequestMethod.POST)
    public ResultVO train(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffTrainVO sVo) {
        // 验证用户权限
        // 培训
        if (!staffService.train(sVo)) {
            return ResultVOUtil.retSysError("添加培训信息失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "attendant", method = RequestMethod.POST)
    public ResultVO attendant(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffAttendantVO sVo) {
        // 验证用户权限
        // 培训
        if (!staffService.attendant(sVo)) {
            return ResultVOUtil.retSysError("添加考勤信息失败");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ResultVO staffNew(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffNewVO sVo) {
        // 验证用户权限
        // 培训
        if (!staffService.staffNew(sVo)) {
            return ResultVOUtil.retSysError("添加员工信息失败");
        }
        return ResultVOUtil.success();
    }
}