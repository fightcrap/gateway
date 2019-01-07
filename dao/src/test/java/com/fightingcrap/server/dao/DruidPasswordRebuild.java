package com.fightingcrap.server.dao;

import com.alibaba.druid.filter.config.ConfigTools;

import java.util.Scanner;

/**
 * Create By fightingcrap On 2019/01/07
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
 * | DruidPasswordRebuild
 * |
 * | @author fightingcrap
 **/
public class DruidPasswordRebuild {
    public static void main(String[] args) throws Exception {

        //密码明文
        Scanner scanner=new Scanner(System.in);
        String password =scanner.nextLine();


        System.out.println("密码[ " + password + " ]的加密信息如下：\n");


        String[] keyPair = ConfigTools.genKeyPair(512);

        //私钥

        String privateKey = keyPair[0];

        //公钥

        String publicKey = keyPair[1];

        //用私钥加密后的密文

        password = ConfigTools.encrypt(privateKey, password);


        System.out.println("privateKey:" + privateKey);

        System.out.println("publicKey:" + publicKey);

        System.out.println("password:" + password);

        String decryptPassword = ConfigTools.decrypt(publicKey, password);

        System.out.println("decryptPassword：" + decryptPassword);
    }


}
