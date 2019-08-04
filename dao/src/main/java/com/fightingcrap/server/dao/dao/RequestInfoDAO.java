package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.RequestInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 请求记录表，对应requestInfo表
 */
public interface RequestInfoDAO {

   /**
    * 根据id查询
    * @param id
    * @return
    */
   public RequestInfo getById(@Param("id") Long id);

   /**
    * 保存
    * @param requestinfo
    * @return
    */
   public int save(RequestInfo requestinfo);

   /**
    * 更新
    * @param requestinfo
    * @return
    */
   public int update(RequestInfo requestinfo);

   /**
    * 删除
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}