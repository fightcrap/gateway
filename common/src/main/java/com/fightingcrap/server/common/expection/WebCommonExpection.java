package com.fightingcrap.server.common.expection;

import com.fightingcrap.server.common.enums.ResultCode;
import com.fightingcrap.server.common.enums.WebResultCode;
import lombok.extern.slf4j.Slf4j;

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
 * | WebCommonExpection --web服务通用异常类
 * |
 * | @author fightingcrap
 **/
public class WebCommonExpection extends CommonExpection {

    public WebCommonExpection(int code, String message, String messageEn) {
        super(message);
        setCode(code);
        setMessage(message);
        setMessageEn(messageEn);
    }

    public WebCommonExpection(WebResultCode resultCode) {
        super(resultCode.getMessage());
        setCode(resultCode.getCode());
        setMessage(resultCode.getMessage());
        setMessageEn(resultCode.getMessageEn());
    }

    public static WebCommonExpection BuildServiceCodeTransormWebCode(ResultCode resultCode) {
        //判断是否存在resultcode
        if (resultCode == null) {
            throw new NullPointerException("resultCode 传入值为null");
        }
        //获取转化后的WebCode
        WebResultCode webResultCode = WebResultCode.transformServiceCode(resultCode);
        return new WebCommonExpection(webResultCode);

    }
}
