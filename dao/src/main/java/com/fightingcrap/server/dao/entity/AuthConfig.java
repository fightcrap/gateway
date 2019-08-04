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
 * 应用鉴权表,对于authConfig表
 */
public class AuthConfig extends BaseEntity implements Serializable {

    /**
     * appKey。
     */
    private String appKey;

    /**
     * app私钥
     */
    private String secretKey;

    /**
     * 私钥加盐
     */
    private String salt;

}