package com.example.trxy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.Toast;


import com.example.trxy.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class UserUtils {
    private static Random r = new Random();
    private static String ssource = "0123456789";
    private static char[] src = ssource.toCharArray();

    //保存登录信息
    public static void setAccountInformation(String name ,String paswd, boolean issave){
        // 创建SharedPreferences对象用于储存帐号和密码,并将其私有化
        SharedPreferences share = MyApplication.getContext().getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        // 获取编辑器来存储数据到sharedpreferences中
        SharedPreferences.Editor editor = share.edit();
        editor.putString("Account", name);
        editor.putString("Password", paswd);
        editor.putBoolean("LoginBool", issave);
        // 将数据提交到sharedpreferences中
        editor.apply();
    }

    //获取用户名
    public static String getUserName(){
        // 获取sharedpreferences对象
        SharedPreferences share = MyApplication.getContext().getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        String strAccount = share.getString("Account", "");
        return strAccount;
    }

    //获取密码
    public static String getUserPassword(){
        // 获取sharedpreferences对象
        SharedPreferences share = MyApplication.getContext().getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        String strPassword = share.getString("Password", "");
        return strPassword;
    }

    public static Boolean getWhetherCancellation(){
        // 获取sharedpreferences对象
        SharedPreferences share = MyApplication.getContext().getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        boolean cancellation = share.getBoolean("LoginBool", false);
        return cancellation;
    }

    //保存用户
    public static void getLogout(){
        // 获取sharedpreferences对象
        SharedPreferences share = Objects.requireNonNull(MyApplication.getContext()).getSharedPreferences("Login",
                Context.MODE_PRIVATE);
        share.edit().putBoolean("LoginBool", false).apply();

    }

    //获取系统时间
    public static String getTime(String time){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(time);
        String sim = dateFormat.format(date);
        return sim;
    }



    //产生随机字符串
    private static String randString (int length) {
        char[] buf = new char[length];
        int rnd;
        for(int i = 0; i < length; i++) {
            rnd = Math.abs(r.nextInt()) % src.length;
            buf[i] = src[rnd];
        }
        return new String(buf);
    }

     //调用该方法，产生随机字符串,
     //参数i: 为字符串的长度
    public static String runVerifyCode(int i) {
        String VerifyCode = randString(i);
        return VerifyCode;
    }



}
