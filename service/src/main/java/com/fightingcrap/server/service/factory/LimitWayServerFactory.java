package com.fightingcrap.server.service.factory;

import com.fightingcrap.server.common.enums.LimitWayEnum;
import com.fightingcrap.server.common.enums.ResultCode;
import com.fightingcrap.server.common.expection.ServiceCommonExpection;
import com.fightingcrap.server.service.service.limit.LimitWayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;

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
 * | LimitWayFactory
 * |
 * | @author fightingcrap
 **/
public class LimitWayServerFactory {

    private Logger logger = LoggerFactory.getLogger(LimitWayServerFactory.class);


    private HashMap<Integer, LimitWayService> limitServerMaps = new HashMap<>();

    public LimitWayService getServerByEnum(LimitWayEnum limitWayEnum) {

        if (limitWayEnum == null) {
            logger.error("limitWayServer factory param is empty");
            throw new ServiceCommonExpection(ResultCode.LIMIT_WAY_IS_NULL);
        }

        LimitWayService limitWayService = limitServerMaps.get(limitWayEnum.getValue());

        if(limitWayService==null){
            logger.warn("limitWayServer get empty server,limitWay code:",limitWayEnum.getValue());
        }
        return limitWayService;
    }


}
