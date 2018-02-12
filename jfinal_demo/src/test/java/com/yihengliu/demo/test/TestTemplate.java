package com.yihengliu.demo.test;

import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;

/**
 * 测试template
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 上午10:35
 **/
public class TestTemplate {
    public static void main(String[] args) {
        Engine engine = Engine.create("myEngine");
        Template template = engine.getTemplateByString("#(x + 123)");
        String result = template.renderToString(Kv.by("x", 456));
        System.out.println(result);

        Engine engine1 = Engine.create("myEngine2");
        engine1.setBaseTemplatePath(PathKit.getWebRootPath() + "/target/test-classes/template");
        System.out.println(engine1.getTemplate("template.html").renderToString(Kv.by("x", 123456)));
    }
}