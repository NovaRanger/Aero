package com.group.project;

import android.util.Log;

public class CommandChecker {
    private static final String TAG = "CommandChecker";

    // Method to check if the correct buttons are clicked for the given command
    public static boolean checkCommand(String command, int buttonId) {
        switch (command) {
            case "UP":
                return buttonId == R.id.upButton;
            case "DOWN":
                return buttonId == R.id.downButton;
            case "LEFT":
                return buttonId == R.id.leftButton;
            case "RIGHT":
                return buttonId == R.id.rightButton;
            default:
                Log.w(TAG, "Unknown command");
                return false;
        }
    }
}


