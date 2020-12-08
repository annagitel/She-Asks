package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddQuestionActivity extends AppCompatActivity {

    Spinner categorySpinner;
    EditText questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        initViews();
        initSpinner();
    }

    private void initViews() {
        questionText = findViewById(R.id.questionText);
        categorySpinner = findViewById(R.id.categorySpinner);
    }

    private void initSpinner() {
        String[] items = new String[]{"Java", "C", "C++", "C#", "Angular", "Html"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        categorySpinner.setAdapter(adapter);
    }

    public void sendQuestion(View view) {
        if (questionText.getText().toString().length() < 5) {
            Toast.makeText(this, getString(R.string.please_enter_question_text), Toast.LENGTH_LONG).show();
        } else {
            Question question = new Question();
            question.setCategory(categorySpinner.getSelectedItem().toString());
            question.setText(questionText.getText().toString());
            question.setDate(System.currentTimeMillis());

            new FirebaseHelper().addQuestion(question);
            Toast.makeText(this, "Question added to DB", Toast.LENGTH_LONG).show();
        }
    }

}