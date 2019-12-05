package com.example.assignmentseven.assignmenteight;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.assignmentseven.assignmenteight.Scoring.HScoreManager;

import java.util.List;

public class HighScoreTable extends AppCompatActivity {
    ListView hList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fullscreen();
        Intent i = getIntent();
        String uName=i.getStringExtra("USER_NAME");
        int score = i.getIntExtra("SCORE", -1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore_screen);
        //This shows that is can be passed a name value however, still need to work out the scoring to pass that value too
        HScoreManager hm = new HScoreManager();
        hm.addScore(uName,score);

        String[] list = hm.getHighscoreString().split(",");

        hList = (ListView)findViewById(R.id.hScoreListView);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        hList.setAdapter(arrayAdapter);
        //System.out.print( hm.getHighscoreString());

        Button restartButton = (Button)findViewById(R.id.button_restart);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        restartButton.setOnClickListener(onClickListener);
    }
    protected void fullscreen() {
        ActionBar ab = getSupportActionBar();
        ab.hide();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }
}
