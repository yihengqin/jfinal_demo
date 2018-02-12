package com.yihengliu.demo.test;

import org.eclipse.jetty.util.ajax.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 上午11:45
 **/
public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        String s = JSON.toString(list);
        System.out.println(s);
    }
}