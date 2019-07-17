package manage.util;

import manage.model.VO.*;
import manage.constant.*;

public class ResultVOUtil {


    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMsg());
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }

    /**
     * 返回系统异常
     * 
     * @return
     */
    public static ResultVO retSysError() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.BUSINESS_EXCEPTION.getCode());
        resultVO.setMsg(ResultEnum.BUSINESS_EXCEPTION.getMsg());
        return resultVO;
    }

    /**
     * 返回自定义错误信息的异常
     * 
     * @param msg 自定义错误信息
     */
    public static ResultVO retSysError(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.BUSINESS_EXCEPTION.getCode());
        resultVO.setMsg(msg);
        return resultVO;
    }
}
