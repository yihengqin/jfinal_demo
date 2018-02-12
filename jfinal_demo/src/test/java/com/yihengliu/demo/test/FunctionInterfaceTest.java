package com.yihengliu.demo.test;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * 函数式接口测试
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-05 上午9:42
 **/
public class FunctionInterfaceTest<T> implements Predicate<T> {
    public static void main(String[] args) {
        Predicate p = new FunctionInterfaceTest();
        System.out.println(p.test(1));

        Predicate<Integer> pp = a -> a % 2 == 1;
        System.out.println(pp.test(5));

        FunInt fi = () -> "hello";
        System.out.println(fi.testMethod());

        BiConsumer<String, Integer> bc = (v1, v2) -> {
            System.out.println(v1 + " | " + v2);
        };

       bc.accept("Hello", 1234);

        Optional<String> stringOptional = Optional.ofNullable("null");
        System.out.println(stringOptional.map(s -> s.toUpperCase()).orElse("is null..."));
        System.out.println(stringOptional.map(String::toUpperCase).orElse("is null..."));

    }

    @Override
    public boolean test(T t) {
        return 1 % 2 == 0;
    }
}