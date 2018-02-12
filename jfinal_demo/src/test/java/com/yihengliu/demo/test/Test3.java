package com.yihengliu.demo.test;

import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;
import com.yihengliu.demo.common.interceptors.FrontInterceptor3;
import junit.framework.Test;

/**
 * 测试类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 上午10:31
 **/
public class Test3 {
    public static void main(String[] args) {
//        TestService testService = Duang.duang(TestService.class, FrontInterceptor3.class);
//        TestService testService = new TestService();
        InjectInterceptorTest injectInterceptorTest= Enhancer.enhance(InjectInterceptorTest.class, FrontInterceptor3.class);
        injectInterceptorTest.testMethod();
    }
}