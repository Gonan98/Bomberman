package com.gonan.bomberman.scenario;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;

import java.awt.Graphics2D;

public class Block {

    public enum BlockType { NON_DESTROYABLE, DESTROYABLE, GROUND }
    
    private Sprite sprite;
    private BlockType type;
    private Animation animation;

    public Block(Texture texture, BlockType type, float x, float y) {
        this.sprite = new Sprite(texture, x, y);
        this.animation = new Animation(16, 16, 1, 1, 0.3f);
        this.type = type;
    }

    public void render(Graphics2D g) {
        sprite.render(g);
    }

    public void update() {
        animation.update();
        if (animation.isLastFrame()) animation.restart();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
