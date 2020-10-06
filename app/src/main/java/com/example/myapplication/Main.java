package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    private EditText et_tel = null;
    private Button btn_telephonyCall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.tel_main);

        et_tel = (EditText)findViewById(R.id.et_tel);
        btn_telephonyCall = (Button)findViewById(R.id.btn_telephoneCall);
        btn_telephonyCall.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTelephonyNum = et_tel.getText().toString();
                Uri uri = Uri.parse("tel:" + strTelephonyNum);
                Intent it = new Intent();
                it.setAction(Intent.ACTION_DIAL); //跳到打电话的apk上去，准备打电话
                //  it.setAction(Intent.ACTION_CALL); //直接就打电话了,我这边测试有点问题，权限设定不对？
                it.setData(uri);
                Main.this.startActivity(it);
            }
        });
    }
}
