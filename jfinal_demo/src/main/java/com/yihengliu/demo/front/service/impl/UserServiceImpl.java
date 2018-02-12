package com.yihengliu.demo.front.service.impl;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.yihengliu.demo.front.service.UserService;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 下午2:44
 **/
public class UserServiceImpl implements UserService {
    @Override
    @Before(Tx.class)
    public void txTest2() {
        boolean flag2 = Db.update("record", Db.findById("record", 3).set("content", "测试事务7777"));
        boolean flag1 = Db.update("record", Db.findById("record", 1).set("content", "测试事务1111"));
    }
}