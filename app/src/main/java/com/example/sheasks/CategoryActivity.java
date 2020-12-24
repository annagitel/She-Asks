package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    String category;
    TextView categoryTitle;
    RecyclerView questionsRecyclerView;
    QuestionsAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category = getIntent().getStringExtra("category");

        initViews();
        initQuestionsList();
    }

    private void initViews() {
        questionsRecyclerView = findViewById(R.id.questionsList);
        categoryTitle = findViewById(R.id.categoryTitle);
        categoryTitle.setText(category);

        questionsAdapter = new QuestionsAdapter(this);
        questionsRecyclerView.setAdapter(questionsAdapter);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initQuestionsList() {
        new FirebaseHelper().getQuestions(category, new FirebaseHelper.OnGetQuestionsListener() {
            @Override
            public void onSuccess(ArrayList<Question> questions) {
                questionsAdapter.setQuestions(questions);
            }
        });
    }
}