package com.android.blowfishanagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Button;


public class Results extends AppCompatActivity {
    TextView correct;
    TextView wrong;
    TextView total;
    private int solved;
    private int unsolved;
    private Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //adds back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        correct = (TextView) findViewById(R.id.textViewCorrect);
        wrong = (TextView) findViewById(R.id.textViewWrong);
        total = (TextView) findViewById(R.id.textViewTotal);

        // get data passed from Game activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // check if bundle has data
        if(bundle != null) {
            solved = bundle.getInt("solved");
        }

        unsolved = 10 - solved;
        correct.setText("Correct: " + solved);
        wrong.setText("Wrong/Unanswered: " + unsolved);
        total.setText("Total: 10");

        playAgain = (Button) findViewById(R.id.btnPlayAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Game.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }


    //May want to refactor in own class
    public void game(View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
