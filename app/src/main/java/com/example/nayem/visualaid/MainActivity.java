package com.example.nayem.visualaid;


import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.text.Html;
import android.view.View;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.va);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int arg0) {
                if(arg0 == TextToSpeech.SUCCESS)
                {
                    t1.setLanguage(Locale.US);
                    try {
                        welcome();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });



    }



    public void nonuserActivity(View v){
        Intent intent = new Intent(getApplicationContext(), authentication.class);
        //Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }
    public void userActivity(View v){
        Intent intent = new Intent(getApplicationContext(), User.class);
        startActivity(intent);

    }

    private void welcome() throws InterruptedException {
           String toSpeak = "welcome to visual aid";
           t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


    }

}
/*
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_below="@+id/nonuser"
        android:onClick="userActivity"
        android:src="@drawable/bac" />

 */