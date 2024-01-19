package com.truongpd11.a003_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLoad;
    private Button btnDial;
    private Button btnOpen;
    private EditText edtData;

    private void onBinding() {
        btnLoad = findViewById(R.id.btnLoad);
        btnDial = findViewById(R.id.btnDial);
        btnOpen = findViewById(R.id.btnOpen);
        edtData = findViewById(R.id.edtData);
    }

    private void onAction() {
        btnLoad.setOnClickListener(this::btnLoadClick);
        btnDial.setOnClickListener(this::btnDialClick);
        btnOpen.setOnClickListener(this::btnOpenClick);
    }

    private void btnOpenClick(View view) {
        //Explicit intent -> chỉ rõ cái app component nào thực thi cái nào cho chúng ta
        Intent i = new Intent(this, MainActivity2.class);
        //có thể đẩy data vào intent => theo kiểu K,V
        String data = edtData.getText().toString();
        i.putExtra("data",data);
        i.putExtra("age", 18);
        startActivity(i);

       //Implicit intent -> chỉ rõ cái app component nào thực thi cái nào cho chúng ta
//        Intent i = new Intent(this, MainActivity2.class);
//        startActivity(i);
    }

    private void btnDialClick(View view) {
        String phone = edtData.getText().toString();
        Uri uri = Uri.parse("tel:" + phone);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    private void btnLoadClick(View view) {
        String url = edtData.getText().toString();
        Uri uri = Uri.parse(url);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBinding();
        onAction();
        onRecieveIntent();
    }

    private void onRecieveIntent() {
        Intent i = getIntent();
        String result = i.getStringExtra("result");
        edtData.setText(result);
    }
}