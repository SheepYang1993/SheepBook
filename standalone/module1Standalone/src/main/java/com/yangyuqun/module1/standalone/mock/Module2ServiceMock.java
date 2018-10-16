package com.yangyuqun.module1.standalone.mock;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.commons.ToastUtil;
import com.yangyuqun.router.module2.Module2Service;
import com.yangyuqun.router.module2.callback.Module2Callback;
import com.yangyuqun.router.module2.entity.Module2Entity;

import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */

public class Module2ServiceMock implements Module2Service {

    @Override
    public void startActivityOfModule2(Context context) {
        ToastUtil.show("模拟<结果：调用打开模块2Activity>");
    }

    @Override
    public Fragment obtainFragmentOfModule2() {
        ToastUtil.show("模拟<结果：调用获取模块2Fragment>");
        return new Fragment();
    }

    @Override
    public String callMethodSyncOfModule2() {
        return "模拟<结果：调用模块2同步方法>";
    }

    @Override
    public void callMethodAsyncOfModule2(final Module2Callback<Module2Entity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new Module2Entity("模拟<结果：调用模块2异步方法>"));
            }
        }.start();
    }

    @Override
    public Observable<Module2Entity> observableOfModule2() {
        return Observable.just(new Module2Entity("模拟<结果：调用模块2Rx方法>"));
    }

    @Override
    public Fragment module2TabFragment() {
        return null;
    }
}
