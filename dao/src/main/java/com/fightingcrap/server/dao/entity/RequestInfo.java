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
 * 请求信息记录表，对于requestInfo表
 */
public class RequestInfo extends BaseEntity  implements Serializable {
    /**
     * 应用appKey
     */
    private String appKey;

    /**
     * 链路id
     */
    private Long linkId;

    /**
     * 链路流水号
     */
    private String pipelineId;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 请求结果
     */
    private String result;

 
 }