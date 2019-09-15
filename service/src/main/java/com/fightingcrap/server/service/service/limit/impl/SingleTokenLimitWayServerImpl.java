package com.fightingcrap.server.service.service.limit.impl;

import com.fightingcrap.server.common.constant.LimitWayConstants;
import com.fightingcrap.server.common.enums.LimitWayEnum;
import com.fightingcrap.server.service.annotation.Limit;
import com.fightingcrap.server.service.service.limit.LimitWayService;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Create By fightingcrap On 2019/09/08
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
 * | UnitTokenLimitWayServerImpl
 * |
 * | @author fightingcrap
 **/
@Limit(LimitWayEnum.SINGLE_TOKEN_BUCKET)
public class SingleTokenLimitWayServerImpl implements LimitWayService {

    private ConcurrentHashMap<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();


    @Override
    public double getLimitToken(String name, Integer limit) {

        return getLimitToken(name, TimeUnit.SECONDS, 1, limit);
    }

    @Override
    public double getLimitToken(String name, TimeUnit timeUnit, int time, Integer limit) {
        double limitTime = (limit == null ? LimitWayConstants.DEFAULT_LIMIT_RATE : limit) / timeUnit.toSeconds(time);
        RateLimiter rateLimiter = getRateLimiter(name, limitTime);

        return rateLimiter.acquire();
    }


    @Override
    public boolean tryGetLimitToken(String name, Integer limit) {
        return tryGetLimitToken(name, TimeUnit.MINUTES, 1, limit);
    }

    @Override
    public boolean tryGetLimitToken(String name, TimeUnit timeUnit, int time, Integer limit) {
        double limitTime = (limit == null ? LimitWayConstants.DEFAULT_LIMIT_RATE : limit) / timeUnit.toSeconds(time);
        RateLimiter rateLimiter = getRateLimiter(name, limitTime);
        return rateLimiter.tryAcquire();
    }


    /**
     * 获取限流器
     *
     * @param name
     * @param time
     * @return
     */
    private RateLimiter getRateLimiter(String name, double time) {
        RateLimiter rateLimiter = rateLimiterMap.get(name);
        if (rateLimiter != null) {
            return rateLimiter;
        }

        //如果不存在，则新创建
        rateLimiter = RateLimiter.create(time);
        rateLimiterMap.put(name, rateLimiter);
        return rateLimiter;
    }


    /**
     * 获取令牌
     *
     * @param name
     * @param time
     * @return
     */
    private double getToken(String name, double time) {
        RateLimiter rateLimiter = getRateLimiter(name, time);

        checkRateLimiter(rateLimiter);

        return rateLimiter.acquire();
    }


    /**
     * 校验控制器为null，正常来说不太可能
     *
     * @param rateLimiter
     */
    private void checkRateLimiter(RateLimiter rateLimiter) {
        if (rateLimiter == null) {
            throw new RuntimeException("get rateLimit error");
        }
    }
}
