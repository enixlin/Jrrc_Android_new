package linzhenhuan.jrrc_android_new;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.WifiAdmin;

public class WiftTestActivity extends AppCompatActivity {
    private Button btn_openWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wift_test);

        btn_openWifi = (Button) findViewById(R.id.button);
        btn_openWifi.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //打开wifi

                                                WifiAdmin wa = new WifiAdmin(getApplicationContext());
                                                System.out.println(wa);
                                                String ssid="jrrc";
                                                int type=3;
                                                String password="meeting@rhe8O23";
                                                WifiConfiguration wcg=wa.CreateWifiInfo(ssid, password, type);
                                                wa.addNetwork(wcg);


                                            }}
        );


        WifiManager wm = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wm.startScan();

        List<ScanResult> list = wm.getScanResults();
        String rl = "";
        for (
                int n = 0;
                n < list.size(); n++)

        {
            rl = rl + list.get(n).SSID.toString() + "\n";
        }

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(rl);
    }
}
