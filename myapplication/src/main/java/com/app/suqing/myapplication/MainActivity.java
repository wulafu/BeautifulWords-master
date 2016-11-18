package com.app.suqing.myapplication;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.suqing.myapplication.login.bean.UserBean;
import com.app.suqing.myapplication.login.presenter.UserPresenter;
import com.app.suqing.myapplication.login.view.LoginView;

import net.nashlegend.anypref.AnyPref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.psw)
    TextView psw;
    @BindView(R.id.btn)
    Button btn;
    private UserPresenter userPresenter;
    private UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        userPresenter =  new UserPresenter(this);

    }
    @OnClick(R.id.btn)
    public void  login(){

        String sname = username.getText().toString();
        String spsw = psw.getText().toString();
        userBean =  new UserBean(sname,spsw);
        userPresenter.login(userBean);
    }

    @Override
    public void loginSuccess() {

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        userBean.bitmap= BitmapFactory.decodeResource(this.getResources(),R.mipmap.ic_launcher);
        intent.putExtra("user",userBean);
        AnyPref.put(userBean);
        startActivity(intent);

        Toast.makeText(getApplicationContext(),"tiaozhuang",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {
        //不鞥登录
        Toast.makeText(getApplicationContext(),"你输入的不对",Toast.LENGTH_LONG).show();
    }


}
