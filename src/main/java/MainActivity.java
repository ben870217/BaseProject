package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    private Button button1,button2,button3;
    private TextView textView1;
    LinearLayout myapp;
    public void onCreate (Bundle save01){
        super.onCreate(save01);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button4);
        textView1=(TextView)findViewById(R.id.text);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent();
                Intent intent1 = intent.setClass(MainActivity.this, Bus_Time_Zone.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 =new Intent();
                Intent intent3 = intent2.setClass(MainActivity.this,Main2Activity_setting.class);
                startActivity(intent2);
                break;
            case R.id.button4:
                Intent intent4 =new Intent();
                Intent intent5 = intent4.setClass(MainActivity.this,show.class);
                startActivity(intent4);
                break;
        }
    }

    public static int add(int a , int b) {
        return a + b;
    }


}





