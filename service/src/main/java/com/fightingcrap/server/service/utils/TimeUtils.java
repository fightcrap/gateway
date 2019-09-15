package com.fightingcrap.server.service.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Create By fightingcrap On 2019/09/15
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
 * | TimeUtils
 * |
 * | @author fightingcrap
 **/
@Slf4j
public class TimeUtils {


    /**
     * 休眠毫秒时间
     *
     * @param time
     */
    public static void sleepTime(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            log.error("sleep time error", e);
        }
    }

}
