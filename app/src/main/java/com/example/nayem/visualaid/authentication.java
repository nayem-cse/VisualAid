package com.example.nayem.visualaid;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class authentication extends AppCompatActivity {


TextView t1,t2,t3;
String nam,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.va);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }
    public void check(View v){
//        t1=(TextView)findViewById(R.id.editText);
//        authData.name=t1.getText().toString();
//        t2=(TextView)findViewById(R.id.editText1);
//        authData.pass=t2.getText().toString();
//        Intent intent = new Intent(getApplicationContext(), auth2.class);
//        startActivity(intent);


        t1=(TextView)findViewById(R.id.editText);
        nam=t1.getText().toString();
        t2=(TextView)findViewById(R.id.editText1);
        pas=t2.getText().toString();
        t3=(TextView)findViewById(R.id.test);
       // t3.setText(nam+"|\n"+pas+"|\n"+authData.name+"|\n"+authData.pass+"|");
        if(nam.equals( authData.name )){
            if(pas.equals( authData.pass)){
                Intent intent = new Intent(getApplicationContext(), NonUser.class);
                startActivity(intent);
            }

        }
        else{
            t3.setText("Username or password is incorrect");
        }

    }
}
