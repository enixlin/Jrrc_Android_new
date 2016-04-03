package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by linzhenhuan on 2016/4/4.
 */
public class MyHandler extends Handler {
    private WeakReference<Activity> activity;

    public WeakReference<Activity> getActivity() {
        return activity;
    }

    public void setActivity(WeakReference<Activity> activity) {
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        System.out.println("message...");


    }
}
