package com.yangyuqun.module1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yangyuqun.commons.ToastUtil;
import com.yangyuqun.router.app.callback.AppCallback;
import com.yangyuqun.router.app.entity.AppEntity;
import com.yangyuqun.router.module2.callback.Module2Callback;
import com.yangyuqun.router.module2.entity.Module2Entity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2018/10/14
 */

public class Module1TabFragment extends Fragment {
    private Button btnStartActivityOfApp;
    private Button btnGetFragmentOfApp;
    private Button btnCallMethodSyncOfApp;
    private Button btnCallMethodAsyncOfApp;
    private Button btnObservableOfApp;
    private Button btnStartActivityOfModule2;
    private Button btnGetFragmentOfModule2;
    private Button btnCallMethodSyncOfModule2;
    private Button btnCallMethodAsyncOfModule2;
    private Button btnObservableOfModule2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module1_tab, container, false);
        return view;
    }

    public static Module1TabFragment newInstance() {
        Module1TabFragment fragment = new Module1TabFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void initView(View view) {
        btnStartActivityOfApp = view.findViewById(R.id.btnStartActivityOfApp);
        btnGetFragmentOfApp = view.findViewById(R.id.btnGetFragmentOfApp);
        btnCallMethodSyncOfApp = view.findViewById(R.id.btnCallMethodSyncOfApp);
        btnCallMethodAsyncOfApp = view.findViewById(R.id.btnCallMethodAsyncOfApp);
        btnObservableOfApp = view.findViewById(R.id.btnObservableOfApp);
        btnStartActivityOfModule2 = view.findViewById(R.id.btnStartActivityOfModule2);
        btnGetFragmentOfModule2 = view.findViewById(R.id.btnGetFragmentOfModule2);
        btnCallMethodSyncOfModule2 = view.findViewById(R.id.btnCallMethodSyncOfModule2);
        btnCallMethodAsyncOfModule2 = view.findViewById(R.id.btnCallMethodAsyncOfModule2);
        btnObservableOfModule2 = view.findViewById(R.id.btnObservableOfModule2);
    }

    private void initListener() {
        btnStartActivityOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sAppService.startActivityOfApp(getContext());
            }
        });
        btnGetFragmentOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vAppFragmentPlaceholder,
                                Services.sAppService.obtainFragmentOfApp())
                        .commitAllowingStateLoss();
            }
        });
        btnCallMethodSyncOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("来自App模块: " + Services.sAppService.callMethodSyncOfApp());
            }
        });
        btnCallMethodAsyncOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sAppService.callMethodAsyncOfApp(new AppCallback<AppEntity>() {
                    @Override
                    public void onResult(final AppEntity data) {
                        btnCallMethodAsyncOfApp.post(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.show("来自App模块: " + data.data);
                            }
                        });
                    }
                });
            }
        });
        btnObservableOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sAppService.observableOfApp()
                        .subscribe(new Observer<AppEntity>() {

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(AppEntity appEntity) {
                                ToastUtil.show("来自app模块: " + appEntity.data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
        btnStartActivityOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule2Service.startActivityOfModule2(getContext());
            }
        });
        btnGetFragmentOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vModule2FragmentPlaceholder,
                                Services.sModule2Service.obtainFragmentOfModule2())
                        .commitAllowingStateLoss();
            }
        });
        btnCallMethodSyncOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("来自module2模块: " + Services.sModule2Service.callMethodSyncOfModule2());
            }
        });
        btnCallMethodAsyncOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule2Service.callMethodAsyncOfModule2(new Module2Callback<Module2Entity>() {
                    @Override
                    public void onResult(final Module2Entity data) {
                        btnCallMethodAsyncOfModule2.post(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.show("来自module2模块: " + data.data);
                            }
                        });
                    }
                });
            }
        });
        btnObservableOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule2Service.observableOfModule2()
                        .subscribe(new Observer<Module2Entity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Module2Entity module2Entity) {
                                ToastUtil.show("来自module2模块: " + module2Entity.data);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }
}
