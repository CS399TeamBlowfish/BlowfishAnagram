package com.android.blowfishanagram;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;

import java.util.Random;

public class Game extends AppCompatActivity {
    TextView GameClock;


//public class Game extends AppCompatActivity {
    private Button[] buttons;
    private int index=0;
    private int rows;
    //private int cols;
    private String challenge;
    private String userSolution="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Challenges challenges = new Challenges();
        String challenge = challenges.getChallenge(0);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_blowfish);

        GameClock = (TextView) findViewById(R.id.textViewGameClock);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                GameClock.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                GameClock.setText("Time is up!");
                showTimesUpDialog();
            }
        }.start();

        populateButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // Handle item selection
        switch (id) {
            case R.id.action_endgame:
                endGame();
                return true;
            case R.id.action_about:
                about();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //May want to refactor in own class
    public void endGame(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void about(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    //Delete
    public void results(){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public void populateButtons(){
        Challenges challenges = new Challenges();
        Random indexGenerator = new Random();
        int loopCounter=0;          //keeps there from being an infinite loop if all the challenges have been solved
        while (loopCounter!= 10 &&  challenges.getSolved(index)){
            index=indexGenerator.nextInt(10);
            loopCounter++;
        }
        if(loopCounter!=10) {
            challenge = challenges.getChallenge(index);
            TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
            rows = challenge.length()/4;
            buttons=new Button[challenge.length()];
            int cols=0;
            int buttonsMade=0;
            for(int row=0;row<=rows;row++){
                TableRow tablerow = new TableRow(this);
                table.addView(tablerow);
                while(cols<4 && buttonsMade<challenge.length()){
                    final char chalChar = challenge.charAt(buttonsMade);
                    Button button=new Button(this);
                    button.setText(String.valueOf(chalChar));
                    button.setPadding(0,0,0,0);     //keeps text from being clipped
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Button b = (Button) v;
                            userSolution+=b.getText().toString();
                        }
                    });
                    buttons[buttonsMade] = button;
                    tablerow.addView(button);

                    cols++;
                    buttonsMade++;
                }
                cols=0;
            }
        }
        else{
            results();
        }
    }

    private void showTimesUpDialog() {
        FragmentManager fm = getSupportFragmentManager();
        GameTimeIsUpDialogFragment timeIsUpDialog = new GameTimeIsUpDialogFragment();
        timeIsUpDialog.show(fm, "fragment_time_is_up");

    }

}
