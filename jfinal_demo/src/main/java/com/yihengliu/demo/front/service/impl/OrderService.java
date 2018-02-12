package com.yihengliu.demo.front.service.impl;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午5:17
 **/
public class OrderService {
    @Before(Tx.class)
    public void payment() {
        System.out.println("OrderService.payment");
    }
}