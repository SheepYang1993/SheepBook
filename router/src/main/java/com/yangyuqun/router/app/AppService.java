package com.yangyuqun.router.app;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.router.app.callback.AppCallback;
import com.yangyuqun.router.app.entity.AppEntity;

import io.reactivex.Observable;


public interface AppService {

    /**
     * 普通的同步方法调用
     *
     * @return
     */
    String callMethodSyncOfApp();

    /**
     * 以 RxJava 形式封装的异步方法
     *
     * @return
     */
    Observable<AppEntity> observableOfApp();

    /**
     * 以 Callback 形式封装的异步方法
     *
     * @param callback
     */
    void callMethodAsyncOfApp(AppCallback<AppEntity> callback);

    /**
     * 启动 App 模块的 Activity
     *
     * @param context
     */
    void startActivityOfApp(Context context);

    /**
     * 调用 App 模块的 Fragment
     *
     * @return
     */
    Fragment obtainFragmentOfApp();
}
