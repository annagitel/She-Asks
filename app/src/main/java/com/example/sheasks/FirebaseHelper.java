package com.example.sheasks;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;

public class FirebaseHelper {

    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef ;
    protected User user ;

    private static String u_email , u_pass;
    private static HashMap<String ,String> hm;



    public void addUser(User user){ // adding a user to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
        Log.d("debug form addUser: ", "createUserWithEmail:success "+FirebaseAuth.getInstance().getCurrentUser().getUid());

    }

    public void readUser(final OnGetDataListener getdata){


        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.child(FirebaseAuth.getInstance().getUid()).getValue(User.class);
                getdata.onSuccess(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public interface OnGetDataListener {
        //this is for callbacks
        void onSuccess(User usr);

    }

    public void userUpdatemap(String key,User user){
        mRef.child(key).setValue(user);
    }

}
