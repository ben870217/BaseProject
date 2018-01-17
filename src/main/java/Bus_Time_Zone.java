package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Bus_Time_Zone extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private Button btn3, btn11;
    Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__time__zone);
        text = (TextView) findViewById(R.id.textView3);
        btn3 = (Button) findViewById(R.id.button3);
        btn11 = (Button) findViewById(R.id.button11);
        btn3.setOnClickListener(this);
        btn11.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                text.setText(webCrawl());
                t = new Thread() {
                    public void run() {
                        text.setText(getInforTime(webCrawl()));
                    }
                };
                t.start();

                break;
            case R.id.button3:
                String txt = "";
                try {
                    InputStream word = getAssets().open("BusZone.txt");
                    int size = word.available();
                    byte[] buffer = new byte[size];
                    word.read(buffer);
                    word.close();
                    txt = new String(buffer);
                } catch (Exception e4) {
                    System.out.println(e4);
                }
                text.setMovementMethod(new ScrollingMovementMethod());
                text.setText(txt);
        }
    }

    public String getInforTime(String s) {
        JSONArray ID=null;
        String zone="";
        String carid = "car", lastcar="", result="";
        try {
            ID = new JSONArray(s);

            int length = ID.length();
            int i;
            for(i = 0; i < ID.length(); i++){
                zone = ID.getJSONObject(i).getString("ComeTime");
                carid = ID.getJSONObject(i).getString("ComeCarId");
                if(carid.equals(lastcar)){

                }else{
                    result = result + carid + "      " + zone + "\n";
                    lastcar = carid;
                }
            }
        } catch  (Exception e){
            System.out.println(e);
        }
        return result;
    }

   /* public String getInforCarId(String s) {
        JSONArray ID=null;
        String zone="";
        try {
            ID = new JSONArray(s);

            int length = ID.length();
            int i;
            for(i = 0; i < ID.length(); i++){

                zone = ID.getJSONObject(i).getString("ComeCarId");
            }
        } catch  (Exception e3){
            System.out.println(e3);
        }
        return zone;
    }*/

    public String webCrawl(){
        //定義即將訪問的連接
        String url = "http://citybus.taichung.gov.tw/cms//api/route/eta/167,25,29,35,3541,359,37,45,451,459,460,5,921,922";
        // 定義一個字串來存取網頁的內容
        String result = "";
        // 定義一個緩衝字符輸入流
        BufferedReader in = null;
        try
        {
            //將轉成URL
            URL realUrl = new URL(url);
            //初始化一個鏈接到那個url的連接
            URLConnection connection = realUrl.openConnection();
            //開始實際的連接
            connection.connect();
            // 初始化 BufferedReader輸入來讀取URL的響應
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 用來臨時儲存抓取到的每一行的數據
            String line;
            while ((line = in.readLine()) != null)
            {
                // 遍歷抓取到的每一行並將其儲存到result裡面
                result += line + "\n";
            }
        } catch (Exception e) {
            System.out.println("發送get異常！" + e);
            e.printStackTrace();
        } // 使用finally關閉輸入量
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        };
        System.out.println(result);
        return result;
    }
}
