package com.fightingcrap.server.service.service.limit.impl;

import com.fightingcrap.server.common.enums.LimitWayEnum;
import com.fightingcrap.server.service.annotation.Limit;
import com.fightingcrap.server.service.service.limit.LimitWayService;
import com.fightingcrap.server.service.utils.TimeUtils;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
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

    private ConcurrentHashMap<String, CounterRateLimter> map = new ConcurrentHashMap();

    @Override
    public double getLimitToken(String name, Integer limit) {
        return getLimitToken(name, TimeUnit.SECONDS, 1, limit);
    }

    @Override
    public double getLimitToken(String name, TimeUnit timeUnit, int time, Integer limit) {
        CounterRateLimter counterRateLimter = getLimiter(name,
                timeUnit,
                time,
                limit == null ? CounterRateLimter.DEFAULT_LIMIT_COUNT : limit);

        return counterRateLimter.getToken();
    }

    @Override
    public boolean tryGetLimitToken(String name, Integer limit) {
        return tryGetLimitToken(name, TimeUnit.SECONDS, 1, limit);
    }

    @Override
    public boolean tryGetLimitToken(String name, TimeUnit timeUnit, int time, Integer limit) {
        CounterRateLimter counterRateLimter = getLimiter(name, timeUnit, time, limit == null ? CounterRateLimter.DEFAULT_LIMIT_COUNT : limit);
        return counterRateLimter.tryGetToken();
    }


    private CounterRateLimter getLimiter(String name, TimeUnit timeUnit, int time, int limit) {
        CounterRateLimter counterRateLimter = map.get(name);
        if (counterRateLimter != null) {
            return counterRateLimter;
        }

        synchronized (name) {
            if (counterRateLimter != null) {
                return counterRateLimter;
            }
            counterRateLimter = new CounterRateLimter(timeUnit.toMillis(time), limit);
        }

        return counterRateLimter;

    }

    private class CounterRateLimter {

        /**
         * 默认限制时间,为一秒
         */
        private static final long DEFAULT_LIMIT_TIME = 1000;

        private static final int DEFAULT_LIMIT_COUNT = 16;
        /**
         * 原子计数器,统计次数
         */
        private AtomicInteger atomicInteger = new AtomicInteger();

        /**
         * 时间戳，如果已经过期，就按照当前时间开始
         */
        private volatile long time;

        /**
         * 有效时间
         */
        private long expireTime;


        private Integer limit;


        public CounterRateLimter(Integer limit) {
            this.limit = limit;
            expireTime = DEFAULT_LIMIT_TIME;
        }

        public CounterRateLimter(long expireTime, Integer limit) {
            this.expireTime = expireTime;
            this.limit = limit;
        }


        /**
         * 尝试获取令牌
         *
         * @return
         */
        public boolean tryGetToken() {

            //isOverTime是线程安全的，也会重新变更时间。
            if (isOverTime()) {
                atomicInteger.getAndSet(0);
            }
            int count = atomicInteger.incrementAndGet();
            if (count > limit) {
                return false;
            }
            return true;
        }


        /**
         * 获取token，会休眠时间，直到成功
         *
         * @return
         */
        public double getToken() {
            long intervalTime = 0L;
            for (; ; ) {
                boolean result = tryGetToken();
                if (result) {
                    return intervalTime / 1000;
                }
                //如果获取不到，则休眠继续获取
                long sleepTime = expireTime + time - System.currentTimeMillis();
                //如果时间小，则继续
                if (sleepTime < 0L) {
                    continue;
                }
                intervalTime += sleepTime;
                TimeUtils.sleepTime(sleepTime);
            }

        }


        /**
         * 判断是否超时，如果超时并重置时间
         *
         * @return
         */
        private synchronized boolean isOverTime() {
            //先判断时间有没有过期
            if (System.currentTimeMillis() > expireTime + time) {
                //并把时间设置为当前时间
                expireTime = System.currentTimeMillis();
                return true;
            }
            return false;
        }
    }
}
