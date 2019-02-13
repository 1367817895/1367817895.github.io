package com.example.x.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:41:32
 * @Description:
 */
public class Http {
public  static  boolean isNet(Context context){
    if (context!=null){
         ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
if (info!=null){
    return info.isAvailable();

}

    }   return false;
}
    public static String httpGet(String strurl){
        try {
            URL url = new URL(strurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
            StringBuffer buffer = new StringBuffer();
String s="";
if ((s=reader.readLine())!=null){
    buffer.append(s);


}
return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }



}
