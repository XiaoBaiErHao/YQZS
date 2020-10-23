package com.example.trxy;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;

import com.example.trxy.bean.AnEntitySetBean;
import com.example.trxy.greendao.DaoMaster;
import com.example.trxy.greendao.DaoSession;
import com.example.trxy.greendao.MyOpenHelper;
import com.ycbjie.webviewlib.X5LogUtils;
import com.ycbjie.webviewlib.X5WebUtils;
import com.zhouyou.http.EasyHttp;


public class MyApplication extends Application {
    private static Context context;

    private MyOpenHelper mHelper;
    private static SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    public static final String DB_NAME = "trxy-db";
    public static AnEntitySetBean AnEntitySet;


    //Application的创建，第一个创建，比Activity中的onCreate方法调用还要早
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        setDatabase();
        initDate();
    }

    private void initDate() {
        //网络请求默认初始化
        EasyHttp.init(this);
        //x5web默认初始化
        X5WebUtils.init(this);
        X5LogUtils.setIsLog(true);
    }

    /**
          * 设置greenDao
          */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        // 此处DB_NAME表示数据库名称 可以任意填写
        mHelper = new MyOpenHelper(this, DB_NAME, null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();

    }

    //监听系统变化的方法，如屏幕旋转，语言更改
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //回收内存
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    public static Context getContext(){
        return context;
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static AnEntitySetBean getAnEntitySet() {
        return AnEntitySet;
    }

    public static void setAnEntitySet(AnEntitySetBean AnEntitySets) {
        AnEntitySet = AnEntitySets;
    }
}
