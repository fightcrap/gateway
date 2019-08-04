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
 * api链路模版，对于ApiLinkTemplate表
 */
public class ApiLinkTemplate extends BaseEntity implements Serializable {

    /**
     * 链路详情Id
     */
    private Long detailId;

    /**
     * 参数key，逗号分割
     */
    private String paramKey;

}