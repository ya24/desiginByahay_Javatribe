package cn.ya.javatribe.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by 叶雅芳 on 2017/3/21.
 * 对密码进行加密处理
 */
public class Encryption {

    // 产生随机数，作为盐
    public static String createSalt(){
        // 使用1-100的随机数和当前系统时间的拼接方式
        int x=(int)(Math.random()*100);
        long timeMillis = System.currentTimeMillis();
        String salt = x + "" + timeMillis;
        return salt;
    }

    // 原始密码 + 盐 = 加密后的密码
    public static String md5encryption(String password, String salt){

        int hashIterations = 1;
        //参数的含义分别是：散列算法，原始密码，盐，散列次数
        SimpleHash simpleHash = new SimpleHash("md5", password, salt, hashIterations);
        return simpleHash.toString();
    }

}
