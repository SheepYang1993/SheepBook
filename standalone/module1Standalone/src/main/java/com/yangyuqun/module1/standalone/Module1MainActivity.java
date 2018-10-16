package com.yangyuqun.module1.standalone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yangyuqun.module1.Module1TabFragment;

public class Module1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, Module1TabFragment.newInstance())
                    .commit();
        }
    }
}
