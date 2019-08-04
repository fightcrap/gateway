package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.ApiLinkDetail;
import org.apache.ibatis.annotations.Param;

/**
 * 对应apiLinkDetail表
 */
public interface ApiLinkDetailDAO {

   /**
    * 根据Id查询
    * @param id
    * @return
    */
   public ApiLinkDetail getById(@Param("id") Long id);

   /**
    * 保存
    * @param apilinkdetail
    * @return
    */
   public int save(ApiLinkDetail apilinkdetail);

   /**
    * 更新
    * @param apilinkdetail
    * @return
    */
   public int update(ApiLinkDetail apilinkdetail);

   /**
    * 删除（逻辑删除）
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}