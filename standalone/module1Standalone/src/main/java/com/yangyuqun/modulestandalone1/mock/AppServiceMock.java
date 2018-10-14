package com.yangyuqun.modulestandalone1.mock;

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
        return "Mock<syncMethodResultApp>";
    }

    @Override
    public Observable<AppEntity> observableOfApp() {
        return Observable.just(new AppEntity("Mock<rxJavaResultApp>"));
    }

    @Override
    public void callMethodAsyncOfApp(final AppCallback<AppEntity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new AppEntity("Mock<asyncMethodResultApp>"));
            }
        }.start();

    }

    @Override
    public void startActivityOfApp(Context context) {
        ToastUtil.show("Mock: startActivityOfApp called");
    }

    @Override
    public Fragment obtainFragmentOfApp() {
        ToastUtil.show("Mock: obtainFragmentOfApp called");
        return new Fragment();
    }
}
