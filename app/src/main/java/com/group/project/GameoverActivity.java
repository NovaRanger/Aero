package com.group.project;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// LIZ - GAMEOVER / END SCREEN WITH SCORE

public class GameoverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover_activity);

        // Bringing the score to this screen
        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);


        TextView scoreText = findViewById(R.id.scoreText);
        scoreText.setText(String.valueOf(score));
    }

    public void onReplayClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        //Conor's Additions
        SharedPreferences preferences = getSharedPreferences("score_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("score", 0);
        editor.apply();
        //End of Conor's additions

    }

    public void onMenuClick(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);

//        SharedPreferences preferences = getSharedPreferences("score_pref", MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putInt("score", 0);
//        editor.apply();
    }
}
