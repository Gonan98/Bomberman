package com.gonan.bomberman.entity;

import com.gonan.bomberman.graphic.Animation;

import java.awt.Graphics2D;

public class DestroyableBlock extends Entity {
	
	public enum DestroyableBlockState { SOLID, BLOWING_UP }
	
	private DestroyableBlockState state;

    public DestroyableBlock(Animation animation, float x, float y) {
    	this.x = x;
    	this.y = y;
        this.animation = animation;
        this.state = DestroyableBlockState.SOLID;
        
        animation.getSpriteSheet().setPosition(x, y);
    }
    
	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		animation.getCurrentSprite().render(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		animation.update();
	}

	public DestroyableBlockState getState() {
		return state;
	}

	public void setState(DestroyableBlockState state) {
		this.state = state;
	}
	
}
