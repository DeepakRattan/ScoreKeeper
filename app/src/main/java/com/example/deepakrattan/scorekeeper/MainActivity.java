package com.example.deepakrattan.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtScore1, txtScore2;
    private ImageButton imgBtnDecreaseTeam1, imgBtnIncreaseTeam1, imgBtnDecreaseTeam2, imgBtnIncreaseTeam2;
    private int score1, score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        txtScore1 = (TextView) findViewById(R.id.txtScore1);
        txtScore2 = (TextView) findViewById(R.id.txtScore2);
        imgBtnDecreaseTeam1 = (ImageButton) findViewById(R.id.imgBtnDecreaseTeam1);
        imgBtnDecreaseTeam2 = (ImageButton) findViewById(R.id.imgBtnDecreaseTeam2);
        imgBtnIncreaseTeam1 = (ImageButton) findViewById(R.id.imgBtnIncreaseTeam1);
        imgBtnIncreaseTeam2 = (ImageButton) findViewById(R.id.imgBtnIncreaseTeam2);

        txtScore1.setText(String.valueOf(score1));
        txtScore2.setText(String.valueOf(score2));

        imgBtnDecreaseTeam1.setOnClickListener(this);
        imgBtnDecreaseTeam2.setOnClickListener(this);
        imgBtnIncreaseTeam1.setOnClickListener(this);
        imgBtnIncreaseTeam2.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nightMode = AppCompatDelegate.getDefaultNightMode();
                if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnDecreaseTeam1:
                //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                score1--;
                txtScore1.setText(String.valueOf(score1));
                break;
            case R.id.imgBtnDecreaseTeam2:
                //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                score2--;
                txtScore2.setText(String.valueOf(score2));
                break;
            case R.id.imgBtnIncreaseTeam1:
                //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                score1++;
                txtScore1.setText(String.valueOf(score1));
                break;
            case R.id.imgBtnIncreaseTeam2:
                //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
                score2++;
                txtScore2.setText(String.valueOf(score2));
                break;
        }

    }
}
