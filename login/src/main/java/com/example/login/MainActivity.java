package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private Button btn_submit;
    private EditText et_uname;
    private EditText et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_uname = (EditText) findViewById(R.id.et_uname);
        et_password = (EditText) findViewById(R.id.et_password);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录验证事件,密码和用户名必需填写
                if (et_uname.getText().equals("") || et_password.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "用户名或密码没有填写", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                // 开始登录
                    try {
                        URL url=new URL("http://localhost//jrrc_server_php");
                        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                        String sName=et_uname.getText().toString();
                        String sPassword=et_password.getText().toString();
                       httpURLConnection.setDoOutput(true);




                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        });

    }
}
