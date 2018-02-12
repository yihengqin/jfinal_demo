package com.yihengliu.demo.front.service.impl;

import com.jfinal.aop.Before;
import com.jfinal.aop.Enhancer;
import com.yihengliu.demo.common.interceptors.FrontInterceptor3;
import com.yihengliu.demo.front.service.InterceptorService;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午4:24
 **/
public class InterceptorServiceImpl implements InterceptorService {

    public static final InterceptorService ME = Enhancer.enhance(InterceptorServiceImpl.class);

    @Override
    @Before(FrontInterceptor3.class)
    public void interceptorTest() {
        System.out.println("InterceptorServiceImpl.interceptorTest");
    }
}