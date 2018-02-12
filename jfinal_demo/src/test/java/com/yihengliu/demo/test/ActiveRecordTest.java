package com.yihengliu.demo.test;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.yihengliu.demo.common.model.Article;

/**
 * active record test
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 下午6:19
 **/
public class ActiveRecordTest {
    public static void main(String[] args) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://192.168.6.209/test", "system", "system");
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("article", "aid", Article.class);

        dp.start();
        arp.start();

        Article article = Article.dao.findById(1);
        System.out.println(article);
    }
}