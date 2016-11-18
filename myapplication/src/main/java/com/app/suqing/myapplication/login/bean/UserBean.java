package com.app.suqing.myapplication.login.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import net.nashlegend.anypref.annotations.PrefField;


/**
 * Created by hellohome on 2016/11/18.
 */

public class UserBean implements Parcelable {
    @PrefField
    public   String username;
    @PrefField
   public  String psw;
    @PrefField
    public Bitmap bitmap;


    public UserBean() {

    }

    public UserBean(String username, String psw) {
        this.username = username;
        this.psw = psw;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.psw);
        dest.writeParcelable(this.bitmap, flags);
    }

    protected UserBean(Parcel in) {
        this.username = in.readString();
        this.psw = in.readString();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
