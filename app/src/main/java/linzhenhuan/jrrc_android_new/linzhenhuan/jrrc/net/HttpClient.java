package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net;

import android.content.ContentValues;
import android.os.AsyncTask;

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
public class HttpClient {

    private HttpURLConnection client;
    private String url;
    private ArrayList<ContentValues> list;
    private String method;

    public HttpClient(String url, ArrayList<ContentValues> list, String method) {
        this.url = url;
        this.list = list;
        this.method = method;

        HttpURLConnection client=null;
        try {
            URL URL = new URL(this.url);
            client = (HttpURLConnection) URL.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.client= client;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<ContentValues> getList() {
        return list;
    }

    public void setList(ArrayList<ContentValues> list) {
        this.list = list;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String request() {

        String resutl="";
        if(method=="POST"||method=="psot"){

            try {
                client.setDoOutput(true);
                client.setRequestMethod("POST");
                OutputStream os=client.getOutputStream();
                OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
                BufferedWriter bw=new BufferedWriter(osw);

                bw.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return resutl;
    }


    private String encoderparams(ArrayList<ContentValues> list){
        String result="";
        for (int n=0;n<list.size();n++){
            result=result+list.get(n).keySet().toString()+ "/"+list.get(n).toString()+"/";
        }
        return  result;
    }



}
