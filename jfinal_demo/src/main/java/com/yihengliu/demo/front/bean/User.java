package com.yihengliu.demo.front.bean;

/**
 * 用户model
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-01-30 下午5:23
 **/
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}