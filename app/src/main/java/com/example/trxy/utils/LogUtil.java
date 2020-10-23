package com.example.trxy.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.trxy.BuildConfig;
import com.example.trxy.MyApplication;

public class LogUtil {
    private static boolean islog = BuildConfig.ISLOG;
    /**
     * 截断输出日志
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (tag == null || tag.length() == 0 || msg == null || msg.length() == 0){
            return;
        }

        int segmentSize = 3 * 1024;
        long length = msg.length();
        if (islog){
            if (length <= segmentSize ) {// 长度小于等于限制直接打印
                Log.e(tag, msg);
            }else {
                while (msg.length() > segmentSize ) {// 循环分段打印日志
                    String logContent = msg.substring(0, segmentSize );
                    msg = msg.replace(logContent, "");
                    Log.e(tag, logContent);
                }
                Log.e(tag, msg);// 打印剩余日志
            }

        }else {
            Log.e("The log has been ，", "intercepted without permission");
        }

    }

    //全局吐司提示框
    public static void showShort(String str){
        try{
            Toast.makeText(MyApplication.getContext(),str, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
