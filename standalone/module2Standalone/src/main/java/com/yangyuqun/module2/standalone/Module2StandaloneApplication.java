package com.yangyuqun.module2.standalone;

import android.util.Log;

import com.yangyuqun.module1.Services;
import com.yangyuqun.module2.Module2Application;
import com.yangyuqun.module2.standalone.mock.AppServiceMock;


public class Module2StandaloneApplication extends Module2Application {

    @Override
    public void onCreate() {
        // module1 init inside super.onCreate()
        super.onCreate();
        // initialization only used for running module1 standalone
        Log.i("module1Standalone", "module1Standalone init is called");

        // Replace instances inside Services
        Services.sAppService = new AppServiceMock();
        Services.sModule1Service = new Module1ServiceMock();
    }
}
