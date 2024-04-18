package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

// HELEN - START PAGE, WILL REDIRECT TO GAME AND HELP PAGE
public class StartActivity extends AppCompatActivity {

    // ImageButton helpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        /* helpButton=findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartActivity.this,HelpActivity.class);
                startActivity(intent);
            }


        }); */
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