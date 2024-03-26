// CommandSequenceLoader.java
package com.group.project;

import android.content.res.Resources;

public class CommandSequenceLoader {

    public static void loadCommandSequences(MainActivity activity) {
        Resources res = activity.getResources();
        String[] commandSequence = res.getStringArray(R.array.command_sequence);
        String[] nextCommandSequence = res.getStringArray(R.array.next_command_sequence);
        activity.setCommandSequences(commandSequence, nextCommandSequence);
    }
}

