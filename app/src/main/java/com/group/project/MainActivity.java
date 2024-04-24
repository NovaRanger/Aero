package com.group.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private LinearLayout buttonLayout;
    private String[] currentCommandSequence; // Current command sequence array
    private int commandIndex = 0;
    private int score = 0; // Declaring the score variable

    private Button upButton, downButton, leftButton, rightButton;
    private TextView currentCommandTextView, scoreTextView; // Initializing to display the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_pad_layout);

        // Making it to where it grabs the layout color changes

        Intent intent = getIntent();
        int layoutId = intent.getIntExtra("layoutId", R.layout.d_pad_layout);
        setContentView(layoutId);

        buttonLayout = findViewById(R.id.buttonLayout);
        currentCommandTextView = findViewById(R.id.currentCommandText);
        scoreTextView = findViewById(R.id.scoreText); // To display the score

        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);

        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);

        loadRandomCommandSequence();
        displayCurrentCommand();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.upButton || viewId == R.id.downButton || viewId == R.id.leftButton || viewId == R.id.rightButton) {
            String currentCommand = currentCommandSequence[commandIndex];
            if (CommandChecker.checkCommand(currentCommand, viewId)) {
                Log.d(TAG, "Correct button clicked for command: " + currentCommand);
                score += 10; // Incrementing by 10
                scoreTextView.setText(String.valueOf(score)); // Displaying the text
                commandIndex++;
                if (commandIndex >= currentCommandSequence.length) {
                    loadRandomCommandSequence(); // Load next array
                    commandIndex = 0; // Reset command index for the new array
                }
                displayCurrentCommand(); // Display current command or next array
            } else {
                Log.d(TAG, "Incorrect button clicked for command: " + currentCommand);
                navigateToEndScreen();
            }
        }
    }

    private void loadRandomCommandSequence() {
        Resources res = getResources();
        String[] arrayNames = res.getStringArray(R.array.command_sequence_arrays);
        int arrayCount = arrayNames.length;
        if (arrayCount > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(arrayCount);
            int resourceId = res.getIdentifier(arrayNames[randomIndex], "array", getPackageName());
            currentCommandSequence = res.getStringArray(resourceId);
        }
    }
    private void displayCurrentCommand() {
        SpannableStringBuilder commandStringBuilder = new SpannableStringBuilder();

        for (int i = commandIndex; i < currentCommandSequence.length; i++) {
            String commandName = currentCommandSequence[i];
            int resourceId = getResources().getIdentifier("command_" + commandName.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(resourceId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
                SpannableString spannableString = new SpannableString(commandName);
                spannableString.setSpan(imageSpan, 0, commandName.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                commandStringBuilder.append(spannableString).append(" ");
            }
        }

        currentCommandTextView.setText(commandStringBuilder);
    }



    private void navigateToEndScreen() {
        Intent intent = new Intent(this, GameoverActivity.class);
        intent.putExtra("SCORE", score); // Bringing the score to end screen
        startActivity(intent);
        finish();
    }
}