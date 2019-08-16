package com.fightingcrap.server.impl.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fightingcrap.server.api.api.GateWayOutServer;
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
 * | GateWayOutServerImpl
 * |
 * | @author fightingcrap
 **/
@Service
public class GateWayOutServerImpl implements GateWayOutServer {
    @Override
    public DefaultResponse<Object> requestOut(GateWayCommonReqDTO gateWayCommonReqDTO) {
        return null;
    }
}
