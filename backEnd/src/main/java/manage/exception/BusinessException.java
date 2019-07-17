package manage.exception;
import manage.constant.*;

public class BusinessException extends RuntimeException {

	private Integer code;

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * 通常情况都使用改构造方法
	 * 
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
		code = ResultEnum.BUSINESS_EXCEPTION.getCode();
	}

	/**
	 * 最高级别的异常使用此构造方法（基本不使用）
	 * 
	 * @param resultEnum
	 */
	// public BusinessException(ResultEnum resultEnum) {
	// 	super(resultEnum.getMsg());
	// 	code = resultEnum.getCode();
	// }

	// public BusinessException(ResultEnum resultEnum,String msg) {
	// 	super(msg);
	// 	code = resultEnum.getCode();
	// }
}
