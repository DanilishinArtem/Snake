package com.example.snake;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.location.GnssAntennaInfo;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import android.widget.LinearLayout;
import java.util.logging.LogRecord;

public class gameView extends View {
    private TextView scoreText, BestScore;
    private int bestScore;
    Button button;
    private TextView scoreTextView;
    private Bitmap bmGrass1, bmGrass2, bmSnake, bmApple;
    private Snake snake;
    public static int sizeOfMap = 75 * constants.SCREEN_WIDTH / 1080;
    private int h = 21, w = 12;
    public ArrayList<Grass> arrGrass = new ArrayList<>();
    private boolean move = false;
    private float mx, my;
    private android.os.Handler handler;
    private Runnable r;
    private Object Log;
    private Apple apple;
    public boolean stopGame;
    public gameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        stopGame = false;
        bestScore = 0;
        bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
        bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeOfMap, sizeOfMap, false);

        bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass03);
        bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, sizeOfMap, sizeOfMap, false);

        bmSnake = BitmapFactory.decodeResource(this.getResources(), R.drawable.snake1);
        bmSnake = Bitmap.createScaledBitmap(bmSnake, 14 * sizeOfMap, sizeOfMap, false);

        bmApple = BitmapFactory.decodeResource(this.getResources(), R.drawable.apple);
        bmApple = Bitmap.createScaledBitmap(bmApple, sizeOfMap, sizeOfMap, false);

        for(int i = 0; i < h; i++){
             for(int j = 0; j < w; j++){
                 if((i + j) % 2 == 0){
                     arrGrass.add(new Grass(bmGrass1, j * sizeOfMap + (constants.SCREEN_WIDTH - w * sizeOfMap) / 2,
                             i * sizeOfMap + (constants.SCREEN_HEIGHT - (h + 4) * sizeOfMap) / 2, sizeOfMap, sizeOfMap));
                 }else{
                     arrGrass.add(new Grass(bmGrass2, j * sizeOfMap + (constants.SCREEN_WIDTH - w * sizeOfMap) / 2,
                             i * sizeOfMap + (constants.SCREEN_HEIGHT - (h + 4) * sizeOfMap) / 2, sizeOfMap, sizeOfMap));
                 }
             }
        }
        snake = new Snake(bmSnake, arrGrass.get(126).getX(),arrGrass.get(126).getY(), 4);
        apple = new Apple(bmApple, arrGrass.get(randomApple()[0]).getX(), arrGrass.get(randomApple()[1]).getY());
        handler = new Handler();
        r = new Runnable() {
             @Override
             public void run() {
                 invalidate();
             }
        };

    }
    public void setTextView(TextView scoreText, TextView BestScore, Button button){
        this.BestScore = BestScore;
        this.scoreText = scoreText;
        this.button = button;
        this.scoreText.setText("X " + Integer.toString(snake.getLength() - 4));
    }
    public int[] randomApple(){
        int[] xy = new int[2];
        Random r = new Random();
        xy[0] = r.nextInt(arrGrass.size() - 1);
        xy[1] = r.nextInt(arrGrass.size() - 1);
        Rect rect = new Rect(arrGrass.get(xy[0]).getX(), arrGrass.get(xy[1]).getY(), arrGrass.get(xy[0]).getX() + gameView.sizeOfMap, arrGrass.get(xy[1]).getY() + gameView.sizeOfMap);
        boolean check = true;
        while(check){
            check = false;
            for(int i = 0; i < snake.getLength(); i++){
                if(rect.intersect(snake.getArrPartSnake().get(i).getrBody())){
                    check = true;
                    xy[0] = r.nextInt(arrGrass.size() - 1);
                    xy[1] = r.nextInt(arrGrass.size() - 1);
                    rect = new Rect(arrGrass.get(xy[0]).getX(), arrGrass.get(xy[1]).getY(), arrGrass.get(xy[0]).getX() + gameView.sizeOfMap, arrGrass.get(xy[1]).getY() + gameView.sizeOfMap);
                }
            }
        }
        return xy;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         int a = event.getActionMasked();
         switch (a){
             case MotionEvent.ACTION_MOVE:{
                 if(move == false){
                     mx = event.getX();
                     my = event.getY();
                     move = true;
                 }else{
                     if((mx - event.getX() > 100 * constants.SCREEN_WIDTH / 1000) && !snake.isMove_right()){
                         mx = event.getX();
                         my = event.getY();
                         snake.setMove_left(true);
                     }else if((event.getX() - mx > 100 * constants.SCREEN_WIDTH / 1000) && !snake.isMove_left()){
                         mx = event.getX();
                         my = event.getY();
                         snake.setMove_right(true);
                     }else if((my - event.getY() > 100 * constants.SCREEN_WIDTH / 1000) && !snake.isMove_bottom()){
                         mx = event.getX();
                         my = event.getY();
                         snake.setMove_top(true);
                     }else if((event.getY() - my > 100 * constants.SCREEN_WIDTH / 1000) && !snake.isMove_top()){
                         mx = event.getX();
                         my = event.getY();
                         snake.setMove_bottom(true);
                     }
                 }
                 break;
             }
         }
        return true;
    }
    public boolean collapse(){
        boolean check = false;
        // проверяем тело
        for(int i = 1; i < snake.getLength(); i++){
            if(snake.getArrPartSnake().get(0).getrBody().intersect(snake.getArrPartSnake().get(i).getrBody())){
                check = true;
            }
        }
        if(snake.getArrPartSnake().get(0).getX() <= ((constants.SCREEN_WIDTH - w * sizeOfMap) / 2) | snake.getArrPartSnake().get(0).getX() >= (w * sizeOfMap + (constants.SCREEN_WIDTH - w * sizeOfMap) / 2)
        | snake.getArrPartSnake().get(0).getY() <= ((constants.SCREEN_HEIGHT - (h + 4) * sizeOfMap) / 2) | snake.getArrPartSnake().get(0).getY() >= (h * sizeOfMap + (constants.SCREEN_HEIGHT - (h + 4) * sizeOfMap) / 2)){
            check = true;
        }
        return  check;
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(0xFF1A6100);
        for(int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(),arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
        if(snake.getArrPartSnake().get(0).getrBody().intersect(apple.getR())){
            apple.reset(arrGrass.get(randomApple()[0]).getX(), arrGrass.get(randomApple()[1]).getY());
            snake.addPart();
            this.scoreText.setText("X " + Integer.toString(snake.getLength() - 4));
        }
        if(collapse()){
            stopGame = true;
            button.setVisibility(VISIBLE);
            button.setClickable(true);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    button.setVisibility(INVISIBLE);
                    if((snake.getLength() - 4) >= bestScore){
                        bestScore = (snake.getLength() - 4);
                    }
                    snake = new Snake(bmSnake, arrGrass.get(126).getX(),arrGrass.get(126).getY(), 4);
                    apple = new Apple(bmApple, arrGrass.get(randomApple()[0]).getX(), arrGrass.get(randomApple()[1]).getY());
                    BestScore.setText(Integer.toString(bestScore));
                    stopGame = false;
                }
            });
        }
        if(!this.stopGame){
            snake.update();
            snake.draw(canvas);
            apple.draw(canvas);
        }
        handler.postDelayed(r, 500);
    }
    public int getScore(){
        return (snake.getLength() - 4);
    }
}
