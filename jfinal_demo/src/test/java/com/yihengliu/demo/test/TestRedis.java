package com.yihengliu.demo.test;

import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;

/**
 * 测试redis
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 下午3:32
 **/
public class TestRedis {
    public static void main(String[] args) {
        RedisPlugin rp = new RedisPlugin("myRedis", "localhost");
        rp.start();

        Redis.use().set("key", "value3");
        System.out.println((String) Redis.use().get("key"));
    }
}