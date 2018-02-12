package com.yihengliu.demo.common.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午3:50
 **/
public class FrontInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        System.out.println("FrontInterceptor.intercept, before...");
        System.out.println("是否为控制层拦截：" + invocation.isActionInvocation());
        invocation.invoke();
        System.out.println("FrontInterceptor.intercept, after...");
    }
}