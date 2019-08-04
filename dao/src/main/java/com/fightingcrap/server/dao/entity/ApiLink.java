package com.fightingcrap.server.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 对应表apiLink，api链路表
 */
public class ApiLink extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7378849487945339278L;
    /**
     * 外部配置id，对应OutChannelConfig配置
     */
    private Long outConfigId;
    /**
     * 名称
     */
    private String name;
    /**
     * 协议类型，参考枚举
     */
    private Integer protocol;
    /**
     * 限流数/秒
     */
    private Integer limit;
    /**
     * 限流方式，参考枚举
     */
    private Integer limitWay;
    /**
     * 缓存时间
     */
    private Integer cacheTime;
    /**
     * 场景Id
     */
    private Long sceneId;


}