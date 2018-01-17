package com.example.user.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static android.app.ProgressDialog.show;

public class Main2Activity_setting extends AppCompatActivity implements View.OnClickListener {
    private  Button btn_set;
    private  Button btn_cancel;
    private Button bt;
    private  Button btn5;
    private AlarmManager alarmManager;
    private PendingIntent pi;
    public String data;
    public String thing;
    public static int i=0,f,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_setting);
        bindViews();
       /* Button bt=(Button)findViewById(R.id.button5);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et1=(EditText)findViewById(R.id.editText);
                String input =et1.getText().toString();
            }
        });*/
    }
    private void bindViews(){
        btn_set=(Button)findViewById(R.id.button6);
        btn_cancel=(Button)findViewById(R.id.button7);
        bt=(Button)findViewById(R.id.button8);
        btn5=(Button)findViewById(R.id.button5);

        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent =new Intent(Main2Activity_setting.this,Main2Activity_clock.class);
        /*RadioGroup rd =(RadioGroup)findViewById(R.id.radioGroup);
        Bundle bundle =new Bundle();
        int type=1;
        switch(rd.getCheckedRadioButtonId()){
            case R.id.radioButton:
                type=1;
                break;
            case R.id.radioButton2:
                type=2;
                break;
        }
        bundle.putInt("type",type);*/
        intent.setClass(this,Main2Activity_clock.class);
        //intent.putExtras(bundle);
        pi= PendingIntent.getActivity(Main2Activity_setting.this,0,intent,0);
        btn_set.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        bt.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }
    public  void onClick(View v){
        switch (v.getId()){
            case R.id.button6:
                Calendar currentTime =Calendar.getInstance();
                new TimePickerDialog(Main2Activity_setting.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int i, int i1) {
                     Calendar c =Calendar.getInstance();
                     c.setTimeInMillis(System.currentTimeMillis());
                     c.set(Calendar.HOUR,i);
                     c.set(Calendar.MINUTE,i1);
                     alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pi);
                        Log.e("HEHE",c.getTimeInMillis()+"");
                        Toast.makeText(Main2Activity_setting.this,"設置完畢"+c.getTimeInMillis(),Toast.LENGTH_SHORT).show();
                    }
                },currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),false).show();

             btn_cancel.setVisibility(View.VISIBLE);
             break;

             case R.id.button7:
                alarmManager.cancel(pi);
                btn_cancel.setVisibility(View.GONE);
                Toast.makeText(Main2Activity_setting.this,"鬧鐘取消",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button8:
                RadioGroup rd =(RadioGroup)findViewById(R.id.radioGroup);
                Bundle bundle =new Bundle();
                Intent intent=new Intent();
                intent.setClass(this,Main2Activity_clock.class);

                int type=1;
                switch(rd.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        type=1;
                        break;
                    case R.id.radioButton2:
                        type=2;
                        break;
                }
                bundle.putInt("type",type);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.button5:
                EditText ed = (EditText) findViewById(R.id.editText);
                data=ed.getText().toString();
                EditText ed2=(EditText)findViewById(R.id.editText2);
                thing=ed2.getText().toString();
                String [] data1= new  String[10];
                String []things1=new  String[10];

                if(i==0){
                    data1[i]=data;
                    things1[i]=thing;
                }
                else
                {
                    for(f=0;f<10;f++){
                        if(data1[f].equals(data)){
                            things1[f]=thing;
                            flag++;
                        }
                    }
                    if(flag==0){
                        i++;
                        data1[i]=data;
                        things1[i]=thing;
                    }
                    else{
                        flag=0;
                    }
                }
                Intent i1=new Intent();
                i1.setClass(Main2Activity_setting.this,show.class);
                Bundle ii=new Bundle();
                ii.putStringArray("data",data1);
                ii.putStringArray("thing",things1);
                i1.putExtras(ii);
                startActivity(i1);
                break;

        }
    }


}
