package com.fightingcrap.server.dao.entity;

import lombok.Data;

import java.io.Serializable;

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
 * | BaseEntity
 * |
 * | @author fightingcrap
 **/
@Data
/**
 * 基本实体类
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -5540280757494526466L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 状态值,不同类型的状态含义不一致，具体参考具体的枚举,通常为com.fightingcrap.server.api.enums.CommonStatusEnum
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long created;
    /**
     * 更新时间
     */
    private Long updated;
}
