package com.yihengliu.demo.front.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheKit;
import com.yihengliu.demo.common.model.UserModel;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 下午3:09
 **/
public class CacheController extends Controller {
    public void cacheTest1() {
        System.out.println("CacheController.cacheTest1");
        UserModel.DAO.findByCache("userCache", "user", "select * from user");
        renderText("cacheTest1...");
    }

    public void cacheTest2() {
        System.out.println("CacheController.cacheTest2");
        Object o = CacheKit.get("userCache", "user");
        if (o != null) {
            System.out.println("缓存不为空。。。");
            System.out.println(o);
        } else {
            System.out.println("缓存为空。。。");
        }
        renderText("CacheController, cacheTest2...");
    }
}