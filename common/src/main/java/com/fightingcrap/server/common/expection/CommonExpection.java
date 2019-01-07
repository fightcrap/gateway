package com.fightingcrap.server.common.expection;

import lombok.Data;

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
 * | CommonExpection
 * |
 * | @author fightingcrap
 **/
@Data
public class CommonExpection extends RuntimeException{

    private int code;

    private String message;

    private String messageEn;

    public CommonExpection(String message) {
        super(message);
    }
}
