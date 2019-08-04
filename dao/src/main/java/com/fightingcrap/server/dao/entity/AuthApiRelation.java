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
 * 对于authApiRelation表，鉴权表和链路表的关系
 */
public class AuthApiRelation extends BaseEntity  implements Serializable {

    /**
     * 鉴权表Id
     */
    private Long authId;

    /**
     * api链路表Id
     */
    private Long linkId;

 
 }