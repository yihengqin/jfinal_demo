package com.yihengliu.demo.front.service.impl;

import com.jfinal.aop.Enhancer;
import com.yihengliu.demo.front.service.TemplateService;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-01 下午4:54
 **/
public class TemplateServiceImpl implements TemplateService {
    public static final TemplateService ME = Enhancer.enhance(TemplateServiceImpl.class);
    @Override
    public void interceptorTest() {
        System.out.println("TemplateServiceImpl.interceptorTest");
    }
}