package com.fightingcrap.server.common.dto;

import com.fightingcrap.server.common.enums.ResultCode;
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
 * | DefaultResponse  --默认返回结构体
 * |
 * | @author fightingcrap
 **/
@Data
public class DefaultResponse<T> implements Serializable {


    private static final long serialVersionUID = -7460512700990022143L;

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
     * 是否成功调用
     */
    private boolean isSuccess;

    public DefaultResponse(int code, String message, T data) {
        this.isSuccess = ResultCode.SUCCESS.getCode() == code;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DefaultResponse(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.data = data;
        this.message = resultCode.getMessage();
        this.isSuccess = ResultCode.SUCCESS.getCode() == this.code;
    }

    /**
     * 构建返回体
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> DefaultResponse<T> buildResponse(ResultCode resultCode, T data) {
        return new DefaultResponse<>(resultCode, data);
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
    public static <T> DefaultResponse<T> buildResponse(int code, String message, T data) {
        return new DefaultResponse<>(code, message, data);
    }


}
