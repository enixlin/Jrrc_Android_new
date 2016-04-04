package linzhenhuan.jrrc_android_new;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.net.ParamPairs;

public class TestBundleActivity extends Activity implements View.OnClickListener {
    private TextView tv_getBundleValue;
    private EditText et_setReturnValue;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bundle);
        initialView();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        ParamPairs paramPairs= (ParamPairs) bundle.getSerializable("name");
        tv_getBundleValue.setText(String.format("传递过来的值是name:%s",paramPairs.getValue()));

    }

    public void initialView(){
        tv_getBundleValue= (TextView) findViewById(R.id.tv_getBundleValue);
        et_setReturnValue= (EditText) findViewById(R.id.et_setReturnText);
        btn_back= (Button) findViewById(R.id.btn_backActivity);

        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_backActivity: {
                Intent intent =new Intent();
                setResult(1,intent);
                 intent.putExtra("backdata",et_setReturnValue.getText().toString());
                finish();
            } ;
            break;
        }

    }
}
