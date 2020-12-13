package com.example.sheasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
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
