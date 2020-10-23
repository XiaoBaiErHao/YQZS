package com.example.trxy.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.UserInfoBean;
import com.example.trxy.bean.UserOperate;
import com.example.trxy.greendao.UserInfoBeanDao;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.BottomDialog;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.DigitCheck;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.UserUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

//注册
public class SignInActivity extends CheckPermissionsActivity implements View.OnClickListener{
    private ImageView mHeadBack;
    private TextView mHeadTitle;
    /**
     * 请输入手机号
     */
    private EditText mUserName;
    /**
     * 8-20位数字和密码组合
     */
    private EditText mEtPassword;
    private ImageView mIvSwichPasswrod;
    /**
     * 确认注册
     */
    private Button mPresent;
    private TextView mTvCreateAdm;
    private LinearLayout mLoutyAndmtyp;
    private TextView mTvAdmiType;
    private Boolean showPassword = true;
    private String mAtTheWheel;
    private String mEnterPassword;
    public static final String SIGNNAME_DETAILS = "SIGNNAME_DETAILS";
    private String signName;
    private BottomDialog bottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signName =  getIntent().getStringExtra(SIGNNAME_DETAILS);
        initView();
    }


    private void initView() {
        mHeadBack = (ImageView) findViewById(R.id.head_back);
        mHeadBack.setOnClickListener(this);
        mHeadTitle = (TextView) findViewById(R.id.head_title);
        mUserName = (EditText) findViewById(R.id.user_name);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mIvSwichPasswrod = (ImageView) findViewById(R.id.iv_swich_passwrod);
        mIvSwichPasswrod.setOnClickListener(this);
        mPresent = (Button) findViewById(R.id.present);
        mPresent.setOnClickListener(this);

        mHeadTitle.setText(signName);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.iv_swich_passwrod:
                if (showPassword) {// 显示密码
                    mIvSwichPasswrod.setImageDrawable(getResources().getDrawable(R.mipmap.show_psw));
                    mEtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mEtPassword.setSelection(mEtPassword.getText().toString().length());
                    showPassword = !showPassword;
                } else {// 隐藏密码
                    mIvSwichPasswrod.setImageDrawable(getResources().getDrawable(R.mipmap.show_psw_press));
                    mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mEtPassword.setSelection(mEtPassword.getText().toString().length());
                    showPassword = !showPassword;
                }
                break;
            case R.id.present:
                initpresent();
                //initRequestTher();
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

        EasyHttp.post(NetworkUrl.getUserRegister())
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
                        UserOperate userBean = JsonUtil.parseJson(response, UserOperate.class);
                        LogUtil.e("1111111111", userBean.getResult().toString());
                    }
                });

    }

    private void initpresent() {
        mAtTheWheel = mUserName.getText().toString();
        if(signName.equals("用户注册")){
            if (TextUtils.isEmpty(mAtTheWheel)) {
                LogUtil.showShort("手机号码为空！");
                return;
            }

            if(mAtTheWheel.length() != 11){
                LogUtil.showShort("手机号位数不够，请输入正确手机号!");
                return;
            }

            if(!DigitCheck.isMobileNO(mAtTheWheel)){
                LogUtil.showShort("手机号不格式不正确，请输入正确手机号!");
                return;
            }
        }

        mEnterPassword = mEtPassword.getText().toString();
        if (TextUtils.isEmpty(mEnterPassword)) {
            LogUtil.showShort("密码名为空！");
            return;
        }
        if (!(mEnterPassword.length()<=20 && mEnterPassword.length()>=6)) {
            LogUtil.showShort("密码长度应大于6位小于20位");
            return;
        }


        if (DigitCheck.isSpecialChar(mEnterPassword)){
            if (!DigitCheck.isLetterDigit(mEnterPassword) && !DigitCheck.isSpecialChar(mEnterPassword)) {
                LogUtil.showShort("密码强度过低（密码包括应数字、字母）");
                return;
            }
        }else {
            if (!DigitCheck.isLetterDigit(mEnterPassword)) {
                LogUtil.showShort("密码强度过低（密码包括应数字、字母）");
                return;
            }
        }

        if (signName.equals("用户注册")){
            UserInfoBean user = MyApplication.getDaoSession().getUserInfoBeanDao().queryBuilder()
                    .where(UserInfoBeanDao.Properties.UserLoginName.eq(mAtTheWheel)).unique();
            if (user == null ){
                //userLevel默认为0，是普通用户。1是管理员
                UserInfoBean userInfoBean = new UserInfoBean(Long.valueOf(UserUtils.runVerifyCode(12)), mAtTheWheel, mEnterPassword, null,
                        null, null, null, null,
                        null, null, null, "0",
                        UserUtils.getTime("yyyy-MM-dd HH-mm-ss"), UserUtils.runVerifyCode(10), mAtTheWheel,null,null);

                MyApplication.getDaoSession().getUserInfoBeanDao().insert(userInfoBean);

                LogUtil.showShort("注册成功!");
                finish();
            }else {
                LogUtil.showShort("该用户已存在，请换一个!");
            }
        }

    }



}
