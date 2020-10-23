package com.example.trxy.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trxy.R;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ycbjie.webviewlib.InterWebListener;
import com.ycbjie.webviewlib.WebProgress;
import com.ycbjie.webviewlib.X5WebUtils;
import com.ycbjie.webviewlib.X5WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class QQBrowserPracticeActivity extends CheckPermissionsActivity {

    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.img_padlock)
    ImageView mImgPadlock;
    @BindView(R.id.web_view)
    X5WebView mWebView;
    @BindView(R.id.progress)
    WebProgress progress;
    private String urldae;
    private String menuName;
    public static final String WEBURL_DETAILS = "WEBURLDETAILS";
    public static final String MENUNAME_DETAILS = "MENUNAMEDETAILS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_qqbrowser);
        ButterKnife.bind(this);

        urldae =  getIntent().getStringExtra(WEBURL_DETAILS);
        menuName =  getIntent().getStringExtra(MENUNAME_DETAILS);

        initDate();
    }

    private void initDate() {
        mHeadTitle.setText(menuName);

        progress.show();
        progress.setColor(this.getResources().getColor(R.color.colorAccent),this.getResources().getColor(R.color.colorPrimaryDark));

        mWebView.loadUrl(urldae);
        mWebView.getX5WebChromeClient().setWebListener(interWebListener);
        mWebView.getX5WebViewClient().setWebListener(interWebListener);

    }

    private InterWebListener interWebListener = new InterWebListener() {
        @Override
        public void hindProgressBar() {
            progress.hide();
        }

        @Override
        public void showErrorView(@X5WebUtils.ErrorType int type) {
            switch (type){
                //没有网络
                case X5WebUtils.ErrorMode.NO_NET:
                    break;
                //404，网页无法打开
                case X5WebUtils.ErrorMode.STATE_404:

                    break;
                //onReceivedError，请求网络出现error
                case X5WebUtils.ErrorMode.RECEIVED_ERROR:

                    break;
                //在加载资源时通知主机应用程序发生SSL错误
                case X5WebUtils.ErrorMode.SSL_ERROR:

                    break;
                default:
                    break;
            }
        }



        @Override
        public void startProgress(int newProgress) {
            progress.setWebProgress(newProgress);
        }

        @Override
        public void showTitle(String title) {

        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() ==
                KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mWebView.pageCanGoBack()) {
                //退出网页
                return mWebView.pageGoBack();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.destroy();
        }
        super.onDestroy();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWebView != null) {
            mWebView.getSettings().setJavaScriptEnabled(false);
        }
    }


    @OnClick({R.id.head_back, R.id.img_padlock})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                if (mWebView.pageCanGoBack()) {
                    //退出网页
                    mWebView.pageGoBack();
                }else {
                    finish();
                }
                break;
            case R.id.img_padlock:
                finish();
                break;
        }
    }
}
