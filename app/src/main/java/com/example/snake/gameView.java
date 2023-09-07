package com.example.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class gameView extends View {
    private Bitmap bmGrass1, bmGrass2;
    public static int sizeOfMap = 75 * constants.SCREEN_WIDTH / 1080;
    private int h = 21, w = 12;
    public ArrayList<Grass> arrGrass = new ArrayList<>();
     public gameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
         bmGrass1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
         bmGrass1 = Bitmap.createScaledBitmap(bmGrass1, sizeOfMap, sizeOfMap, false);

         bmGrass2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass03);
         bmGrass2 = Bitmap.createScaledBitmap(bmGrass2, sizeOfMap, sizeOfMap, false);

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
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(0xFF1A6100);
        for(int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(),arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
    }
}