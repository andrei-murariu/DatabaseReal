package com.example.andrei.databasereal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mSendTokenIdReference = mRootReference.child("Token");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendTokenIdReference.setValue("test");
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
    if(dataSnapshot.getValue(String.class)!=null)
    {
        String key = dataSnapshot.getKey();

        if (key.equals("Token"))
        {
            //String token = dataSnapshot.e
        }



    }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mSendTokenIdReference.addValueEventListener(this);
    }
}
