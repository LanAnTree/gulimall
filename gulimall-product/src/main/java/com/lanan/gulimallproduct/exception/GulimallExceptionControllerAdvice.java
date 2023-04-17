package com.lanan.gulimallproduct.exception;

import com.lanan.common.entity.BizCodeEnum;
import com.lanan.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LanAn
 * @date 2022/7/5-11:37
 */
@RestControllerAdvice(basePackages = "com.lanan.gulimallproduct.controller")
public class GulimallExceptionControllerAdvice {
    /**
     * 处理数据校验异常
     * @date 2022/7/5 11:39
     * @param e
     * @return {@link R}
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>(2);
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMsg())
                .put("data", errorMap);
    }

    /**
     * 处理全局异常
     * @date 2022/7/5 11:39
     * @param throwable
     * @return {@link R}
     */
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        return R.error(BizCodeEnum.UNKNOW_EXEPTION.getCode(), BizCodeEnum.UNKNOW_EXEPTION.getMsg());
    }
}
