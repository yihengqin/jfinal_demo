package com.yihengliu.demo.front.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.yihengliu.demo.common.interceptors.FrontInterceptor;
import com.yihengliu.demo.common.interceptors.FrontInterceptor2;
import com.yihengliu.demo.front.service.InterceptorService;
import com.yihengliu.demo.front.service.impl.InterceptorServiceImpl;

/**
 * @author cc
 */
@Before(FrontInterceptor.class)
public class InterceptorController extends Controller {
    private InterceptorService interceptorService = InterceptorServiceImpl.ME;
    public void index() {
        System.out.println("InterceptorController.index");
        renderText("InterceptorController,index.....");
    }

    @Clear(FrontInterceptor.class)
    @Before(FrontInterceptor2.class)
    public void interceptorTest() {
        System.out.println("InterceptorController.interceptorTest");
        interceptorService.interceptorTest();
        renderText("interceptorTest...");
    }
}
