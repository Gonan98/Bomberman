package com.gonan.bomberman.collection;

import com.gonan.bomberman.entity.Explosion;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExplosionList {

    private List<Explosion> explosions;

    public ExplosionList() {
        explosions = new ArrayList<>();
    }

    public void add(Explosion e) {
        explosions.add(e);
    }

    public void draw(Graphics2D g2d, int[][] m) {
        for (Explosion e : explosions) e.draw(g2d, m);
    }

    public List<Explosion> getExplosions() {
        return explosions;
    }

    public void removeIfExplosionEnded() {
        explosions.removeIf(Explosion::isEnded);
    }
}
