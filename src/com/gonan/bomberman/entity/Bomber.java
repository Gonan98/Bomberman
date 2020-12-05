package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.entity.collection.BombList;
import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.graphic.Animation.AnimationType;
import com.gonan.bomberman.util.Direction;

public class Bomber extends Entity {
	
	public enum State { STILL, MOVING }
	
	private State state;
	private BombList bombList;
	private Texture bombTexture;
	private Texture explosionTexture;
	
	public Bomber(Animation playerAnimation, Texture bombTexture, Texture explosionTexture, float x, float y) {
		this.x = x;
		this.y = y;
		this.animation = playerAnimation;
		this.bombTexture = bombTexture;
		this.explosionTexture = explosionTexture;
		this.direction = Direction.DOWN;
		this.state = State.STILL;
		this.speed = 6f;
		this.bombList = new BombList();
		this.animation.setCurrentSprite(1, 1);
	}

	public void putBomb() {
		Animation bombAnimation = new Animation(bombTexture, 1, 3, 0.15f, AnimationType.BOOMERANG);
		Animation explosionAnimation = new Animation(explosionTexture, 1, 5, 0.5f, AnimationType.NON_REPEAT);
		bombList.add(new Bomb(bombAnimation, explosionAnimation, animation.getCurrentSprite().getX(), animation.getCurrentSprite().getY() + animation.getCurrentSprite().getH() / 3));
	}

	@Override
	public void render(Graphics2D g) {
		animation.getCurrentSprite().render(g);
		bombList.render(g);
	}

	@Override
	public void update() {

		bombList.update();
		
		if (state == State.MOVING) {
			switch(direction) {
			case UP:
				y -= speed;
				animation.setiPos(0);
				break;
				
			case DOWN:
				y += speed;
				animation.setiPos(1);
				break;
				
			case RIGHT:
				x += speed;
				animation.setiPos(2);
				break;
				
			case LEFT:
				x -= speed;
				animation.setiPos(3);
				break;
			}
			animation.update();
		} else {
			animation.setjPos(1);
		}
		
		animation.getCurrentSprite().setPosition(x, y);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
