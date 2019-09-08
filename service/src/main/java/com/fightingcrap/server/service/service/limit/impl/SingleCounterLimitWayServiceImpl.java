package com.fightingcrap.server.service.service.limit.impl;

import com.fightingcrap.server.common.enums.LimitWayEnum;
import com.fightingcrap.server.service.annotation.Limit;
import com.fightingcrap.server.service.service.limit.LimitWayService;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
 * | CounterLimitWayServiceImpl
 * |
 * | @author fightingcrap
 **/
@Limit(LimitWayEnum.SINGLE_COUNTER_BUCKET)
public class SingleCounterLimitWayServiceImpl implements LimitWayService {
    @Override
    public double getLimitToken(String name) {
        return 0;
    }

    @Override
    public double getLimitToken(String name, double time) {
        return 0;
    }

    @Override
    public boolean tryGetLimitToken(String name) {
        return false;
    }

    @Override
    public boolean tryGetLimitToken(String name, double time) {
        return false;
    }


    private class CounterRateLimter {

        /**
         * 默认限制时间,为一秒
         */
        private static final long DEFAULT_LIMIT_TIME=1000;
        /**
         *  原子计数器,统计次数
         */
        private AtomicInteger atomicInteger;

        /**
         * 时间戳，如果已经过期，就按照当前时间开始
         */
        private long time;

        /**
         * 有效时间
         */
        private long expireTime;

        /**
         * 时间类型,用于计算
         */
        private TimeUnit timeUnit;
    }
}
