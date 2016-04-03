package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.ui;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import linzhenhuan.jrrc_android_new.R;
import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.HttpClient;
import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.NetWorkDetector;
import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.ParamPairs;

public class LoginActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private TextView tv_message;

    private EditText et_name;
    private EditText et_password;

    private Button btn_exit;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_message= (TextView) findViewById(R.id.tv_message);

        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);

        //退出app
        btn_exit= (Button) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btn_submit= (Button) findViewById(R.id.btn_submit);
        //登录请求
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://10.0.2.2/jrrc_server_php/home/login/login_android";
                ArrayList<ParamPairs> list=new ArrayList<ParamPairs>();
                String method="post";


                list.add(new ParamPairs("name",et_name.getText().toString()));
                list.add(new ParamPairs("password",et_password.getText().toString()));

                MyHandler myHandler=new MyHandler();
                HttpClient client=new HttpClient(url,list,method);
                Thread thread=new Thread(client);
                thread.start();




            }
        });





    }




}
