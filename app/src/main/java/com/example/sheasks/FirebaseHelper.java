package com.example.sheasks;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FirebaseHelper {

    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef;
    protected User user;

    private static String u_email, u_pass;
    private static HashMap<String, String> hm;


    public void addUser(User user) { // adding a user to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
        Log.d("debug form addUser: ", "createUserWithEmail:success " + FirebaseAuth.getInstance().getCurrentUser().getUid());

    }

    public void readUser(final OnGetDataListener getdata) {


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

    public void addQuestion(Question question) { // adding a question to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Questions");
        mRef.push().setValue(question);
    }

    public void searchQuestion(String text, final OnGetQuestionsListener getdata) {
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Questions");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Question> questions = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Question q = ds.getValue(Question.class);

                    if (q.getText().contains(text)) {
                        q.setKey(ds.getKey());
                        questions.add(q);
                    }
                }

                getdata.onSuccess(questions);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void addError(Error error) { // adding an error to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Errors");
        mRef.push().setValue(error);
    }

    public interface OnGetDataListener {
        //this is for callbacks
        void onSuccess(User usr);
    }

    public interface OnGetQuestionsListener {
        //this is for callbacks
        void onSuccess(ArrayList<Question> questions);
    }

    public void userUpdatemap(String key, User user) {
        mRef.child(key).setValue(user);
    }

}
