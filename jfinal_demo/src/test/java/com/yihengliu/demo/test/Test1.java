package com.yihengliu.demo.test;

import java.util.Enumeration;

/**
 * 测试类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-31 上午8:53
 **/
public class Test1 {
    public static void main(String[] args) {
        MyDataStruct myDataStruct = new MyDataStruct();
        Enumeration myEnumeration = myDataStruct.getEnum();
        while (myEnumeration.hasMoreElements()) {
            System.out.println(myEnumeration.nextElement());
        }
    }
}