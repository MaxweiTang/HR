package manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import manage.model.VO.PeopleSelectVO;
import manage.model.VO.PeopleVO;
import manage.model.VO.ResultVO;
import manage.model.VO.UserInfoVO;
import manage.service.ListService;
import manage.service.PeopleService;
import manage.util.ResultVOUtil;

@RequestMapping(value = "people")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ResultVO train(@RequestAttribute("userid") UserInfoVO uVo, @RequestBody PeopleVO pVo) {
        // 验证用户权限
        // 培训
        if (!peopleService.newPeople(pVo)) {
            return ResultVOUtil.retSysError("添加人员信息失败");
        }
        return ResultVOUtil.success();
    }

}