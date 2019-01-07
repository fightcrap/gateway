package com.fightingcrap.server.common.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By fightingcrap On 2018/12/23
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
 * | WebResultCode  --web返回状态码枚举
 * |
 * | @author fightingcrap
 **/
public enum WebResultCode {
    SUCCESS(1001, 1001, "调用成功/通过", "call succeed"),
    SYSTEM_ERROR(999999, 999999, "系统出现故障了，请联系相关人员查看", "There is something wrong with the system, please contact relevant personnel to check"),
    PARAM_ERROR(999998, 999998, "您输入的参数不对/不足，请检查确认", "The parameters you entered are incorrect/insufficient, please check and confirm");

    /**
     * 状态码
     */
    private int code;

    /**
     * 内部状态码,可以把内部服务状态码转化为web状态码
     */
    private Integer insideCode;

    /**
     * 中文信息
     */
    private String message;

    /**
     * 英文信息
     */
    private String messageEn;

    private static Map<Integer, WebResultCode> map = new HashMap<>();

    private static void init() {
        for (WebResultCode webResultCode : WebResultCode.values()) {
            //判断key是否重复存在
            // todo 存在重复key 应该出现告警，打印warn，
//            if(map.containsKey(webResultCode.insideCode)){
//
//            }
            map.put(webResultCode.insideCode, webResultCode);

        }
    }

    public static WebResultCode transformServiceCode(ResultCode resultCode) {
        if (resultCode == null) {
            return null;
        }
        return map.get(resultCode.getCode());
    }


    WebResultCode(int code, Integer insideCode, String message, String messageEn) {
        this.code = code;
        this.insideCode = insideCode;
        this.message = message;
        this.messageEn = messageEn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getInsideCode() {
        return insideCode;
    }

    public void setInsideCode(Integer insideCode) {
        this.insideCode = insideCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }
}
