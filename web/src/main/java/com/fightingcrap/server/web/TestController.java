package com.fightingcrap.server.web;

import com.fightingcrap.server.dao.entity.Person;
import com.fightingcrap.server.impl.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
 * | TestController
 * |
 * | @author fightingcrap
 **/
@RestController
public class TestController {


    @Autowired
    private Test test;

    @RequestMapping("/test")
    @ResponseBody
    public Person person(Long id){
        return test.getPersonById(id);
    }

}
