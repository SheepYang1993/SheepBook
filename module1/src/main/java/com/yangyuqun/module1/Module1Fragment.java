package com.yangyuqun.module1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 11:31
 */
public class Module1Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_module1, container, false);
    }

    public static Module1Fragment newInstance() {
        Module1Fragment fragment = new Module1Fragment();
        return fragment;
    }
}
