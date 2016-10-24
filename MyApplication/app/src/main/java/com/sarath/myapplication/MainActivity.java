package com.sarath.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int SPLASH_TIME_OUT =10000;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.btnLaunchMap);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Welcome.class));

            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void process(View view) {
        Intent intent =null,chooser=null;
        switch (view.getId()){

            case R.id.btnLaunchMap:
                intent = new Intent(Intent.ACTION_VIEW );
                intent.setData(Uri.parse("geo:20.40,50.70"));
                chooser =Intent.createChooser(intent,"Launch Maps");
                startActivity(intent);
                break;
            case R.id.btnMarket:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=dolphin.developers.com"));
                chooser =Intent.createChooser(intent,"Launch Market");
                startActivity(chooser);
            case R.id.btnMail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                String[] to = {"kumarnsarath7@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "hi");
                intent.putExtra(Intent.EXTRA_TEXT,"This is my first mail");
                startActivity(intent);

        }
    }
}
