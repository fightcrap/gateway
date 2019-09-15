package com.fightingcrap.server.service.service.limit;

import java.util.concurrent.TimeUnit;

/**
 * Create By fightingcrap On 2019/08/18
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
 * | LimitWayService
 * |
 * | @author fightingcrap
 **/
public interface LimitWayService {

    /**
     * 获取限流token，如果限流器没有初始化，那么会生成默认时间的限流器
     *
     * @param name
     * @param limit
     * @return
     */
    double getLimitToken(String name, Integer limit);

    /**
     * 获取限流token，如果限流器没有初始化，会按照传入时间，生成
     *
     * @param name
     * @param timeUnit
     * @param time
     * @param limit
     * @return
     */
    double getLimitToken(String name, TimeUnit timeUnit, int time, Integer limit);


    /**
     * 尝试获取限流token,如果限流器没有初始化，那么会生成默认时间的限流器
     *
     * @param name
     * @param limit
     * @return
     */
    boolean tryGetLimitToken(String name, Integer limit);

    /**
     * 尝试获取限流token,如果限流器没有初始化，会按照传入时间，生成
     *
     * @param name
     * @param timeUnit
     * @param time
     * @param limit
     * @return
     */
    boolean tryGetLimitToken(String name, TimeUnit timeUnit, int time, Integer limit);
}
