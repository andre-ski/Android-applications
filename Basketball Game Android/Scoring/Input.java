package com.example.assignmentseven.assignmenteight.Scoring;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignmentseven.assignmenteight.GameScene;
import com.example.assignmentseven.assignmenteight.HighScoreTable;
import com.example.assignmentseven.assignmenteight.R;

public class Input extends AppCompatActivity {
    String name;
    Integer uScore;
    EditText nameInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fullscreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinput);

        Intent i = getIntent();
        Integer uScore=Integer.getInteger(i.getStringExtra("SCORE"));

        nameInput=(EditText) findViewById(R.id.nameInput);
        submitButton=(Button) findViewById(R.id.button2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nameInput.getText().toString();
                showToast(name);
                openActivity();
            }
        });
    }
    protected void fullscreen() {
        ActionBar ab = getSupportActionBar();
        ab.hide();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    private void showToast(String text){
        Toast.makeText(Input.this,text,Toast.LENGTH_SHORT).show();
    }
    public void openActivity() {
        Intent intent = new Intent(this, HighScoreTable.class);
        //Pass the entered name onto the highscore table thing
        intent.putExtra("USER_NAME", name);
        intent.putExtra("SCORE",uScore);
        startActivity(intent);
    }
}
