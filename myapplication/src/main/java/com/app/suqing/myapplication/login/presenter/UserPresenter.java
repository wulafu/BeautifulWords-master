package com.app.suqing.myapplication.login.presenter;

import android.util.Log;

import com.app.suqing.myapplication.login.bean.UserBean;
import com.app.suqing.myapplication.login.model.ILogModel;
import com.app.suqing.myapplication.login.model.LoginModel;
import com.app.suqing.myapplication.login.view.LoginView;


/**
 * Created by hellohome on 2016/11/18.
 */

public class UserPresenter {
    LoginView view;
    private LoginModel loginModel;

    public  UserPresenter(LoginView view){
    this.view=view;
    loginModel=new ILogModel();
    }
    public boolean lodUser(UserBean userBean){
        UserBean userBean1 = loginModel.loginRequest();
        Log.d("wulafu", "lodUser: =---------------"+userBean.psw+"   "+userBean1.psw+(userBean1.psw).equals(userBean.psw));
if((userBean1.psw).equals(userBean.psw)){
    return true;
}else{
    return false;
}

    }
    public void login(UserBean userBean){
        if(lodUser(userBean)){
            view.loginSuccess();

        }else {
            view.loginFail();
        }

    }


}
