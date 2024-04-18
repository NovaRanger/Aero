package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

// CONOR - WILL BE WHERE THE HELP AND SETTINGS ARE

public class HelpActivity extends AppCompatActivity {


    Button settings;
    Button Color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);

        settings=findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HelpActivity.this, SettingsActivity.class);
                startActivity(intent);


            }


        });



    }

    public void onColorClick(View view){
        Intent intent = new Intent(this, ColorActivity.class);
        startActivity(intent);
    }

    public void onAboutClick(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
