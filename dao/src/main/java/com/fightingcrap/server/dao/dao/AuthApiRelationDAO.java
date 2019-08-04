package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.AuthApiRelation;
import org.apache.ibatis.annotations.Param;

/**
 * 对于鉴权/链路关系表,对应authApiRelation表
 */
public interface AuthApiRelationDAO {
   /**
    * 根据id查询
    * @param id
    * @return
    */
   public AuthApiRelation getById(@Param("id") Long id);

   /**
    * 保存
    * @param authapirelation
    * @return
    */
   public int save(AuthApiRelation authapirelation);

   /**
    * 更新
    * @param authapirelation
    * @return
    */
   public int update(AuthApiRelation authapirelation);

   /**
    * 删除。（逻辑删除)
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}