package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.OutChannelConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 外部渠道配置表　，对应outChannelConfig表
 */
public interface OutChannelConfigDAO {

   /**
    * 根据id获取
    * @param id
    * @return
    */
   public OutChannelConfig getById(@Param("id") Long id);

   /**
    * 保存
    * @param outchannelconfig
    * @return
    */
   public int save(OutChannelConfig outchannelconfig);

   /**
    * 更新
    * @param outchannelconfig
    * @return
    */
   public int update(OutChannelConfig outchannelconfig);

   /**
    * 删除（逻辑删除)
    * @param id
    * @return
    */
   public int deleteById(@Param("id") Long id);


}