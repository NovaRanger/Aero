package com.group.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        StringBuilder commandStringBuilder = new StringBuilder();
        for (int i = commandIndex; i < currentCommandSequence.length; i++) {
            commandStringBuilder.append(currentCommandSequence[i]);
            commandStringBuilder.append(" "); // Add space between commands
        }
        String currentCommands = commandStringBuilder.toString().trim(); // Remove trailing space
        currentCommandTextView.setText(currentCommands);
    }


    private void navigateToEndScreen() {
        Intent intent = new Intent(this, GameoverActivity.class);
        intent.putExtra("SCORE", score); // Bringing the score to end screen
        startActivity(intent);
        finish();
    }
}