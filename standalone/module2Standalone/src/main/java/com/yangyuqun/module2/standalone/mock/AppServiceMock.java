package com.yangyuqun.module2.standalone.mock;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.commons.ToastUtil;
import com.yangyuqun.router.app.AppService;
import com.yangyuqun.router.app.callback.AppCallback;
import com.yangyuqun.router.app.entity.AppEntity;

import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */

public class AppServiceMock implements AppService {

    @Override
    public String callMethodSyncOfApp() {
        return "模拟<结果：调用App模块同步方法>";
    }

    @Override
    public Observable<AppEntity> observableOfApp() {
        return Observable.just(new AppEntity("模拟<结果：调用App模块Rx方法>"));
    }

    @Override
    public void callMethodAsyncOfApp(final AppCallback<AppEntity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new AppEntity("模拟<结果：调用App模块异步方法>"));
            }
        }.start();

    }

    @Override
    public void startActivityOfApp(Context context) {
        ToastUtil.show("模拟<结果：调用打开App模块Activity>");
    }

    @Override
    public Fragment obtainFragmentOfApp() {
        ToastUtil.show("模拟<结果：调用获取App模块Fragment>");
        return new Fragment();
    }
}
