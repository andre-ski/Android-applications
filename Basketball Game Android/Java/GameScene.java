package com.example.assignmentseven.assignmenteight;

import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        fullscreen();

        ConstraintLayout constrainedLayout = (ConstraintLayout)findViewById(R.id.gameScene);
        constrainedLayout.addView(new GraphicsView(this));
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        SolidCircle.SetScreenBounds(size.x, size.y);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fullscreen();
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
