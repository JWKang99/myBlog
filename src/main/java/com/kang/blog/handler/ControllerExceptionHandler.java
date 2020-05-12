package com.kang.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 统一处理异常的类
 * @ControllerAdvice 会拦截所有标注有@Controller注解的控制器
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    //作为日志记录异常
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * @ExceptionHandler()表示该方法是做异常处理的
     * @param request 客户端访问的页面的request
     * @param e 产生的异常
     * @return 返回一个错误页面，包括一些错误信息
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        //记录异常信息
        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e.getMessage());
        //判断是否存在表示状态码的Exception注解，若有就交给springboot处理
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null) {
            throw e;
        }
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }
}
