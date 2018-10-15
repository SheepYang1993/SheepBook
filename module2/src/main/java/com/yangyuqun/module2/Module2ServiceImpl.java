package com.yangyuqun.module2;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yangyuqun.router.module2.Module2Service;
import com.yangyuqun.router.module2.callback.Module2Callback;
import com.yangyuqun.router.module2.entity.Module2Entity;

import io.github.prototypez.appjoint.core.ServiceProvider;
import io.reactivex.Observable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 11:27
 */
@ServiceProvider
public class Module2ServiceImpl implements Module2Service {
    @Override
    public void startActivityOfModule2(Context context) {
        Module2Activity.start(context);
    }

    @Override
    public Fragment obtainFragmentOfModule2() {
        return Module2Fragment.newInstance();
    }

    @Override
    public String callMethodSyncOfModule2() {
        return "syncMethodResultModule2";
    }

    @Override
    public void callMethodAsyncOfModule2(final Module2Callback<Module2Entity> callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                callback.onResult(new Module2Entity("asyncMethodResultModule2"));
            }
        }.start();
    }

    @Override
    public Observable<Module2Entity> observableOfModule2() {
        return Observable.just(new Module2Entity("rxJavaResultModule2"));
    }

    @Override
    public Fragment module2TabFragment() {
        return null;/*Module2TabFragment.newInstance()*/
    }
}
