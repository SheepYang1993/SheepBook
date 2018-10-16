package com.yangyuqun.module2.standalone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yangyuqun.module2.Module2TabFragment;

public class Module2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, Module2TabFragment.newInstance())
                    .commit();
        }
    }
}
