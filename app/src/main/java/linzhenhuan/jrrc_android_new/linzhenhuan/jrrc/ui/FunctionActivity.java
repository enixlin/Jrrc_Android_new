package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import linzhenhuan.jrrc_android_new.R;
import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.dao.functionListAdapter;

public class FunctionActivity extends Activity {
    private ListView functionListView = null;
    private functionListAdapter Adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        initialView();

    }


    private void initialView() {
        functionListView = (ListView) findViewById(R.id.lv_functionList);
        Adapter = new functionListAdapter(FunctionActivity.this);
        Adapter.add("title1", "des1", R.drawable.png0001);
        Adapter.add("title2", "des2", R.drawable.png0002);
        Adapter.add("title3", "des3", R.drawable.png0003);
        Adapter.add("title4", "des4", R.drawable.png0004);
        Adapter.add("title5", "des5", R.drawable.png0005);
        Adapter.add("title6", "des6", R.drawable.png0006);
        Adapter.add("title7", "des7", R.drawable.png0007);
        Adapter.add("title1", "des1", R.drawable.png0001);
        Adapter.add("title2", "des2", R.drawable.png0002);
        Adapter.add("title3", "des3", R.drawable.png0003);
        Adapter.add("title4", "des4", R.drawable.png0004);
        Adapter.add("title5", "des5", R.drawable.png0005);
        Adapter.add("title6", "des6", R.drawable.png0006);
        Adapter.add("title7", "des7", R.drawable.png0007);
        Adapter.add("title1", "des1", R.drawable.png0001);
        Adapter.add("title2", "des2", R.drawable.png0002);
        Adapter.add("title3", "des3", R.drawable.png0003);
        Adapter.add("title4", "des4", R.drawable.png0004);
        Adapter.add("title5", "des5", R.drawable.png0005);
        Adapter.add("title6", "des6", R.drawable.png0006);
        Adapter.add("title7", "des7", R.drawable.png0007);
        Adapter.add("title1", "des1", R.drawable.png0001);
        Adapter.add("title2", "des2", R.drawable.png0002);
        Adapter.add("title3", "des3", R.drawable.png0003);
        Adapter.add("title4", "des4", R.drawable.png0004);
        Adapter.add("title5", "des5", R.drawable.png0005);
        Adapter.add("title6", "des6", R.drawable.png0006);
        Adapter.add("title7", "des7", R.drawable.png0007);
        functionListView.setAdapter(Adapter);

    }
}
