package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.ApiLinkTemplate;
import org.apache.ibatis.annotations.Param;

/**
 * 对于apiLinkTemplate表
 */
public interface ApiLinkTemplateDAO {

   /**
    * 根据id查询
    * @param id
    * @return
    */
   public ApiLinkTemplate getById(@Param("id") Long id);

   /**
    * 保存
    * @param apilinktemplate
    * @return
    */
   public int save(ApiLinkTemplate apilinktemplate);

   /**
    * 更新
    * @param apilinktemplate
    * @return
    */
   public int update(ApiLinkTemplate apilinktemplate);

   /**
    * 删除(逻辑删除）
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}