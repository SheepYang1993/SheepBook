package com.yangyuqun.sheepbook.demo;

import android.util.Log;

import com.yangyuqun.commons.AppBase;

import io.github.prototypez.appjoint.core.AppSpec;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */
@AppSpec
public class App extends AppBase {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("app", "app init is called");
    }
}
