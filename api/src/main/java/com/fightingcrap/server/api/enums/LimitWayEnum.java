package com.fightingcrap.server.api.enums;

/**
 * Create By fightingcrap On 2019/08/04
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
 * | LimitWayEnum --限流方式枚举
 * |
 * | @author fightingcrap
 **/
public enum  LimitWayEnum {

    NONE(0,"不限制"),
    SINGLE_LEAKY_BUCKET(1,"单机版漏桶法"),
    SINGLE_TOKEN_BUCKET(2,"单机版令牌法"),
    DISTRIBUTED_LEAKY_BUCKET(3,"分布式漏桶法"),
    DISTRIBUTED_TOKEN_BUCKET(4,"分布式令牌法");

    private int value;

    private String message;

    LimitWayEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
