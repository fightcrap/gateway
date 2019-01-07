package com.fightingcrap.server.common.expection;

import com.fightingcrap.server.common.enums.ResultCode;

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
 * | ServiceCommonExpection
 * |
 * | @author fightingcrap
 **/
public class ServiceCommonExpection extends CommonExpection {

    public ServiceCommonExpection(int code,String message,String messageEn) {
        super(message);
        setCode(code);
        setMessage(message);
        setMessageEn(messageEn);
    }

    public ServiceCommonExpection(ResultCode resultCode){
        super(resultCode.getMessage());
        setCode(resultCode.getCode());
        setMessage(resultCode.getMessage());
        setMessageEn(resultCode.getMessageEn());
    }
}
