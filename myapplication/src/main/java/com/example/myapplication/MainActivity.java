package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private String path = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
new Thread(){
    @Override
    public void run() {
        super.run();
        String data = getData();
        Log.e("myMessage",""+data);   }
}.start();  }
    public String getData() {
        try {
      URL url = new URL(path);
     HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 if (urlConnection.getResponseCode()==200){
    InputStream inputStream = urlConnection.getInputStream();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] bytes = new byte[1024];
    int length=0;
    while ((length= inputStream.read(bytes))!=-1){
     Log.e("myMessage",""+new String(bytes,0,length));
        byteArrayOutputStream.write(bytes,0,length);
      }
    String s = byteArrayOutputStream.toString();
    return s;
}    } catch (Exception e) {
            e.printStackTrace();
        }   return null;
    }
}
