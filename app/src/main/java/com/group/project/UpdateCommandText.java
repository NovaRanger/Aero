// UpdateCommandText.java
package com.group.project;

import android.widget.TextView;

public class UpdateCommandText {

    public static void updateCurrentAndNextCommandText(MainActivity activity, String[] commandSequence, String[] nextCommandSequence, int commandIndex) {
        TextView currentCommandTextView = activity.findViewById(R.id.currentCommandText);
        if (commandIndex < commandSequence.length) {
            currentCommandTextView.setText(commandSequence[commandIndex]);
            NextCommandUpdater.updateNextCommandText(activity, nextCommandSequence, commandIndex);
        } else {
            currentCommandTextView.setText("None");
            TextView nextCommandTextView = activity.findViewById(R.id.nextCommandText);
            nextCommandTextView.setText("None");
        }
    }
}
