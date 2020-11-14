package com.gonan.bomberman.collection;

import com.gonan.bomberman.entity.Bomb;

import java.awt.*;
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

    public void add(Bomb b) {
        if (bombs.size() < capacity) {
            bombs.add(b);
        }
    }

    public void remove(Bomb b) {
        bombs.remove(b);
    }

    public void draw(Graphics2D g2d) {
        for (Bomb b : bombs) b.draw(g2d);
    }

    public List<Bomb> getBombs() {
        return bombs;
    }
}
