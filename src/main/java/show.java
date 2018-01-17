package com.example.user.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class show extends AppCompatActivity implements View.OnClickListener{
    private Button button11,button9,button10;
    TextView tv;
    String[] data = new String[10];
    String[] thing = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tv = (TextView)findViewById(R.id.textView);
        button9 = (Button)findViewById(R.id.button9);
        button10 = (Button)findViewById(R.id.button10);
        button11 = (Button)findViewById(R.id.button11);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        data = bundle.getStringArray("data");
        thing = bundle.getStringArray("thing");
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button9:
                tv.setMovementMethod(new ScrollingMovementMethod());
                tv.setText(data[0] + "\n" + thing[0] + "\n" + data[1] + "\n" + thing[1] + "\n" + data[2] + "\n" + thing[2] + "\n" + data[3] + "\n" + thing[3] + "\n" + data[4] + "\n" + thing[4] + "\n" + data[5] + "\n" + thing[5] + "\n" + data[6] + "\n" + thing[6] + "\n" + data[7] + "\n" + thing[7] + "\n" + data[8] + "\n" + thing[8] + "\n" + data[9] + "\n" + thing[9] + "\n");
                tv.setTextColor(Color.rgb(255,0,0));
                tv.setTextSize(40.0f);
                break;
            case R.id.button10:
                tv.setMovementMethod(new ScrollingMovementMethod());
                tv.setText(data[0] + "\n" + thing[0] + "\n" + data[1] + "\n" + thing[1] + "\n" + data[2] + "\n" + thing[2] + "\n" + data[3] + "\n" + thing[3] + "\n" + data[4] + "\n" + thing[4] + "\n" + data[5] + "\n" + thing[5] + "\n" + data[6] + "\n" + thing[6] + "\n" + data[7] + "\n" + thing[7] + "\n" + data[8] + "\n" + thing[8] + "\n" + data[9] + "\n" + thing[9] + "\n");
                tv.setTextColor(Color.rgb(0,255,0));
                tv.setTextSize(30.0f);
                break;
            case R.id.button11:
                tv.setMovementMethod(new ScrollingMovementMethod());
                tv.setText(data[0] + "\n" + thing[0] + "\n" + data[1] + "\n" + thing[1] + "\n" + data[2] + "\n" + thing[2] + "\n" + data[3] + "\n" + thing[3] + "\n" + data[4] + "\n" + thing[4] + "\n" + data[5] + "\n" + thing[5] + "\n" + data[6] + "\n" + thing[6] + "\n" + data[7] + "\n" + thing[7] + "\n" + data[8] + "\n" + thing[8] + "\n" + data[9] + "\n" + thing[9] + "\n");
                tv.setTextColor(Color.rgb(0,0,255));
                tv.setTextSize(20.0f);
                break;
        }
    }
}
