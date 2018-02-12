package com.yihengliu.demo.test;

import net.sf.ehcache.util.TimeUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * lambda测试
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 上午8:36
 **/
public class LambdaTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, world....");
            }
        }).start();

        new Thread(() -> System.out.println("hello world...")).start();

        String[] datas = new String[]{"peng", "zhao", "li", "z"};
        Arrays.sort(datas);
        System.out.println(Arrays.toString(datas));
        Stream.of(datas).forEach(param -> System.out.println(param));

        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));

        Comparator<String> comp =  (v1, v2) -> Integer.compare(v1.length(), v2.length());

    }
}