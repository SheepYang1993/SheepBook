package com.yangyuqun.module2;

import com.yangyuqun.router.app.AppService;
import com.yangyuqun.router.module1.Module1Service;

import io.github.prototypez.appjoint.AppJoint;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 17:50
 */
public class Services {

    public static AppService sAppService = AppJoint.service(AppService.class);

    public static Module1Service sModule1Service = AppJoint.service(Module1Service.class);
}
