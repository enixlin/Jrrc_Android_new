package linzhenhuan.jrrc_android_new;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn_scan = (Button) findViewById(R.id.button3);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wm = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(WIFI_SERVICE);
                WifiConfiguration wcg=new WifiConfiguration();
                wcg.SSID="\""+"ENIXLIN"+"\"";
                wcg.preSharedKey="\""+"39453945LYp"+"\"";
                wcg.


            }
        });

    }


}
