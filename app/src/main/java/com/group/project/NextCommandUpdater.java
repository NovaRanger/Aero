// NextCommandUpdater.java
package com.group.project;
import android.widget.TextView;

public class NextCommandUpdater {

    public static void updateNextCommandText(MainActivity activity, String[] nextCommandSequence, int commandIndex) {
        TextView nextCommandTextView = activity.findViewById(R.id.nextCommandText);
        if (commandIndex < nextCommandSequence.length) {
            nextCommandTextView.setText(nextCommandSequence[commandIndex]);
        } else {
            nextCommandTextView.setText("None");
        }
    }
}

