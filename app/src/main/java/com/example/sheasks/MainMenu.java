package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button reportProblemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        reportProblemBtn = findViewById(R.id.reportProblemBtn);

        if (FirebaseHelper.user.getAdmin().equals("1")) {
            reportProblemBtn.setEnabled(true);
        } else {
            reportProblemBtn.setEnabled(false);
        }
    }

    public void goToJava(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", "Java");
        startActivity(intent);
    }

    public void goToGit(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", "Git");
        startActivity(intent);    }

    public void goToPython(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", "Python");
        startActivity(intent);    }

    public void goToWeb(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", "Web");
        startActivity(intent);    }

    public void goToSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }

    public void goToErrors(View view) {
        startActivity(new Intent(this, AddErrorInAppActivity.class));
    }


    public void searchQuestionActivity(View view) {
        startActivity(new Intent(this, SearchQuestionActivity.class));
    }

    public void addQuestionActivity(View view) {
        startActivity(new Intent(this, AddQuestionActivity.class));
    }
}
