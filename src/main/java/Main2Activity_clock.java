package com.example.user.myapplication;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Vibrator;

public class Main2Activity_clock extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_clock);
        Bundle bundle =getIntent().getExtras();
        int type =bundle.getInt("type");
        //mediaPlayer=mediaPlayer.create(this,R.raw.pig);

        switch (type){
            case 1:
            mediaPlayer=mediaPlayer.create(this,R.raw.pig);
            break;
            default:
            mediaPlayer=mediaPlayer.create(this,R.raw.japan);
            break;
        }
       mediaPlayer.start();
        Vibrator vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
        new AlertDialog.Builder(this).setTitle("鬧鐘").setMessage("行事曆")
                .setPositiveButton("关闭闹铃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mediaPlayer.stop();
                        finish();
                    }
                }).show();
    }
}
