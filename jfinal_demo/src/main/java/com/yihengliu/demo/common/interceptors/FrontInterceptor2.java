package com.yihengliu.demo.common.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 测试拦截器
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午4:32
 **/
public class FrontInterceptor2 implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("FrontInterceptor2.intercept, before...");
        inv.invoke();
        System.out.println("FrontInterceptor2.intercept, after...");
    }
}