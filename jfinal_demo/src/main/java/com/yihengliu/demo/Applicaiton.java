package com.yihengliu.demo;

import com.jfinal.core.JFinal;

/**
 * 启动类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-30 下午5:27
 **/
public class Applicaiton {
    public static void main(String[] args) {
        JFinal.start("jfinal_demo/src/main/webapp", 9090, "/");
    }
}