package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
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
    private Handler handler;
    private CookieManager cookieManager;


    public HttpClient(String url, ArrayList<ParamPairs> list, String method, Handler handler) {
        this.url = url;
        this.list = list;
        this.method = method;
        this.handler = handler;

        try {
            //URL URL = new URL(this.url + encoderparams(list));
            URL URL = new URL(this.url );
            this.client = (HttpURLConnection) URL.openConnection();
            this.client.setDoOutput(true);
            this.client.setRequestProperty("encoding", "utf-8");
            this.client.setRequestMethod("POST");



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.client = client;

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


    private String encoderparams(ArrayList<ParamPairs> list) {
        String result = "";

        try {
        for (int n = 0; n < list.size(); n++) {
            if (n == 0) {
                result = result + URLEncoder.encode(list.get(n).getKey(), "UTF-8") + "/" + URLEncoder.encode(list.get(n).getValue(),"UTF-8");
            } else {
                result = result + "/" + URLEncoder.encode(list.get(n).getKey(), "UTF-8") + "/" + URLEncoder.encode(list.get(n).getValue(), "UTF-8");
            }
        }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void run() {
        Looper.prepare();

        String result = "";

        try {

            OutputStream os=client.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os);
            BufferedWriter bw=new BufferedWriter(osw);

            bw.write(paraSerialize(list));
            bw.flush();

            bw.close();
            osw.close();
            os.close();




            InputStream is = this.client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                result = result + line;
            }

            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result.equals("1")) {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        } else {
            Message message = new Message();
            message.what = 0;
            handler.sendMessage(message);

        }

    }



    private String paraSerialize(ArrayList<ParamPairs> list){
        String strlist="";
        for(int i=0;i<list.size();i++){
            if (i==0){
                strlist=strlist+list.get(i).getKey()+"="+list.get(i).getValue();
            }else {
                strlist=strlist+"&"+list.get(i).getKey()+"="+list.get(i).getValue();
            }
        }
        return strlist;
    }
}
