package com.yihengliu.demo.test;

import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;

/**
 * 测试类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 上午10:19
 **/
public class Test2 {
    public static void main(String[] args) {
        TestService service = Duang.duang(TestService.class);
        TestService service1 = Enhancer.enhance(TestService.class);
        service.testMethod();
        service1.testMethod();
    }
}