package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.AuthConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 鉴权配置表，对于authConfig表
 */
public interface AuthConfigDAO {

   /**
    * 根据id获取
    * @param id
    * @return
    */
   public AuthConfig getById(@Param("id") Long id);

   /**
    * 保存
    * @param authconfig
    * @return
    */
   public int save(AuthConfig authconfig);

   /**
    * 更新
    * @param authconfig
    * @return
    */
   public int update(AuthConfig authconfig);

   /**
    * 删除（逻辑删除）
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}