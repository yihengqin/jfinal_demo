package com.yihengliu.demo.test;

import java.util.Enumeration;

/**
 * 实例化一个简单的、可以提供enumeration对象
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-31 上午8:58
 **/
public class MyDataStruct {
    String[] data;

    public MyDataStruct() {
        data = new String[4];
        data[0] = "zero";
        data[1] = "one";
        data[2] = "two";
        data[3] = "three";
    }

    Enumeration getEnum() {
        return new MyEnumeration(0, data.length, data);
    }
}