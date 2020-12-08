package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddErrorInAppActivity extends AppCompatActivity {

    Spinner pageSpinner;
    EditText errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_error_in_app);

        initViews();
        initSpinner();
    }

    private void initViews() {
        errorText = findViewById(R.id.errorText);
        pageSpinner = findViewById(R.id.pageSpinner);
    }

    private void initSpinner() {
        String[] items = new String[]{"מסך ראשי", "מסך התחברות", "מסך חיפוש שאלות", "מסך וואטאבר"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        pageSpinner.setAdapter(adapter);
    }

    public void sendError(View view) {
        if (errorText.getText().toString().length() < 5) {
            Toast.makeText(this, "Please enter error text", Toast.LENGTH_LONG).show();
        } else {
            Error error = new Error();
            error.setPage(pageSpinner.getSelectedItem().toString());
            error.setText(errorText.getText().toString());
            error.setDate(System.currentTimeMillis());

            new FirebaseHelper().addError(error);
            Toast.makeText(this, "Question added to DB", Toast.LENGTH_LONG).show();
        }
    }
}