package com.fightingcrap.server.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

/**
 * Create By fightingcrap On 2018/12/16
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
 * | FastJsonConfig
 * |
 * | @author fightingcrap
 **/
@Configuration
public class FastJsonConfigBean {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        //配置序列号相关规则
        //这边配置相关规则如下：格式化，数组为空则返回[], 数字为空则返回0，字符串为空则返回"",bool值默认返回false，其他可以自己进行配置，比如时间格式等 这边不建议配置时间～，毕竟要求还是不一致等
        fastJsonConfig.setSerializerFeatures(PrettyFormat,
                WriteNullListAsEmpty,
                WriteNullStringAsEmpty,
                WriteNullNumberAsZero,
                WriteNullBooleanAsFalse);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverters httpMessageConverters=new HttpMessageConverters(fastJsonHttpMessageConverter);
        return httpMessageConverters;

    }
}
