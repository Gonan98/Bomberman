package com.gonan.bomberman.entity.collection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.gonan.bomberman.entity.Bomb;
import com.gonan.bomberman.entity.Bomb.BombState;

public class BombList {
    
    private List<Bomb> bombs;
    private int limit;

    public BombList() {
        this.bombs = new ArrayList<>();
        this.limit = 1;
    }

    public void add(Bomb b) {
        if (bombs.size() < limit) {
            bombs.add(b);
        }
    }

    public void render(Graphics2D g) {
        for (Bomb b : bombs) b.render(g);
    }

    public void update() {
        for (Bomb b : bombs) {
            b.update();
            if (b.getState() == BombState.EXTICNT) {
                bombs.remove(b);
                break;
            }
        }
    }
}
