package com.group.project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_activity);

        ImageView greenButton = findViewById(R.id.GreenButton);
        ImageView YellowButton = findViewById(R.id.YellowButton);
        ImageView PinkButton = findViewById(R.id.PinkButton);
        ImageView DefaultButton = findViewById(R.id.defaultButton);

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Green_Theme);
                recreate();
            }
        });

        YellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Yellow_Theme);
                recreate();
            }
        });

        PinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Pink_Theme);
                recreate();
            }
        });

        DefaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTheme();
            }
        });





//            private void startMainActivity() {
//                Intent intent = new Intent(ColorActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
    }
    private void changeTheme(int themeId) {
        Intent intent = new Intent(ColorActivity.this, MainActivity.class);
        intent.putExtra("themeId", themeId);
        startActivity(intent);
    }

    public void clearTheme() {
        changeTheme(0);
    }
}


