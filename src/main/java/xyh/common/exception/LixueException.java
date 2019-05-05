package xyh.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyh.common.enums.ResultEnum;
import xyh.common.result.ApiResult;
import xyh.common.result.ResultUtil;


/**
 * @author XiangYida
 * @version 2019/5/4 14:10
 */
@ControllerAdvice
@Slf4j
public class LixueException {
    //未知错误
    @ExceptionHandler(Throwable.class)
    public ApiResult myException(Throwable ex){
       log.error(ex.getMessage());
       return ResultUtil.failed();
    }

    //空指针异常
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ApiResult myException2(NullPointerException e){
        e.printStackTrace();
       return ResultUtil.failed(ResultEnum.NULL_POINTER_ERR);
    }
}
