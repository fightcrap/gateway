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
 * Api场景表,对于ApiScene
 */
public class ApiScene extends BaseEntity  implements Serializable {

    /**
     * 链路场景名称
     */
    private String name;

    /**
     * 限流数/秒
     */
    private Integer limit;

    /**
     * 限流方式,具体参考枚举值
     */
    private Integer limitWay;
 
 }