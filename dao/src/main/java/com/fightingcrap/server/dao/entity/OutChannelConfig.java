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
 * 外部渠道配置信息
 */
public class OutChannelConfig extends BaseEntity implements Serializable {

    /**
     * 第三方appKey
     */
    private String thirdKey;
    /**
     * 第三方密钥
     */
    private String thirdSecret;
    /**
     * 来源
     */
    private String source;

    /**
     * 扩展信息
     */
    private String exectInfo;
}