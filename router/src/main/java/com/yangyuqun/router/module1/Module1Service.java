package com.yangyuqun.router.module1;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.router.module1.callback.Module1Callback;
import com.yangyuqun.router.module1.entity.Module1Entity;

import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 17:52
 */
public interface Module1Service {
    /**
     * 启动 module1 模块的 Activity
     *
     * @param context
     */
    void startActivityOfModule1(Context context);

    /**
     * 调用 module1 模块的 Fragment
     *
     * @return
     */
    Fragment obtainFragmentOfModule1();

    /**
     * 普通的同步方法调用
     *
     * @return
     */
    String callMethodSyncOfModule1();

    /**
     * 以 Callback 形式封装的异步方法
     *
     * @param callback
     */
    void callMethodAsyncOfModule1(Module1Callback<Module1Entity> callback);

    /**
     * 以 RxJava 形式封装的异步方法
     *
     * @return
     */
    Observable<Module1Entity> observableOfModule1();

    Fragment module1TabFragment();
}
