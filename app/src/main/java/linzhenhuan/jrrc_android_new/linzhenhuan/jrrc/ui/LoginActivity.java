package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
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

import linzhenhuan.jrrc_android_new.R;
import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.NetWorkDetector;

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
                new AsyncTask<String ,Void,String>(){
                    @Override
                    protected String doInBackground(String... params) {
                        String line="";
                        String content="";
                        try {
                            URL url=new URL(params[0]);
                            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                           InputStream is= httpURLConnection.getInputStream();
                            InputStreamReader isr=new InputStreamReader(is,"utf-8");
                            BufferedReader br=new BufferedReader(isr);

                            while ((line=br.readLine())!=null){
                                content=content+line;
                            }

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        return content;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                       tv_message.setText(s);
                    }
               // }.execute("http://192.168.31.165/jrrc_server_php");
                }.execute("http://10.0.2.2/jrrc_server_php/home/login/login_android/name/a/password/aaaa");
            }
        });




    }


}
