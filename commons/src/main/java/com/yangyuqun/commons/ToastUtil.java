package com.yangyuqun.commons;

import android.support.annotation.StringRes;
import android.widget.Toast;

public class ToastUtil {

    public static void show(String msg) {
        Toast.makeText(AppBase.INSTANCE, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(@StringRes int resourceId) {
        Toast.makeText(AppBase.INSTANCE, resourceId, Toast.LENGTH_SHORT).show();
    }
}
