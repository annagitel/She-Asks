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
        startActivity(new Intent(this, JavaCategory.class));
    }

    public void goToGit(View view) {
        startActivity(new Intent(this, GitCategory.class));
    }

    public void goToPython(View view) {
        startActivity(new Intent(this, PythonCategory.class));
    }

    public void goToWeb(View view) {
        startActivity(new Intent(this, WebCategory.class));
    }

    public void goToSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }

    public void goToErrors(View view) {
        startActivity(new Intent(this, AddErrorInAppActivity.class));
    }
}
