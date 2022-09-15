package com.example.androidactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String pwd = intent.getStringExtra("pwd");

        TextView showText = (TextView) this.findViewById(R.id.show_info);
        showText.setText("您的账号是" + account + "，密码是" + pwd);

    }
}
