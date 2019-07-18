package manage.service;

import java.util.List;

import manage.base.BaseService;
import manage.model.DTO.LoginDTO;
import manage.model.VO.UserAuthVO;
import manage.util.PageInfo;

public interface UserService<T> extends BaseService<T> {

	// 验证用户身份
	LoginDTO validateUser(UserAuthVO uVo);

	/**
	 * 修改密码 成功返回null，失败返回原因
	 */
	String newPass(String userId, String newPass);

}
