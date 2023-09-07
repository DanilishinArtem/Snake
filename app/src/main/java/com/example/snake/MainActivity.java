package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        constants.SCREEN_HEIGHT = dm.heightPixels;
        constants.SCREEN_WIDTH = dm.widthPixels;
        setContentView(R.layout.activity_main);





        TextView score, bestScore;
        score = findViewById(R.id.score);
        bestScore = findViewById(R.id.bestScore);
        score.setText("X" + "5");
        bestScore.setText("X" + "5");
    }
}