package com.yangyuqun.module1;

import android.util.Log;

import com.yangyuqun.commons.AppBase;

import io.github.prototypez.appjoint.core.ModuleSpec;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */
@ModuleSpec
public class Module1Application extends AppBase {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("module1", "module1 init is called");
    }
}
