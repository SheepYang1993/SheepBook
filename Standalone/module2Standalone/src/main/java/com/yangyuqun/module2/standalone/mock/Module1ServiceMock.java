package com.yangyuqun.module2.standalone.mock;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.commons.ToastUtil;
import com.yangyuqun.router.module1.Module1Service;
import com.yangyuqun.router.module1.callback.Module1Callback;
import com.yangyuqun.router.module1.entity.Module1Entity;
import com.yangyuqun.router.module2.Module2Service;
import com.yangyuqun.router.module2.callback.Module2Callback;
import com.yangyuqun.router.module2.entity.Module2Entity;

import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */

public class Module1ServiceMock implements Module1Service {

    @Override
    public void startActivityOfModule1(Context context) {
        ToastUtil.show("模拟<结果：调用打开模块1Activity>");
    }

    @Override
    public Fragment obtainFragmentOfModule1() {
        ToastUtil.show("模拟<结果：调用获取模块1Fragment>");
        return new Fragment();
    }

    @Override
    public String callMethodSyncOfModule1() {
        return "模拟<结果：调用模块1同步方法>";
    }

    @Override
    public void callMethodAsyncOfModule1(final Module1Callback<Module1Entity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new Module1Entity("模拟<结果：调用模块1异步方法>"));
            }
        }.start();
    }

    @Override
    public Observable<Module1Entity> observableOfModule1() {
        return Observable.just(new Module1Entity("模拟<结果：调用模块1Rx方法>"));
    }

    @Override
    public Fragment module1TabFragment() {
        return null;
    }
}
