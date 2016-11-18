package com.app.suqing.myapplication.login.model;

import com.app.suqing.myapplication.login.bean.UserBean;

/**
 * Created by hellohome on 2016/11/18.
 */

public class ILogModel implements LoginModel{

    @Override
    public UserBean loginRequest() {
        UserBean userBean = new UserBean("123456", "123456");

        return userBean;
    }
}
