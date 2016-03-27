package linzhenhuan.jrrc_android_new;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.NetWorkDetector;

public class ShowActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        NetWorkDetector detector = new NetWorkDetector(client, this.getApplicationContext());
        if (detector.isNetworkConnected()) {
            String NetworkType = String.valueOf(detector.getNetworkType());
            Toast.makeText(this, NetworkType, Toast.LENGTH_LONG).show();
        } else {
            String NetworkType = "没有连接网络";
            Toast.makeText(this, NetworkType, Toast.LENGTH_LONG).show();

        }
    }


}
