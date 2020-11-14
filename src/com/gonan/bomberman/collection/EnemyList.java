package com.gonan.bomberman.collection;

import com.gonan.bomberman.entity.Enemy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemyList {

    private List<Enemy> enemies;
    private int capacity;

    public EnemyList(int capacity) {
        this.capacity = capacity;
        enemies = new ArrayList<>();
    }

    public void add(Enemy e) {
        if (enemies.size() < capacity) {
            enemies.add(e);
        }
    }

    public void remove(Enemy e) {
        enemies.remove(e);
    }

    public void draw(Graphics2D g2d) {
        for (var enemy : enemies) enemy.draw(g2d);
    }

    public void move(int[][] m) {
        for (var enemy : enemies) enemy.move(m);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getCapacity() {
        return capacity;
    }
}
