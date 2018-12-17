package com.fightingcrap.server.impl;

import com.fightingcrap.server.dao.entity.Person;
import com.fightingcrap.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * | Test
 * |
 * | @author fightingcrap
 **/
@Service
public class Test {
    @Autowired
    private TestService testService;

    public Person getPersonById(Long id){
        return testService.getPersonById(id);
    }
}
