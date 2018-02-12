package com.yihengliu.demo.common.validators;

import com.jfinal.core.Controller;
import com.jfinal.json.Json;
import com.jfinal.validate.Validator;
import org.eclipse.jetty.util.ajax.JSON;

/**
 * 登录校验器
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 下午4:25
 **/
public class LoginValidator extends Validator {

    @Override
    protected void validate(Controller c) {
        System.out.println("LoginValidator.validate");
        validateRequiredString("username", "nameMsg", "请输入用户名");
        validateRequired("password", "passMsg", "请输入密码");
    }

    @Override
    protected void handleError(Controller c) {
        c.keepPara("username");
        c.renderJson("验证错误........" + c.getPara("username"));
    }
}