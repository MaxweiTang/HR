package manage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import manage.model.VO.*;
import manage.util.ResultVOUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@ControllerAdvice
public class BaseExceptionHandle {
	private static Logger logger = LogManager.getLogger(BaseExceptionHandle.class);

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ResultVO handleBusinessException(BusinessException e) {
		logger.error(e.getMessage(), e);
		return ResultVOUtil.error(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultVO handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return ResultVOUtil.retSysError(e.getMessage());
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResultVO handleThrowable(Throwable e) {
		logger.error(e.getMessage(), e);
		return ResultVOUtil.retSysError();
	}
}
