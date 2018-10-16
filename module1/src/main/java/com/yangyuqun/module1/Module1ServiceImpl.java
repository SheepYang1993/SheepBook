package com.yangyuqun.module1;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.router.module1.Module1Service;
import com.yangyuqun.router.module1.callback.Module1Callback;
import com.yangyuqun.router.module1.entity.Module1Entity;
import com.yangyuqun.router.module2.Module2Service;
import com.yangyuqun.router.module2.entity.Module2Entity;

import io.github.prototypez.appjoint.core.ServiceProvider;
import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/16 9:13
 */
@ServiceProvider
public class Module1ServiceImpl implements Module1Service {
    @Override
    public void startActivityOfModule1(Context context) {
        Module1Activity.start(context);
    }

    @Override
    public Fragment obtainFragmentOfModule1() {
        return Module1Fragment.newInstance();
    }

    @Override
    public String callMethodSyncOfModule1() {
        return "结果：调用模块1同步方法";
    }

    @Override
    public void callMethodAsyncOfModule1(final Module1Callback<Module1Entity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new Module1Entity("结果：调用模块1异步方法"));
            }
        }.start();
    }

    @Override
    public Observable<Module1Entity> observableOfModule1() {
        return Observable.just(new Module1Entity("结果：调用模块1Rx方法"));
    }

    @Override
    public Fragment module1TabFragment() {
        return Module1TabFragment.newInstance();
    }
}
