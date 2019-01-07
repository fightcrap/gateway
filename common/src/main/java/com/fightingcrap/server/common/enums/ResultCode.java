package com.fightingcrap.server.common.enums;

import lombok.Data;

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
 * | ResultCode  --返回code编码
 * |
 * | @author fightingcrap
 **/
public enum ResultCode {

    /**
     * 系统层次异常,99开头为异常,默认6位数返回码
     */
    SUCCESS(1001,"调用成功/通过","call succeed"),
    SYSTEM_ERROR(999999,"系统异常","system error"),
    PARAM_ERROR(999998,"参数异常","param error"),
    IDEMPOTENT(999997, "幂等性异常", "Idempotent anomaly"),
    DB_EXCEPTION(
            999996, "数据库异常", "db error");

    /**
     * 状态码
     */
    private int code;

    /**
     * 中文信息
     */
    private String message;

    /**
     * 英文信息
     */
    private String messageEn;

    ResultCode(int code, String message, String messageEn) {
        this.code = code;
        this.message = message;
        this.messageEn = messageEn;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }
}
