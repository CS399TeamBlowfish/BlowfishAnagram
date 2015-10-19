package com.android.blowfishanagram;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Alex on 10/18/2015.
 */
public class GameTimeIsUpDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_time_is_up)
                .setNeutralButton(R.string.viewResults, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // View Results!
                    }
                })
                .setPositiveButton(R.string.newGame, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // New Game
                    }
                })
                .setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Quit
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
