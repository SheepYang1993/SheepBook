package com.yangyuqun.module2.standalone;

import android.util.Log;

import com.yangyuqun.module2.Module2Application;
import com.yangyuqun.module2.Services;
import com.yangyuqun.module2.standalone.mock.AppServiceMock;
import com.yangyuqun.module2.standalone.mock.Module1ServiceMock;


public class Module2StandaloneApplication extends Module2Application {

    @Override
    public void onCreate() {
        // module1 init inside super.onCreate()
        super.onCreate();
        // initialization only used for running module2 standalone
        Log.i("module1Standalone", "module2Standalone init is called");

        // Replace instances inside Services
        Services.sAppService = new AppServiceMock();
        Services.sModule1Service = new Module1ServiceMock();
    }
}
