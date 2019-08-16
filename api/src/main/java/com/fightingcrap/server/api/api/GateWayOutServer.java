package com.fightingcrap.server.api.api;

import com.fightingcrap.server.api.dto.GateWayCommonReqDTO;
import com.fightingcrap.server.common.dto.DefaultResponse;

/**
 * Create By fightingcrap On 2019/08/16
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
 * | GateWayOutServer
 * |
 * | @author fightingcrap
 **/
public interface GateWayOutServer {

    /**
     * 请求外部接口
     * @param gateWayCommonReqDTO
     * @return
     */
    public DefaultResponse<Object> requestOut(GateWayCommonReqDTO gateWayCommonReqDTO);
}
