package com.fightingcrap.server.common.dto;

import com.fightingcrap.server.common.enums.ResultCode;
import com.fightingcrap.server.common.enums.WebResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

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
 * | DefaultWebResponse  --默认的web返回体
 * |
 * | @author fightingcrap
 **/
@Data
@Builder
@AllArgsConstructor
public class DefaultWebResponse<T> implements Serializable {

    private static final long serialVersionUID = -8126120883503036866L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息体
     */
    private String message;

    /**
     * 实体信息
     */
    private T data;

    /**
     * 构建返回体
     *
     * @param data
     * @param <T>
     * @return
     */


    public static <T> DefaultWebResponse<T> buildResponse(WebResultCode webResultCode, T data) {
        DefaultWebResponse<T> defaultWebResponse = new DefaultWebResponse<>(webResultCode.getCode(), webResultCode.getMessage(), data);
        return defaultWebResponse;
    }

    /**
     * 构建返回体
     *
     * @param data
     * @param <T>
     * @return
     */


    public static <T> DefaultWebResponse<T> buildResponseByServiceCode(ResultCode resultCode, T data) {

        WebResultCode webResultCode = WebResultCode.transformServiceCode(resultCode);
        DefaultWebResponse<T> defaultWebResponse = new DefaultWebResponse<>(webResultCode.getCode(), webResultCode.getMessage(), data);
        return defaultWebResponse;
    }

    /**
     * 构建返回体
     *
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> DefaultWebResponse<T> buildResponse(int code, String message, T data) {
        return new DefaultWebResponse<>(code, message, data);
    }


}
