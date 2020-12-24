package com.example.sheasks;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class FirebaseHelper {

    private FirebaseDatabase mdatabase;
    private DatabaseReference mRef;
    private Query mQuery;
    public static User user;

    public void addUser(FirebaseUser user) { // adding a user to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users");
        mRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
        Log.d("debug form addUser: ", "createUserWithEmail:success " + FirebaseAuth.getInstance().getCurrentUser().getUid());

    }

    public void readUser(final OnGetDataListener getdata) {


        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Users").child(FirebaseAuth.getInstance().getUid());
        mRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                System.out.println(user.getEmail());
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

    public void addAnswer(Answer answer, String questionKey) { // adding an answer to realtime database
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Answers").child(questionKey);
        mRef.push().setValue(answer);
    }

    public void getQuestions(String category, OnGetQuestionsListener getdata) {
        mdatabase = FirebaseDatabase.getInstance();
        mQuery = mdatabase.getReference("Questions").orderByChild("category").equalTo(category);
        mQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Question> questions = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Question q = ds.getValue(Question.class);

                    q.setKey(ds.getKey());
                    questions.add(q);
                }

                getdata.onSuccess(questions);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

    public void getQuestionAnswers(String questionKey, final OnGetAnswersListener getdata) {
        mdatabase = FirebaseDatabase.getInstance();
        mRef = mdatabase.getReference("Answers").child(questionKey);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Answer> answers = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Answer a = ds.getValue(Answer.class);

                    answers.add(a);
                }

                Collections.reverse(answers);
                getdata.onSuccess(answers);
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

    public interface OnGetAnswersListener {
        //this is for callbacks
        void onSuccess(ArrayList<Answer> answers);
    }

    public void userUpdatemap(String key, User user) {
        mRef.child(key).setValue(user);
    }

}
