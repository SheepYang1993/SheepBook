package com.yangyuqun.module2.standalone.mock;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.commons.ToastUtil;
import com.yangyuqun.router.module1.Module1Service;
import com.yangyuqun.router.module1.callback.Module1Callback;
import com.yangyuqun.router.module1.entity.Module1Entity;

import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */

public class Module1ServiceMock implements Module1Service {

    @Override
    public void startActivityOfModule1(Context context) {
        ToastUtil.show("Mock: startActivityOfModule1 called");
    }

    @Override
    public Fragment obtainFragmentOfModule1() {
        ToastUtil.show("Mock: obtainFragmentOfModule1 called");
        return new Fragment();
    }

    @Override
    public String callMethodSyncOfModule1() {
        return "Mock<syncMethodResultModule1>";
    }

    @Override
    public void callMethodAsyncOfModule1(final Module1Callback<Module1Entity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new Module1Entity("Mock<asyncMethodResultModule1>"));
            }
        }.start();
    }

    @Override
    public Observable<Module1Entity> observableOfModule1() {
        return Observable.just(new Module1Entity("Mock<rxJavaResultModule1>"));
    }

    @Override
    public Fragment module1TabFragment() {
        return null;
    }
}
