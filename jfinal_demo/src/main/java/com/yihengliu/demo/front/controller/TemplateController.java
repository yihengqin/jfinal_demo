package com.yihengliu.demo.front.controller;

import com.jfinal.core.Controller;
import com.yihengliu.demo.front.service.TemplateService;
import com.yihengliu.demo.front.service.impl.TemplateServiceImpl;

/**
 * 测试template控制类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-31 上午11:42
 **/
public class TemplateController extends Controller {
    private TemplateService templateService = TemplateServiceImpl.ME;

    public void index() {
        renderText("TemplateController.index....");
    }

    public void template() {
//       renderTemplate("template.html");
        renderFreeMarker("template.html");
    }

    public void renderJsonTest() {
//        renderJson("key", "value");
        setAttr("name", "liucheng");
        setAttr("password", "321321");
        renderJson(new String[]{"name", "password"});
        System.out.println("after render");
        System.out.println("after render....");
        System.out.println("after render.......");
    }

    public void renderErrorTest() {
        renderError(404, "template.html");
    }

    public void interceptorTest() {
        templateService.interceptorTest();
        renderText("TemplateController.interceptorTest...");
    }
}