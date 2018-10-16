package com.yangyuqun.sheepbook.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.yangyuqun.router.app.AppService;
import com.yangyuqun.router.app.callback.AppCallback;
import com.yangyuqun.router.app.entity.AppEntity;

import io.github.prototypez.appjoint.core.ServiceProvider;
import io.reactivex.Observable;

/**
 * 组件化过程不可能一蹴而就，组件化的过程是 App 模块渐渐 “瘦身”的过程
 * 最终 App 模块仅仅作为整个应用的一个 “application 壳”，但是组件化
 * 的过程是缓慢的，我们要允许在组件化的过程中，子模块依然可以调用 App
 * 模块内的方法
 */
@ServiceProvider
public class AppServiceImpl implements AppService {

    @Override
    public String callMethodSyncOfApp() {
        return "结果：调用App模块同步方法";
    }

    @Override
    public Observable<AppEntity> observableOfApp() {
        return Observable.just(new AppEntity("结果：调用App模块Rx方法"));
    }

    @Override
    public void callMethodAsyncOfApp(final AppCallback<AppEntity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new AppEntity("结果：调用App模块异步方法"));
            }
        }.start();
    }

    @Override
    public void startActivityOfApp(Context context) {
        Intent intent = new Intent(context, LegacyActivity.class);
        context.startActivity(intent);
    }

    @Override
    public Fragment obtainFragmentOfApp() {
        return LegacyFragment.newInstance();
    }
}
