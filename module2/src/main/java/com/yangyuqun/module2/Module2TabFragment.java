package com.yangyuqun.module2;

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
import com.yangyuqun.router.module1.callback.Module1Callback;
import com.yangyuqun.router.module1.entity.Module1Entity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 15:07
 */
public class Module2TabFragment extends Fragment {
    private Button btnStartActivityOfApp;
    private Button btnGetFragmentOfApp;
    private Button btnCallMethodSyncOfApp;
    private Button btnCallMethodAsyncOfApp;
    private Button btnObservableOfApp;
    private Button btnStartActivityOfModule1;
    private Button btnGetFragmentOfModule1;
    private Button btnCallMethodSyncOfModule1;
    private Button btnCallMethodAsyncOfModule1;
    private Button btnObservableOfModule1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module2_tab, container, false);
        return view;
    }

    public static Module2TabFragment newInstance() {
        Module2TabFragment fragment = new Module2TabFragment();
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
        btnStartActivityOfModule1 = view.findViewById(R.id.btnStartActivityOfModule1);
        btnGetFragmentOfModule1 = view.findViewById(R.id.btnGetFragmentOfModule1);
        btnCallMethodSyncOfModule1 = view.findViewById(R.id.btnCallMethodSyncOfModule1);
        btnCallMethodAsyncOfModule1 = view.findViewById(R.id.btnCallMethodAsyncOfModule1);
        btnObservableOfModule1 = view.findViewById(R.id.btnObservableOfModule1);
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
        btnStartActivityOfModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule1Service.startActivityOfModule1(getContext());
            }
        });
        btnGetFragmentOfModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vModule1FragmentPlaceholder,
                                Services.sModule1Service.obtainFragmentOfModule1())
                        .commitAllowingStateLoss();
            }
        });
        btnCallMethodSyncOfModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("来自module1模块: " + Services.sModule1Service.callMethodSyncOfModule1());
            }
        });
        btnCallMethodAsyncOfModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule1Service.callMethodAsyncOfModule1(new Module1Callback<Module1Entity>() {
                    @Override
                    public void onResult(final Module1Entity data) {
                        btnCallMethodAsyncOfModule1.post(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.show("来自module1模块: " + data.data);
                            }
                        });
                    }
                });
            }
        });
        btnObservableOfModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.sModule1Service.observableOfModule1()
                        .subscribe(new Observer<Module1Entity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Module1Entity module1Entity) {
                                ToastUtil.show("来自module1模块: " + module1Entity.data);
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
