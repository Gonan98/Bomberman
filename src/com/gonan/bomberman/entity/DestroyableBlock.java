package com.gonan.bomberman.entity;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.util.Region;
import com.gonan.bomberman.graphic.Animation.AnimationType;

import java.awt.Graphics2D;

public class DestroyableBlock extends Entity {
	
	public enum DestroyableBlockState { SOLID, BLOWING_UP }
	
	private DestroyableBlockState state;

    public DestroyableBlock(Texture texture, float x, float y) {
        this.sprite = new Sprite(texture, new Region(0, 0, 16, 16), x, y);
        this.animation = new Animation(16, 16, 1, 4, 0.3f, AnimationType.REPEAT);
        this.state = DestroyableBlockState.SOLID;
    }
    
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		sprite.render(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		animation.update();
		sprite.setRegion(animation.getCurrentRegion());
	}
    
    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

	public DestroyableBlockState getState() {
		return state;
	}

	public void setState(DestroyableBlockState state) {
		this.state = state;
	}
	
}
