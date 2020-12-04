package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Animation.AnimationType;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.util.Region;

public class Explosion extends Entity {

    private int radius;

    public Explosion(Texture texture, float x, float y) {
        this.sprite = new Sprite(texture, new Region(0, 0, 16, 16), x, y);
        this.animation = new Animation(16, 16, 1, 5, 0.5f, AnimationType.NON_REPEAT);
        this.radius = 1;
    }

    public void generate() {
        
    }

    @Override
    public void render(Graphics2D g) {
        sprite.render(g);
    }

    @Override
    public void update() {
        animation.update();
        sprite.setRegion(animation.getCurrentRegion());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}
