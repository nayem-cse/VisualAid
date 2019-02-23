package com.example.nayem.visualaid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NonUser extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    public static final String mUsername= authData.name;
    public static final String password=authData.pass;
    private ChildEventListener mChildEventListener;
TextView tv,tv2,tv3;

double lon,lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_user);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.va);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        mFirebaseDatabase =FirebaseDatabase.getInstance();
        mMessagesDatabaseReference =mFirebaseDatabase.getReference().child(mUsername).child(password);
        tv=(TextView)findViewById(R.id.userinfo);
        tv2=(TextView)findViewById(R.id.username);
        tv3=(TextView)findViewById(R.id.textView3);


        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//FriendlyMessage frindlyMessage = dataSnapshot.getValue(FriendlyMessage.class);
                data loc =dataSnapshot.getValue(data.class);
                lon=loc.getLongitude();
                lat=loc.getLatitude();
                tv.setText(loc.getText());
                tv2.setText("MR. "+mUsername.toUpperCase( ));
                tv3.setText("Current Location");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mMessagesDatabaseReference.addChildEventListener(mChildEventListener);
    }
    public void goMap(View v){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("lon",lon);
        intent.putExtra("lat",lat);
        startActivity(intent);

    }
}
