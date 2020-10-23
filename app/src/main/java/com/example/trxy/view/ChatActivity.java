package com.example.trxy.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.adapter.MessageAdapter;
import com.example.trxy.bean.ChatBean;
import com.example.trxy.bean.MessageBean;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.bean.UserBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.TimeUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.impl.ScrollBoundaryDeciderAdapter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.listView)
    RecyclerView mListView;
    @BindView(R.id.footer)
    ClassicsFooter mFooter;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.more)
    ImageView mMore;
    @BindView(R.id.input)
    EditText mInput;
    @BindView(R.id.send)
    TextView mSend;

    private MessageAdapter messageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        initLoad();
    }

    private void initLoad() {
        mHeadTitle.setText("智多星");
        messageadapter = new MessageAdapter();

        View arrow = mFooter.findViewById(ClassicsFooter.ID_IMAGE_ARROW);
        arrow.setScaleY(-1);//必须设置

        mListView.setAdapter(messageadapter);
        mListView.setScaleY(-1);//必须设置

        messageadapter.insert(initData());

        mRefreshLayout.setEnableRefresh(false);//必须关闭
        mRefreshLayout.setEnableAutoLoadMore(true);//必须关闭
        mRefreshLayout.setEnableNestedScroll(false);//必须关闭
        mRefreshLayout.setEnableScrollContentWhenLoaded(true);//必须关闭
        mRefreshLayout.getLayout().setScaleY(-1);//必须设置
        mRefreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDeciderAdapter() {
            @Override
            public boolean canLoadMore(View content) {
                return super.canRefresh(content);//必须替换
            }
        });

        //监听加载，而不是监听 刷新
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //messageadapter.insert(initData());
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

    }

    @OnClick({R.id.head_back, R.id.more, R.id.send})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.more:
                break;
            case R.id.send:
                initRequest();
                messageadapter.loadMore(initUpdate());
                break;
        }
    }

    private Collection<MessageBean> initUpdate() {
        UserBean mine = new UserBean();
        mine.setMe(true);
        mine.setAvatarId(R.drawable.ic_usertx);

        MessageBean messg2 = new MessageBean();
        messg2.setUser(mine);
        messg2.setTime(new Date(System.currentTimeMillis()));
        messg2.setMessage(mInput.getText().toString());

        mInput.setText("");
        return Arrays.asList(
                messg2
        );
    }

    private void initRequest() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("appcode", "mastermind");
            jsonObject.put("deviceid", TimeUtil.getIMEI(this));
            jsonObject.put("msg", mInput.getText().toString());
            jsonObject.put("msgtype", "text");
            jsonObject.put("sessionid", String.valueOf(MyApplication.getAnEntitySet().getUserInfoBean().getCreateUserId()));
            jsonObject.put("tenantid", "mastermind");
            jsonObject.put("userid", String.valueOf(MyApplication.getAnEntitySet().getUserInfoBean().getUserId()));

        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        String token = "?token=99a7f329-25ac-40bd-999a-9e1dca1bce47";
        EasyHttp.post(NetworkUrl.getFightingEpidemic() + token)
                .headers("apicode", NetworkUrl.getAPICODE())
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
                        ChatBean chat = JsonUtil.parseJson(response, ChatBean.class);
                        if (chat != null){
                            MyApplication.getAnEntitySet().setChatBean(chat);
                            messageadapter.loadMore(initDataTwo());
                        }else {
                            LogUtil.e("解析智多星数据出错", response);
                            LogUtil.showShort("获取智多星数据失败");
                        }
                    }
                });


    }

    private Collection<MessageBean> initData() {
        UserBean user = new UserBean();
        user.setAvatarId(R.mipmap.ic_customer);

        MessageBean messg1 = new MessageBean();
        messg1.setUser(user);
        messg1.setTime(new Date(System.currentTimeMillis()));
        messg1.setMessage("欢迎使用智多星，请问有什么可以帮助您的？");

        return Arrays.asList(
                messg1
        );
    }

    private Collection<MessageBean> initDataTwo() {
        UserBean user = new UserBean();
        user.setAvatarId(R.mipmap.ic_customer);

        MessageBean messg3 = new MessageBean();
        messg3.setUser(user);
        messg3.setTime(new Date(System.currentTimeMillis()));
        messg3.setMessage(MyApplication.getAnEntitySet().getChatBean().getText());

        if (MyApplication.getAnEntitySet().getChatBean().getUrl() != null){
            messg3.setNewsurl(MyApplication.getAnEntitySet().getChatBean().getUrl());
        }else if (MyApplication.getAnEntitySet().getChatBean().getImage() != null){
            messg3.setImgurl(MyApplication.getAnEntitySet().getChatBean().getImage());
        }else if(MyApplication.getAnEntitySet().getChatBean().getResults() != null){
            for (int i = 0; i < MyApplication.getAnEntitySet().getChatBean().getResults().size(); i++){
                if (MyApplication.getAnEntitySet().getChatBean().getResults().get(i).getValues() != null){
                    if (MyApplication.getAnEntitySet().getChatBean().getResults().get(i).getValues().getUrl() != null){
                        messg3.setImgurl(MyApplication.getAnEntitySet().getChatBean().getResults().get(i).getValues().getUrl());
                    }
                }
            }
        }

        return Arrays.asList(
                messg3
        );
    }

}
