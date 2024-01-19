package com.truongpd11.a003_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText edtShowData;
    private Button btnSave;

    private void onBinding() {
        edtShowData = findViewById(R.id.edtShowData);
        btnSave = findViewById(R.id.btnSave);
    }

    private void onAction() {
        btnSave.setOnClickListener(this::btnSaveOnClick);
    }

    private void btnSaveOnClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        //có thể đẩy data vào intent => theo kiểu K,V
        String data = edtShowData.getText().toString();
        i.putExtra("result", data);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onBinding();
        onAction();
        onRecieveIntent();
    }

    //Nhận Intent
    private void onRecieveIntent() {
        Intent i = getIntent();
        String data = i.getStringExtra("data");
        int age = i.getIntExtra("age", -1);
        edtShowData.setText("data: " + data + " age:" + age);
    }
    //Do mở activity mới nên khi back thì 2 màn đá qua đá lại => phải truyền dữ liệu vào activity đã có trong backstack chứ không phải taạo activity mới
    // ==> Kỹ thuật để xử lý: Call back!

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("truongpd11", "onstart() of Activity2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("truongpd11", "onResume() of Activity2");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("truongpd11", "onPause() of Activity2");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("truongpd11", "onStop() of Activity2");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("truongpd11", "onDestroy() of Activity2");

    }
}