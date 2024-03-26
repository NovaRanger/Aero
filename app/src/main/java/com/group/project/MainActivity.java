// MainActivity.java
package com.group.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.res.Resources;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private LinearLayout buttonLayout;
    private String[] commandSequence; // Command sequence array
    private String[] nextCommandSequence; // Next command sequence array
    private int commandIndex = 0;

    private Button upButton, downButton, leftButton, rightButton;
    private TextView currentCommandTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_pad_layout);

        buttonLayout = findViewById(R.id.buttonLayout);
        currentCommandTextView = findViewById(R.id.currentCommandText);

        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);

        // Set onClickListener for buttons
        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);

        // Load command sequences from resources
        CommandSequenceLoader.loadCommandSequences(this);
        UpdateCommandText.updateCurrentAndNextCommandText(this, commandSequence, nextCommandSequence, commandIndex);
    }

    public void setCommandSequences(String[] commandSequence, String[] nextCommandSequence) {
        this.commandSequence = commandSequence;
        this.nextCommandSequence = nextCommandSequence;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.upButton || viewId == R.id.downButton || viewId == R.id.leftButton || viewId == R.id.rightButton) {
            String currentCommand = commandSequence[commandIndex];
            if (CommandChecker.checkCommand(currentCommand, viewId)) {
                Log.d(TAG, "Correct button clicked for command: " + currentCommand);
                commandIndex++;
                UpdateCommandText.updateCurrentAndNextCommandText(this, commandSequence, nextCommandSequence, commandIndex);
            } else {
                Log.d(TAG, "Incorrect button clicked for command: " + currentCommand);
            }
        }
    }
}











