package com.shawn.exception;

import com.shawn.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
//        ex.printStackTrace();
        log.warn("出现异常", ex);
        return Result.error("操作失败");
    }
}
