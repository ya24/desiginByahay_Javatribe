package cn.ya.javatribe.controller.advice;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ya on 2017/4/15.
 * 对无权限异常的增强
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class UnAuthorizedAdvice {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleUnAuthorized(){
        return "redirect:/refuse";
    }
}
