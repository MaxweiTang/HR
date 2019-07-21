package manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import manage.model.VO.AttendantSelectVO;
import manage.model.VO.ContractSelectVO;
import manage.model.VO.PeopleSelectVO;
import manage.model.VO.PositionLogSelectVO;
import manage.model.VO.ProfileSelectVO;
import manage.model.VO.ResultVO;
import manage.model.VO.SalarySelectVO;
import manage.model.VO.StaffSelectVO;
import manage.model.VO.TrainSelectVO;
import manage.model.VO.UserInfoVO;
import manage.service.ListService;
import manage.util.ResultVOUtil;

@RestController
// @CrossOrigin(origins = "*", maxAge = 3600)
public class ListController {
    @Autowired
    ListService listService;

    // 员工信息
    @RequestMapping(value = "/staff/list", method = RequestMethod.POST)
    public ResultVO staff(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody StaffSelectVO sVo) {
        // 验证操作用户权限
        return ResultVOUtil.success(listService.staff(sVo));
    }

    // 培训项目
    @RequestMapping(value = "/program/list", method = RequestMethod.GET)
    public ResultVO program(@RequestAttribute("userid") UserInfoVO uVo) {
        // 验证权限
        return ResultVOUtil.success(listService.program());
    }

    // 培训
    @RequestMapping(value = "/train/list", method = RequestMethod.POST)
    public ResultVO train(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody TrainSelectVO tVo) {
        // 验证权限
        return ResultVOUtil.success(listService.train(tVo));
    }

    @RequestMapping(value = "/department/list", method = RequestMethod.GET)
    public ResultVO department(@RequestAttribute("userid") UserInfoVO uVo) {
        // 验证权限
        return ResultVOUtil.success(listService.department());
    }

    // 档案
    @RequestMapping(value = "/profile/list", method = RequestMethod.POST)
    public ResultVO profile(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody ProfileSelectVO profileSelectVO) {
        // 验证权限
        return ResultVOUtil.success(listService.profile(profileSelectVO));
    }

    // 合同
    @RequestMapping(value = "/contract/list", method = RequestMethod.POST)
    public ResultVO contract(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody ContractSelectVO cVo) {
        // 验证权限
        return ResultVOUtil.success(listService.contarct(cVo));
    }

    // 考勤
    @RequestMapping(value = "/attendant/list", method = RequestMethod.POST)
    public ResultVO attendant(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody AttendantSelectVO aVo) {
        // 验证权限
        return ResultVOUtil.success(listService.attendant(aVo));
    }

    @RequestMapping(value = "/people/list", method = RequestMethod.POST)
    public ResultVO train(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody PeopleSelectVO pVo) {
        // 验证用户权限
        return ResultVOUtil.success(listService.people(pVo));
    }

    @RequestMapping(value = "/position_log/list", method = RequestMethod.POST)
    public ResultVO positionLog(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody PositionLogSelectVO pVo) {
        // 验证用户权限
        return ResultVOUtil.success(listService.positionLog(pVo));
    }

    @RequestMapping(value = "/people/u-list", method = RequestMethod.GET)
    public ResultVO peopleUList(@RequestAttribute("userid") UserInfoVO uVo) {
        // 验证用户权限
        return ResultVOUtil.success(listService.peopleUList());
    }

    @RequestMapping(value = "/salary/list", method = RequestMethod.POST)
    public ResultVO salaryList(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody SalarySelectVO sVo) {
        // 验证用户权限
        return ResultVOUtil.success(listService.salary(sVo));
    }

}