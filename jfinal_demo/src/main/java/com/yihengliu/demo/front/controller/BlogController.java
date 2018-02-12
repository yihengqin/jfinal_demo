package com.yihengliu.demo.front.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.yihengliu.demo.common.model.Blog;
import com.yihengliu.demo.common.model.User;
import com.yihengliu.demo.common.validators.LoginValidator;

/**
 * blog controller类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-30 下午6:03
 **/
public class BlogController extends Controller {
    public void index() {
        System.out.println("index....");
        render("index.html");
    }

    public void blogLogin() {
        render("login.html");
    }

    @Before(LoginValidator.class)
    public void loginValidate() {
        String username = getPara("username");
        String password = getPara("password");
        System.out.println(username + " | " + password);
        renderText("校验通过");
    }

    public void save() {
        System.out.println(getPara("title"));
        System.out.println("BlogController.save");
        Blog blog = getBean(Blog.class, "blog");
        System.out.println(blog);
        System.out.println("-------------");
        Blog blogModel1 = getModel(Blog.class);
        System.out.println(blogModel1);
        Blog blog1 = blogModel1.setId(111111);
        System.out.println(blog1);

        renderText("save success...");
    }

    public void saveWithFile() {
        UploadFile file = getFile();
        System.out.println(file);

        System.out.println(getPara("blog.title"));
        renderText("saveWithFile....");
    }

    public void downPage() {
        render("download.html");
    }

    public void downLoadFile() {
        renderFile("header_banner1.png");
    }
}