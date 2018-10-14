package com.yangyuqun.module1;

import com.yangyuqun.router.app.AppService;
import com.yangyuqun.router.module2.Module2Service;

import io.github.prototypez.appjoint.AppJoint;

public class Services {

    public static AppService sAppService = AppJoint.service(AppService.class);

    public static Module2Service sModule2Service = AppJoint.service(Module2Service.class);
}
