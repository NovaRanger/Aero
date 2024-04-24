package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_activity);

        ImageButton defaultButton = findViewById(R.id.defaultButton);
        defaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivityWithLayout(R.layout.d_pad_layout);
            }
        });

        ImageButton yellowButton = findViewById(R.id.YellowButton);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivityWithLayout(R.layout.d_pad_layout_yellow);
            }
        });

        ImageButton pinkButton = findViewById(R.id.PinkButton);
        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivityWithLayout(R.layout.d_pad_layout_pink);
            }
        });

        ImageButton greenButton = findViewById(R.id.GreenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivityWithLayout(R.layout.d_pad_layout_green);
            }
        });
    }

    private void startMainActivityWithLayout(int layoutId) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("layoutId", layoutId);
        startActivity(intent);
    }
}