package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    gameView GameView;
    Button button;
    TextView bestScore, score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        constants.SCREEN_HEIGHT = dm.heightPixels;
        constants.SCREEN_WIDTH = dm.widthPixels;
        setContentView(R.layout.activity_main);
        bestScore = findViewById(R.id.bestScore);
        score = findViewById(R.id.score);
        GameView = findViewById(R.id.gv);
        button = findViewById(R.id.button);
        button.setClickable(false);
        button.setVisibility(View.INVISIBLE);
        GameView.setTextView(score, bestScore, button);





    }
}