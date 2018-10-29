package com.yangyuqun.module2;

import android.util.Log;

import com.yangyuqun.commons.AppBase;

import io.github.prototypez.appjoint.core.ModuleSpec;

/**
 * @author SheepYang
 * @since 2018/10/15 11:19
 */
@ModuleSpec
public class Module2Application extends AppBase {
    @Override
    public void onCreate() {
        super.onCreate();
        // do module2 initialization
        Log.i("module2", "module2 init is called");
    }
}
