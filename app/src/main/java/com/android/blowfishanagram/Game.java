package com.android.blowfishanagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Challenges challenges = new Challenges();
        String challenge = challenges.getChallenge(0);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_blowfish);
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
    public void results(View view){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }
}
