package com.yihengliu.demo.test;

import java.util.Enumeration;

/**
 * 实现Enumeration接口
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-31 上午8:54
 **/
public class MyEnumeration implements Enumeration {
    int count;
    int length;
    Object[] dataArray;

    public MyEnumeration(int count, int length, Object[] dataArray) {
        this.count = count;
        this.length = length;
        this.dataArray = dataArray;
    }

    @Override
    public boolean hasMoreElements() {
        return (count < length);
    }

    @Override
    public Object nextElement() {
        return dataArray[count++];
    }
}