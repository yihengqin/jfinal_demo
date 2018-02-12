package com.yihengliu.demo.common.routes;

import com.jfinal.config.Routes;
import com.yihengliu.demo.common.interceptors.FrontInterceptor;
import com.yihengliu.demo.front.controller.InterceptorController;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午3:48
 **/
public class FrontRoute extends Routes {
    @Override
    public void config() {
//        addInterceptor(new FrontInterceptor());
        add("/interceptor", InterceptorController.class, "/interceptor");
    }
}