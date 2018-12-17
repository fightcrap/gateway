package com.fightingcrap.server.service;

import com.fightingcrap.server.dao.dao.PersonMapper;
import com.fightingcrap.server.dao.entity.Person;
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
 * | TestService
 * |
 * | @author fightingcrap
 **/
@Service
public class TestService {
    @Autowired
    private PersonMapper personMapper;

    public Person getPersonById(Long id){
        return personMapper.getById(id);
    }
}
