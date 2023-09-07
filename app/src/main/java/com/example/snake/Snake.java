package com.example.snake;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Snake {
    private Bitmap bm, bm_head_up, bm_head_down, bm_head_left, bm_head_right,
            bm_body_vertical, bm_body_horizontal, bm_body_top_right, bm_body_top_left,
            bm_body_bottom_right, bm_body_bottom_left, bm_tail_up, bm_tail_down,
            bm_tail_right, bm_tail_left;
     private int x, y, length;
     private ArrayList<PartSnake> arrPartSnake = new ArrayList<>();
    public Snake(Bitmap bm, int x, int y, int length) {
        this.bm = bm;
        this.x = x;
        this.y = y;
        this.length = length;

    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

    public Bitmap getBm_head_up() {
        return bm_head_up;
    }

    public void setBm_head_up(Bitmap bm_head_up) {
        this.bm_head_up = bm_head_up;
    }

    public Bitmap getBm_head_down() {
        return bm_head_down;
    }

    public void setBm_head_down(Bitmap bm_head_down) {
        this.bm_head_down = bm_head_down;
    }

    public Bitmap getBm_head_left() {
        return bm_head_left;
    }

    public void setBm_head_left(Bitmap bm_head_left) {
        this.bm_head_left = bm_head_left;
    }

    public Bitmap getBm_head_right() {
        return bm_head_right;
    }

    public void setBm_head_right(Bitmap bm_head_right) {
        this.bm_head_right = bm_head_right;
    }

    public Bitmap getBm_body_vertical() {
        return bm_body_vertical;
    }

    public void setBm_body_vertical(Bitmap bm_body_vertical) {
        this.bm_body_vertical = bm_body_vertical;
    }

    public Bitmap getBm_body_horizontal() {
        return bm_body_horizontal;
    }

    public void setBm_body_horizontal(Bitmap bm_body_horizontal) {
        this.bm_body_horizontal = bm_body_horizontal;
    }

    public Bitmap getBm_body_top_right() {
        return bm_body_top_right;
    }

    public void setBm_body_top_right(Bitmap bm_body_top_right) {
        this.bm_body_top_right = bm_body_top_right;
    }

    public Bitmap getBm_body_top_left() {
        return bm_body_top_left;
    }

    public void setBm_body_top_left(Bitmap bm_body_top_left) {
        this.bm_body_top_left = bm_body_top_left;
    }

    public Bitmap getBm_body_bottom_right() {
        return bm_body_bottom_right;
    }

    public void setBm_body_bottom_right(Bitmap bm_body_bottom_right) {
        this.bm_body_bottom_right = bm_body_bottom_right;
    }

    public Bitmap getBm_body_bottom_left() {
        return bm_body_bottom_left;
    }

    public void setBm_body_bottom_left(Bitmap bm_body_bottom_left) {
        this.bm_body_bottom_left = bm_body_bottom_left;
    }

    public Bitmap getBm_tail_up() {
        return bm_tail_up;
    }

    public void setBm_tail_up(Bitmap bm_tail_up) {
        this.bm_tail_up = bm_tail_up;
    }

    public Bitmap getBm_tail_down() {
        return bm_tail_down;
    }

    public void setBm_tail_down(Bitmap bm_tail_down) {
        this.bm_tail_down = bm_tail_down;
    }

    public Bitmap getBm_tail_right() {
        return bm_tail_right;
    }

    public void setBm_tail_right(Bitmap bm_tail_right) {
        this.bm_tail_right = bm_tail_right;
    }

    public Bitmap getBm_tail_left() {
        return bm_tail_left;
    }

    public void setBm_tail_left(Bitmap bm_tail_left) {
        this.bm_tail_left = bm_tail_left;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<PartSnake> getArrPartSnake() {
        return arrPartSnake;
    }

    public void setArrPartSnake(ArrayList<PartSnake> arrPartSnake) {
        this.arrPartSnake = arrPartSnake;
    }
}
