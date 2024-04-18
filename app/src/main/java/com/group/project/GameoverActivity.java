package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

// LIZ - GAMEOVER / END SCREEN WITH SCORE

public class GameoverActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover_activity);
    }
    public void onReplayClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onMenuClick(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}
