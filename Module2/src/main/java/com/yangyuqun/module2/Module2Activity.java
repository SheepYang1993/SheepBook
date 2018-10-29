package com.yangyuqun.module2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @since 2018/10/15 11:28
 */
public class Module2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, Module2Activity.class);
        context.startActivity(intent);
    }
}
