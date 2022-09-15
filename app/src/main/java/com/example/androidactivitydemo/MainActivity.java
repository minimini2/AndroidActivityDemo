package com.example.androidactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 我们要实现界面的跳转，并且把数据传到另一个界面。
 */
public class MainActivity extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPwd;
    private Button mLogin;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initView() {
        mAccount = (EditText) this.findViewById(R.id.account);
        mPwd = (EditText) this.findViewById(R.id.pwd);
        mLogin = (Button) this.findViewById(R.id.btn_login);
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里面也就是登录按钮被点击了
                Log.d(TAG,"login clicked ...");
                handerLogin();
            }
        });
    }

    private void handerLogin() {
        String accountText = mAccount.getText().toString().trim();
        if (TextUtils.isEmpty(accountText)) {
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }

        String pwdText = mPwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwdText)) {
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }

        //有账号和密码之后就把数据传到另一个界面
        /**
         * 这部分是显示意图跳转到另外一个Activity
         * 先要创建一个意图对象，然后通过StartActivity来跳转
         */
//        Intent intent = new Intent(this,SecondActivity.class);   //显示意图
//        intent.putExtra("account", accountText);
//        intent.putExtra("pwd", pwdText);
//        startActivity(intent);

        /**
         * 接下来使用隐式意图的方式来跳转到另外一个Activity
         */
        Intent intent = new Intent();
        intent.setAction("com.example.LOGIN_INFO");
//        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("account",accountText);
        intent.putExtra("pwd",pwdText);
        startActivity(intent);

    }
}