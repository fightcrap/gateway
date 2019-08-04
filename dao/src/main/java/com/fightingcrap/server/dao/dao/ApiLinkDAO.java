package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.ApiLink;
import org.apache.ibatis.annotations.Param;

/**
 * apiLink表
 */
public interface ApiLinkDAO {

   /**
    * 根据id查询
    * @param id
    * @return
    */
   public ApiLink getById(@Param("id") Long id);

   /**
    * 保存
    * @param apilink
    * @return
    */
   public int save(ApiLink apilink);

   /**
    * 更新
    * @param apilink
    * @return
    */
   public int update(ApiLink apilink);

   /**
    * 删除(逻辑删除)
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}