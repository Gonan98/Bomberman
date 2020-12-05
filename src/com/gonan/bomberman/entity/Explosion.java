package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;

public class Explosion extends Entity {

    private int radius;

    public Explosion(Animation animation, float x, float y) {
    	this.x = x;
    	this.y = y;
    	this.animation = animation;
        this.radius = 1;
        animation.getSpriteSheet().setPosition(x, y);
    }

    public void generate() {
        
    }

    @Override
    public void render(Graphics2D g) {
        animation.getCurrentSprite().render(g);
    }

    @Override
    public void update() {
        animation.update();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}
