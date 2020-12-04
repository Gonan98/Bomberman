package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;

public class Enemy extends Entity {

    public enum Size { MEDIUM, LITTLE }
    
    public Enemy(Texture texture, Animation animation, float x, float y) {
        this.sprite = new Sprite(texture, x, y);
        this.animation = animation;
        sprite.setRegion(animation.getCurrentRegion());
    }

    @Override
    public void render(Graphics2D g) {
        sprite.render(g);
    }

    @Override
    public void update() {
        animation.update();
        if (animation.isLastFrame()) animation.restart();
        sprite.setRegion(animation.getCurrentRegion());
    }

}
