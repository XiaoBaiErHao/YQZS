package com.example.trxy.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.AnEntitySetBean;
import com.example.trxy.bean.UserInfoBean;
import com.example.trxy.greendao.UserInfoBeanDao;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.CountdownCircleProgressBar;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.UserUtils;

import java.util.Timer;
import java.util.TimerTask;

//启动页
public class WelcomeActivity extends CheckPermissionsActivity implements View.OnClickListener {
    private CountdownCircleProgressBar mTvSkip;
    // 用于记录帐号和密码
    private String strAccount = "";
    private String strPassword = "";
    public final static int OPEN_SCREEN_TIME = 5000;
    private Timer mTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        initView();
        AnEntitySetBean anset = new AnEntitySetBean();
        MyApplication.setAnEntitySet(anset);
        initLog();
    }

    private void initView() {
        mTvSkip = (CountdownCircleProgressBar ) findViewById(R.id.tv_skip);
        mTvSkip.setOnClickListener(this);
    }

    private void initLog() {

        strAccount = UserUtils.getUserName();
        strPassword = UserUtils.getUserPassword();
        // 判断是否是之前有登录过
        if (strAccount.equals("")) {
            initDatelys();
        } else {
            // 判断是否刚注销
            if (UserUtils.getWhetherCancellation()) {
                initDate();
            } else {
                LogUtil.e("自动登录","失败");
                initDatelys();
            }
        }
    }

    private void initDate() {
        UserInfoBean user = MyApplication.getDaoSession().getUserInfoBeanDao().queryBuilder()
                .where(UserInfoBeanDao.Properties.UserLoginName.eq(strAccount)).unique();
        if (user != null){
            MyApplication.getAnEntitySet().setUserInfoBean(user);
            if (MyApplication.getAnEntitySet().getUserInfoBean().getUserLoginName().equals(strAccount)){
                init();
            }else {
                initDatelys();
            }

        }else {
            initDatelys();
        }

    }

    private void init() {
        mTvSkip.setTimeMillis(OPEN_SCREEN_TIME);
        mTvSkip.play();

        //使用计时器Task来等待5秒跳转
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startMainActivity();
            }
        };
        mTimer.schedule(timerTask,OPEN_SCREEN_TIME);

    }

    private void startMainActivity(){
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }

    private void initDatelys() {
        startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_skip:
                startMainActivity();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 注意：WelcomeActivity销毁时应该停止线程，防止内存泄漏！！！
        mTvSkip.isRunning = false;
        // 注意：WelcomeActivity销毁时应该停止mTimer，防止内存泄漏！！！
        mTimer.cancel();
    }
}
