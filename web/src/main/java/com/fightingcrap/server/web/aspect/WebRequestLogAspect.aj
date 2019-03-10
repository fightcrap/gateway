package com.fightingcrap.server.web.aspect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fightingcrap.server.common.dto.DefaultWebResponse;
import com.fightingcrap.server.common.enums.WebResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Create By fightingcrap On 2018/12/23 
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | WebRequestLogAspect  --web服务切面，用于打印web请求的入参和出参
 * |
 * | @author fightingcrap
 **/
@Component
@Slf4j
public aspect WebRequestLogAspect {

    @Value("${spring.weblog:false}")
    private boolean isOpen;

    @Value("${spring.web.expection.handle:false}")
    private boolean isHandleExpection;


    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void point() {

    }

    /**
     * 通用异常处理
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("point()")
    public Object commonExpection(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (!isHandleExpection) {
            return proceedingJoinPoint.proceed();
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("system error {}", throwable);
            //如果是内部异常，返回特定结果
            return DefaultWebResponse.buildResponse(WebResultCode.SYSTEM_ERROR, null);
        }
    }


    /**
     * 参数打印
     * @param joinPoint
     */
    @Before("point()")
    public void argsPrint(JoinPoint joinPoint) {
        if(!isOpen){
            return;
        }
        //先获取方法名称,类名称
        String methodName=joinPoint.getSignature().getName();
        String className=joinPoint.getTarget().getClass().getName();
        Object[] args=joinPoint.getArgs();
        //打印结果
        log.info(className+":["+methodName+"],params:{}",JSONObject.toJSONString(args));
    }

    /**
     * 返回值打印
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "point()",returning="result")
    public void resultPrint(JoinPoint joinPoint,Object result){
        //先获取方法名称,类名称
        String methodName=joinPoint.getSignature().getName();
        String className=joinPoint.getTarget().getClass().getName();

        log.info(className+":["+methodName+"],result:{}",JSONObject.toJSONString(result));
    }


}
