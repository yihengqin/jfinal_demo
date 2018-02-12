package com.yihengliu.demo.common.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午4:37
 **/
public class FrontInterceptor3 implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("FrontInterceptor3.intercept, before....");
        inv.invoke();
        System.out.println("FrontInterceptor3.intercept, after...");
    }
}