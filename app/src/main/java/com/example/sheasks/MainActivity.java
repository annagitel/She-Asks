package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchQuestionActivity(View view) {
        startActivity(new Intent(this, SearchQuestionActivity.class));
    }

    public void addErrorInAppActivity(View view) {
        startActivity(new Intent(this, AddErrorInAppActivity.class));
    }

    public void addQuestionActivity(View view) {
        startActivity(new Intent(this, AddQuestionActivity.class));
    }
}