package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JavaCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_category);
    }

     public void addQuestionActivity(View view) {
        startActivity(new Intent(this, AddQuestionActivity.class));
    }

    public void searchQuestionActivity(View view) {
        startActivity(new Intent(this, SearchQuestionActivity.class));
    }
}