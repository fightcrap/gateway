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
 * 对于apiLinkDetail表 链路详情表
 */
public class ApiLinkDetail extends BaseEntity implements Serializable {
    /**
     * 链路id 对应apiLink表主键
     */
    private Long linkId;
    /**
     * 管道名称
     */
    private String pipeName;
    /**
     * 参数:准确来说这个是个map结构，但是存储是String
     */
    private String param;

}