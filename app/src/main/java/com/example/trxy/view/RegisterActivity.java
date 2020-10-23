package com.example.trxy.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tu.loadingdialog.LoadingDailog;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.AnEntitySetBean;
import com.example.trxy.bean.UserInfo;
import com.example.trxy.bean.UserInfoBean;
import com.example.trxy.greendao.UserInfoBeanDao;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.MyActivityManager;
import com.example.trxy.utils.UserUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

//登录
public class RegisterActivity extends CheckPermissionsActivity implements View.OnClickListener{
    /**
     * 请输入用户名
     */
    private EditText mUserName;
    /**
     * 请输入密码
     */
    private EditText mUserPassword;
    private ImageView mIvLonginPasswrod;
    /**
     * 忘记密码?
     */
    private TextView mForgetPassword;
    /**
     * 新用户注册
     */
    private TextView mUserRegistration;
    /**
     * 登录
     */
    private Button mLogIn;
    private Boolean showPassword = true;
    private String strAccount = "";
    private String name = "";
    private String password = "";
    private LoadingDailog dialog;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        AnEntitySetBean anset = new AnEntitySetBean();
        MyApplication.setAnEntitySet(anset);
    }


    private void initView() {
        mUserName = (EditText) findViewById(R.id.account_number);
        mUserPassword = (EditText) findViewById(R.id.user_password);
        mIvLonginPasswrod = (ImageView) findViewById(R.id.iv_longin_passwrod);
        mIvLonginPasswrod.setOnClickListener(this);
        mForgetPassword = (TextView) findViewById(R.id.forget_password);
        mForgetPassword.setOnClickListener(this);
        mUserRegistration = (TextView) findViewById(R.id.enroll);
        mUserRegistration.setOnClickListener(this);
        mLogIn = (Button) findViewById(R.id.login);
        mLogIn.setOnClickListener(this);

        strAccount = UserUtils.getUserName();
        LogUtil.showShort(strAccount);
        if (!strAccount.equals("")){
            mUserName.setText(strAccount);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_longin_passwrod:
                if (showPassword) {// 显示密码
                    mIvLonginPasswrod.setImageDrawable(getResources().getDrawable(R.mipmap.show_psw));
                    mUserPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mUserPassword.setSelection( mUserPassword.getText().toString().length());
                    showPassword = !showPassword;
                } else {// 隐藏密码
                    mIvLonginPasswrod.setImageDrawable(getResources().getDrawable(R.mipmap.show_psw_press));
                    mUserPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mUserPassword.setSelection( mUserPassword.getText().toString().length());
                    showPassword = !showPassword;
                }
                break;
            case R.id.login:
                initDate();
                //initRequestTher();
                break;
            case R.id.enroll:
                Intent initds = new Intent(this, SignInActivity.class);
                initds.putExtra(SignInActivity.SIGNNAME_DETAILS,"用户注册");
                startActivity(initds);
                break;
            case R.id.forget_password:
                startActivity(new Intent(RegisterActivity.this, ForgetPasswordActivity.class));
                break;

        }
    }

    private void initRequestTher() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userLoginName", "18685829589");
            jsonObject.put("userLoginPwd", "1234567");

        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        EasyHttp.post(NetworkUrl.getUserLogin())
                .headers("Content-Type", "application/json")
                .upJson(jsonObject.toString())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtil.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        LogUtil.e("000000000", response);
                        UserInfo userBean = JsonUtil.parseJson(response, UserInfo.class);
                        LogUtil.e("1111111111", userBean.getResult().toString());
                    }
                });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis() - exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MyActivityManager.getInstance().AppExit(this);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //保存编辑框数据
    public void initDate() {
        name = mUserName.getText().toString().trim();
        password = mUserPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            LogUtil.showShort("请输入用户名！");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            LogUtil.showShort("请输入密码！");
            return;
        }

        UserUtils.setAccountInformation(name, password, true);

        initLogin(name, password);
    }

    //登录服务器
    private void initLogin(String nameer, String passworder) {
        LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(this)
                .setMessage("登录中...")
                .setCancelable(true)
                .setCancelOutside(true);
        dialog = loadBuilder.create();
        dialog.show();

        LogUtil.e("数据为", "" + MyApplication.getDaoSession().getUserInfoBeanDao().loadAll().toString());


        UserInfoBean user = MyApplication.getDaoSession().getUserInfoBeanDao().queryBuilder()
                .where(UserInfoBeanDao.Properties.UserLoginName.eq(nameer)).unique();
        if (user != null){
            MyApplication.getAnEntitySet().setUserInfoBean(user);
            if(user.getUserLoginPwd().equals(passworder)){

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    }
                }, 2000);    //延时2s执行


            }else {
                dialog.dismiss();
                LogUtil.showShort("用户密码错误，请重试！");
            }
        }else {
            dialog.dismiss();
            LogUtil.showShort("用户不存在，请先注册！");
        }

    }
}
