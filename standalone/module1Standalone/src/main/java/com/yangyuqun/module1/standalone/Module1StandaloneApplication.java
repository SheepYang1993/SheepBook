package com.yangyuqun.module1.standalone;

import android.util.Log;

import com.yangyuqun.module1.Module1Application;
import com.yangyuqun.module1.Services;
import com.yangyuqun.module1.standalone.mock.AppServiceMock;
import com.yangyuqun.module1.standalone.mock.Module2ServiceMock;


public class Module1StandaloneApplication extends Module1Application {

    @Override
    public void onCreate() {
        // module1 init inside super.onCreate()
        super.onCreate();
        // initialization only used for running module1 standalone
        Log.i("module1Standalone", "module1Standalone init is called");

        // Replace instances inside Services
        Services.sAppService = new AppServiceMock();
        Services.sModule2Service = new Module2ServiceMock();
    }
}
