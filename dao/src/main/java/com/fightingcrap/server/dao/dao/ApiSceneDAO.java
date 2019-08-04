package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.ApiScene;
import org.apache.ibatis.annotations.Param;

/**
 * api场景表
 */
public interface ApiSceneDAO {
   /**
    * 根据id查询
    * @param id
    * @return
    */
   public ApiScene getById(@Param("id") Long id);

   /**
    * 保存
    * @param apiscene
    * @return
    */
   public int save(ApiScene apiscene);

   /**
    * 更新
    * @param apiscene
    * @return
    */
   public int update(ApiScene apiscene);

   /**
    * 删除　（逻辑删除)
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}