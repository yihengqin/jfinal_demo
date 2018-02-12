package com.yihengliu.demo.common.model;

import com.yihengliu.demo.common.model.base.BaseUser;

/**
 * 用户model类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-02 上午10:55
 **/
public class UserModel extends BaseUser<UserModel> {
    public static final UserModel DAO = new UserModel();
}