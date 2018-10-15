package com.yangyuqun.module3.standalone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yangyuqun.module1.Module1TabFragment;
import com.yangyuqun.module3.standalone.R;

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
