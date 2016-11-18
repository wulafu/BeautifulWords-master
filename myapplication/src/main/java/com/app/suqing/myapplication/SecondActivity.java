package com.app.suqing.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.suqing.myapplication.login.bean.UserBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import net.nashlegend.anypref.AnyPref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.psw)
    TextView psw;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv1)
    ImageView iv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        UserBean user = getIntent().getParcelableExtra("user");
        username.setText(user.username + "  " + user.toString());
        psw.setText(user.psw);
        UserBean userBean = AnyPref.get(UserBean.class);
        Glide.with(SecondActivity.this).load("http://img-bdtrip-2016-06-15.img-cn-beijing.aliyuncs.com///20160616/94e57d19e937c954d61831b89b98b6c8.jpg@1210w_680h_1e_1c_40q").diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(iv);
        Glide.with(SecondActivity.this).load("http://img-bdtrip-2016-06-15.img-cn-beijing.aliyuncs.com///20160616/94e57d19e937c954d61831b89b98b6c8.jpg").diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(iv1);
        Log.d("wulafu", "onCreate: --------------" + userBean.psw + "  ----" + userBean.username + " ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @OnClick(R.id.btn)
    public void clear(){
        Glide.get(SecondActivity.this).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(SecondActivity.this).clearDiskCache();

            }
        }.start();

    }
}
