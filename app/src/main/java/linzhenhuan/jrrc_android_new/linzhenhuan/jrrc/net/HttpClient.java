package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


/**
 * Created by linzhenhuan on 2016/4/3.
 */
public class HttpClient implements Runnable {

    private HttpURLConnection client;
    private String url;
    private ArrayList<ParamPairs> list;
    private String method;




    public HttpClient(String url, ArrayList<ParamPairs> list, String method) {
        this.url = url;
        this.list = list;
        this.method = method;

        HttpURLConnection client = null;
        try {
            URL URL = new URL(this.url);
            client = (HttpURLConnection) URL.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.client = client;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<ParamPairs> getList() {
        return list;
    }

    public void setList(ArrayList<ParamPairs> list) {
        this.list = list;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String request() {

        String resutl = "";
        if (this.method == "POST" || this.method == "post") {
            try {
                client.setDoOutput(true);
                client.setRequestMethod("POST");
                OutputStream os = client.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(encoderparams(list));
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            InputStream is=client.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while((line=br.readLine())!=null){
                resutl=resutl+line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resutl;
    }


    private String encoderparams(ArrayList<ParamPairs> list) {
        String result = "";

        for (int n = 0; n < list.size(); n++) {
         result=result+"/"+list.get(n).getKey()+"/"+list.get(n).getValue();

        }
        return result;
    }


    @Override
    public void run() {
        Looper.prepare();
        request();
        Message message = new Message();
        message.what = 1;
        MyHandler handler=new MyHandler();
        handler.sendMessage(message);
    }
}
