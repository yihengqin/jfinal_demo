package com.yihengliu.demo.front.controller;

import com.jfinal.core.Controller;
import com.yihengliu.demo.front.service.impl.OrderService;

/**
 * 订单controller类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午5:14
 **/
public class OrderController extends Controller {
    public void payment() {
        OrderService service = enhance(OrderService.class);
//        OrderService service = new OrderService();

        service.payment();
        renderText("OrderController.payment....");
    }
}