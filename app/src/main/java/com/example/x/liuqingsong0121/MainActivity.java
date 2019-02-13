package com.example.x.liuqingsong0121;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.x.frag.Frag01;
import com.example.x.frag.Frag02;

public class MainActivity extends FragmentActivity {

    private Frag01 frag01;
    private Frag02 frag02;
    private RadioGroup group;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        "image_url": "http://image.wufazhuce.com/FuPgOcbGDD9__fyuCdPBXb5pbA1C" }, {
//      "http://image.wufazhuce.com/Fu6o0fqKHsI_TjdpPX3N2Kc99vNP" },
//    { http://image.wufazhuce.com/FmDRnQ1XhReHRHB4jYqAPSx8htsP"
//            "image_url": "http://image.wufazhuce.com/FvVmWbqlle7jlUCTeozoval9NyBH" } ] }
//
        frag01 = new Frag01();
        frag02 = new Frag02();
        group = findViewById(R.id.radgroup);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag,frag01);
        transaction.add(R.id.frag,frag02);
transaction.show(frag01).hide(frag02).commit();

group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();

        switch (checkedId){
            case  R.id.bu1:
                transaction.show(frag01).hide(frag02).commit();

                break;
            case  R.id.bu2:
                transaction.show(frag02).hide(frag01).commit();

                break;
            case  R.id.bu3:
                transaction.show(frag02).hide(frag01).commit();

                break;





        }
    }
});


    }
}
