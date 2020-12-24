package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class SearchQuestionActivity extends AppCompatActivity {

    EditText questionText;
    RecyclerView questionsRecyclerView;
    QuestionsAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_question);

        initViews();
    }

    private void initViews() {
        questionText = findViewById(R.id.questionText);
        questionsRecyclerView = findViewById(R.id.questionsList);

        questionsAdapter = new QuestionsAdapter(this);
        questionsRecyclerView.setAdapter(questionsAdapter);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void SearchQuestion(View view) {
        String searchText = questionText.getText().toString();
        if (searchText.length() < 5) {
            Toast.makeText(this, "Please enter question text", Toast.LENGTH_LONG).show();
        } else {
            new FirebaseHelper().searchQuestion(searchText, new FirebaseHelper.OnGetQuestionsListener() {
                @Override
                public void onSuccess(ArrayList<Question> questions) {
                    questionsAdapter.setQuestions(questions);
                }
            });
        }
    }
}