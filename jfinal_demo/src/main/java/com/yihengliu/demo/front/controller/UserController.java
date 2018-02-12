package com.yihengliu.demo.front.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.yihengliu.demo.common.model.Article;
import com.yihengliu.demo.common.model.Auser;
import com.yihengliu.demo.common.model.UserModel;
import com.yihengliu.demo.front.bean.User;
import com.yihengliu.demo.front.service.UserService;
import com.yihengliu.demo.front.service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * 用户controller
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-30 下午5:24
 **/
public class UserController extends Controller {
    public void index() {
        renderText("index........");
    }

    public void login() {
//        renderText("login....");
        render("/");
    }

    public void loginParam(@Para("") User user) {
//        User user = getBean(User.class, "");
        System.out.println(user);
        renderText("loginParam...");
    }

    public void loginNoParam() {
        User user = getBean(User.class, "");
        System.out.println(user);
        renderText("loginNoParam....");
    }

    public void loginGetPara() {
        String username = getPara("username");
        System.out.println(username);
        Map<String, String[]> paraMap = getParaMap();
        System.out.println(paraMap);
        Enumeration<String> paraNames = getParaNames();
        while (paraNames.hasMoreElements()) {
            System.out.println(paraNames.nextElement());
        }
        renderText("loginGetPara");
    }

    public void loginGetUrlPara() {
        System.out.println(getPara(0));
        System.out.println(getPara(1));
        System.out.println(getPara());
        renderText("loginGetUrlPara...");
    }

    public void saveUser() {
        UserModel userModel = new UserModel();
        userModel.set("name", "liucheng").set("password", "54321");
        userModel.save();

        renderText("save user success..");
    }

    public void getUser() {
        UserModel userModel = UserModel.DAO.findByIdLoadColumns(5, "name");
        UserModel userModel2 = UserModel.DAO.findByIdLoadColumns(8, "id, name");
        renderText(userModel.toString() + " | " + userModel2.toString());
    }

    public void recordTest() {
        Record record = new Record().set("content", "记录内容。。。").set("columnName", "列名称");
        Db.save("record", record);
    }

    public void delRecord() {
        Db.deleteById("record", 1);
        renderText("delete record success....");
    }

    public void txTest() {
        boolean succeed = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                int count = Db.update("update record set content = ? where id = ?", "修改后的内容", 3);
                int count2 = Db.update("update record set content = ? where id = ?", "修改后的内容2", 2);
                return count == 1 && count2 == 1;
            }
        });

        renderText("操作：" + succeed);
    }

    public void groupbyTest() {
        Page<Record> paginate = Db.paginate(1, 10, true, "select * ", "from record where content is not null group by columnName");
        renderJson(paginate);
    }

    public void txTest2() {
        UserService userService = new UserServiceImpl();
//        UserService userService = Duang.duang(UserServiceImpl.class);
        userService.txTest2();
        renderText("操作完成");
    }

    public void jionTest() {
        String sql = "select article.aid, article.title, auser.username from article inner join auser on article.uid = auser.uid";
        List<Record> records = Db.find(sql);
        renderJson(records);
    }

    public void jionTest1() {
        List<Article> articles = Auser.dao.getArticles();
        renderJson(articles);
    }

    public void templateTest() {
        render("/template/templateTest.html");
    }

    @Before(CacheInterceptor.class)
    @CacheName("blogList")
    public void templateTest1() {
        Page<Article> article = Article.dao.paginate(1, 20, "select * from", "article");
        setAttr("blogs", article);
        render("/template/templateTest1.html");
    }

    public void templateSql() {
        String sql = Db.getSql("findBlog");
        List<Record> records = Db.find(sql);
        renderJson(records);
    }

    @Before(EvictInterceptor.class)
    @CacheName("blogList")
    public void templateUpdate() {
        renderText("清除缓存成功。。。");
    }

    public void redisDemo() {
        Cache bbsCache = Redis.use("bbs");
        bbsCache.set("key", "value1");
        renderText(Redis.use().get("key"));
    }

    public void redisValue() {
        renderText(Redis.use().get("key"));
    }

    public void i18nTest() {
        Res resEn = I18n.use("en_US");
        String msgEn = resEn.get("msg");
        String msgEnFormat = resEn.format("msg", "Chauncey", new Date());

        Res resZh = I18n.use("zh_CN");
        String msgZh = resEn.get("msg");
        String msgZhFormat = resZh.format("msg", "刘成", new Date());
        renderText("i18nTest..." + msgEnFormat + "|" + msgZhFormat);
    }

    public void retTest() {
        Ret ret = Ret.create();
        ret.set("11", "aa").set("22", "bb");
        renderJson(ret);
    }
}