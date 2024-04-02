package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

// HELEN - START PAGE, WILL REDIRECT TO GAME AND HELP PAGE
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    public void onStartGameClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onHelpClick(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}