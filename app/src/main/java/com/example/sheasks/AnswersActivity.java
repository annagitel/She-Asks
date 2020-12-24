package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AnswersActivity extends AppCompatActivity {

    TextView questionText;
    TextView questionDate;
    TextView questionCategory;

    EditText answerText;
    RecyclerView answersRecyclerView;
    AnswersAdapter answersAdapter;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        question = (Question) getIntent().getSerializableExtra("question");

        initViews();
        initAnswersList();
    }

    private void initViews() {
        questionText = findViewById(R.id.questionText);
        questionDate = findViewById(R.id.dateText);
        questionCategory = findViewById(R.id.categoryText);

        questionText.setText(question.getCategory());
        questionDate.setText(question.getText());
        questionCategory.setText(new SimpleDateFormat("HH:mm MM/dd/yy").format(new Date(question.getDate())));

        answerText = findViewById(R.id.answerText);
        answersRecyclerView = findViewById(R.id.answersList);

        answersAdapter = new AnswersAdapter(getApplicationContext());
        answersRecyclerView.setAdapter(answersAdapter);
        answersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAnswersList() {
        new FirebaseHelper().getQuestionAnswers(question.getKey(), new FirebaseHelper.OnGetAnswersListener() {
            @Override
            public void onSuccess(ArrayList<Answer> answers) {
                answersAdapter.setAnswers(answers);
            }
        });
    }

    public void AddAnswer(View view) {
        String text = answerText.getText().toString();
        if (answerText.length() < 5) {
            Toast.makeText(this, "Please enter answer text", Toast.LENGTH_LONG).show();
        } else {
            Answer answer = new Answer(text, System.currentTimeMillis(), FirebaseHelper.user.getEmail());
            new FirebaseHelper().addAnswer(answer, question.getKey());
            answersAdapter.addAnswer(answer);
        }
    }
}