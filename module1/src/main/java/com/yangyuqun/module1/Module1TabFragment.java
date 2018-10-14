package com.yangyuqun.module1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

            }
        });
        btnGetFragmentOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCallMethodSyncOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCallMethodAsyncOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnObservableOfApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnStartActivityOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnGetFragmentOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCallMethodSyncOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCallMethodAsyncOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnObservableOfModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
