package manage.service;

import java.util.List;

import manage.model.DTO.LoginDTO;
import manage.model.VO.UserAuthVO;

public interface UserService {

	// 验证用户身份
	LoginDTO validateUser(UserAuthVO uVo);

	/**
	 * 修改密码 成功返回null，失败返回原因
	 */
	String newPass(String userId, String newPass);

}
