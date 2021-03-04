package com.itlg.excepion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(BusinessRuntimeException.class)
    public R businessRuntimeException(BusinessRuntimeException ex) {
        log.error("业务异常: {}", ex.getMessage());
        ex.printStackTrace();
        return R.fail(ex.getCodeMsg());
    }

    /**
     * 处理Exception
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R exception(Exception ex) {
        ex.printStackTrace();
        Throwable cause = ex.getCause();
        String msg;
        if (cause != null) {
            msg = cause.getMessage();
        } else {
            msg = ex.getMessage();
        }
        log.error("### 异常捕获: {}", msg);
        ex.getStackTrace();
        return R.fail(msg);
    }
}
