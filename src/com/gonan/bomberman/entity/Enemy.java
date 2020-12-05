package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;

public class Enemy extends Entity {

    public enum Size { MEDIUM, LITTLE }
    
    public Enemy(Animation animation, float x, float y) {
    	this.x = x;
    	this.y = y;
        this.animation = animation;
        this.animation.getCurrentSprite().setPosition(x, y);
    }

    @Override
    public void render(Graphics2D g) {
    	animation.getCurrentSprite().render(g);
    }

    @Override
    public void update() {
        animation.update();
        animation.getCurrentSprite().setPosition(x, y);
    }

}
