package com.yihengliu.demo.common.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午4:51
 **/
public class GlobalServiceInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("GlobalServiceInterceptor.intercept, before....");
        inv.invoke();
        System.out.println("GlobalServiceInterceptor.intercept, after....");
    }
}