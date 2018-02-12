package com.yihengliu.demo.common.task;

import java.util.Date;

/**
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 下午3:38
 **/
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("定时执行" + new Date());
    }
}