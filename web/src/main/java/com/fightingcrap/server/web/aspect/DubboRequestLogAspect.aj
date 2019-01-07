package com.fightingcrap.server.web.aspect;

import com.fightingcrap.server.common.dto.DefaultWebResponse;
import com.fightingcrap.server.common.enums.WebResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
 * | DubboRequestLogAspect  --dubbo服务端处理日志
 * |
 * | @author fightingcrap
 **/
@Component
@Slf4j
public aspect DubboRequestLogAspect {


    @Value("${spring.dubbo.expection.handle:false}")
    private boolean isHandleExpection;

    @Pointcut("@annotation(com.alibaba.dubbo.config.annotation.Service)")
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

}
