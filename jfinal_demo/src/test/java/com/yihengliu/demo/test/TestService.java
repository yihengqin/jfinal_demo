package com.yihengliu.demo.test;

import com.jfinal.aop.Before;
import com.yihengliu.demo.common.interceptors.FrontInterceptor2;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 上午10:21
 **/
public class TestService {
    @Before(FrontInterceptor2.class)
    public void testMethod() {
        System.out.println("TestService.testMethod");
    }
}