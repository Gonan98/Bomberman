package com.gonan.bomberman.collection;

import com.gonan.bomberman.entity.Bomb;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BombList {

    private List<Bomb> bombs;
    private int capacity;

    public BombList() {
        this.capacity = 1;
        bombs = new ArrayList<>();
    }

    public void increaseCapacity() {
        capacity++;
    }

    public void add(BufferedImage imgBomb, float posX, float posY, float scale) {
        if (bombs.size() < capacity) {
            bombs.add(new Bomb(imgBomb, posX, posY, 5,7, scale));
        }
    }

    public void draw(Graphics2D g2d) {
        for (Bomb b : bombs) b.draw(g2d);
    }
}
