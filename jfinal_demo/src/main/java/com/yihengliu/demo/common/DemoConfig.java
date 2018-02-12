package com.yihengliu.demo.common;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;
import com.yihengliu.demo.common.model.UserModel;
import com.yihengliu.demo.common.model._MappingKit;
import com.yihengliu.demo.common.routes.FrontRoute;
import com.yihengliu.demo.front.controller.*;
import it.sauronsoftware.cron4j.ProcessTask;

import java.io.File;

/**
 * 配置类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-30 下午5:28
 **/
public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(PropKit.getBoolean("devMode", false));

        me.setBaseUploadPath("/home/cc/Pictures/upload/");
        me.setBaseDownloadPath("/home/cc/Pictures/");

        me.setI18nDefaultBaseName("i18n");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", UserController.class, "/");
        me.add("/blog", BlogController.class, "/blog");
        me.add("/template", TemplateController.class, "/template");
        me.add(new FrontRoute());
        me.add("/order", OrderController.class, "/order");
        me.add("/cache", CacheController.class, "/cache");
    }

    @Override
    public void configEngine(Engine me) {
        // 配置为true，将支持模板实时热加载
        me.setDevMode(true);
        me.addSharedFunction("/view/common/_layout.html");
        me.addSharedFunction("/view/common/_paginate.html");
    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // sql 管理与动态生成
        arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
        arp.addSqlTemplate("template.sql");

        arp.setShowSql(true);
        arp.setDevMode(true);
        me.add(arp);
        _MappingKit.mapping(arp);
        arp.addMapping("user", UserModel.class);


        // cache plugin
        me.add(new EhCachePlugin());

        RedisPlugin bbsRedis = new RedisPlugin("bbs", "localhost");
        me.add(bbsRedis);

        Cron4jPlugin cp = new Cron4jPlugin("config.properties");
//        cp.addTask("*/1 * * * *", new MyTask());

        String[] command = {"/usr/bin/touch", "test.txt"};
        String[] envs = {};
        File directory = new File("/home/cc/Pictures/");
        ProcessTask task = new ProcessTask(command, envs, directory);
        cp.addTask("*/1 * * * *", task);

        me.add(cp);
    }

    @Override
    public void configInterceptor(Interceptors me) {
        // 添加控制层全局拦截器
//        me.addGlobalActionInterceptor(new GlobalActionInterceptor());

        // 添加业务层全局拦截器
//        me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());

        me.add(new TxByMethods("txTest2"));
    }

    @Override
    public void configHandler(Handlers me) {

    }
}