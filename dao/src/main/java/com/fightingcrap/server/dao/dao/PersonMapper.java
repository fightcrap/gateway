package com.fightingcrap.server.dao.dao;

import com.fightingcrap.server.dao.entity.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Create By fightingcrap On 2018/12/14
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | PersonMapper
 * |
 * | @author fightingcrap
 **/
public interface PersonMapper{
    public Person getById(@Param("id") Long id);
}
