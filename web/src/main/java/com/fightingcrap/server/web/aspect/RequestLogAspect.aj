package com.fightingcrap.server.web.aspect;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create By fightingcrap On 2019/01/07 
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
 * | RequestLogAspect
 * |
 * | @author fightingcrap
 **/
@Component
@Slf4j
public aspect RequestLogAspect {

    @Value("${spring.log:false}")
    private boolean isOpen;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)||@annotation(com.alibaba.dubbo.config.annotation.Service)")
    public void point() {

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
        log.info(className+":["+methodName+"],params:{}", JSONObject.toJSONString(args));
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
