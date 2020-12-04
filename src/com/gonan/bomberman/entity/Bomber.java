package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.entity.collection.BombList;
import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Animation.AnimationType;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.util.Direction;
import com.gonan.bomberman.util.Region;

public class Bomber extends Entity {
	
	public enum State { STILL, MOVING }
	
	private State state;
	private BombList bombList;
	private Texture bombTexture;
	private Texture explosionTexture;
	
	public Bomber(Texture playeTexture, Texture bombTexture, Texture explosionTexture, float x, float y) {
		this.bombTexture = bombTexture;
		this.explosionTexture = explosionTexture;
		this.sprite = new Sprite(playeTexture, new Region(16,24,16,24), x, y);
		this.animation = new Animation(16, 24, 4, 3, 0.3f, AnimationType.BOOMERANG);
		this.animation.setCurrentRegion(1, 1);
		this.direction = Direction.DOWN;
		this.state = State.STILL;
		this.speed = 6f;
		bombList = new BombList();
	}

	public void putBomb() {
		bombList.add(new Bomb(bombTexture, explosionTexture, sprite.getX(), sprite.getY() + sprite.getH() / 3));
	}

	@Override
	public void render(Graphics2D g) {
		sprite.render(g);
		bombList.render(g);
	}

	@Override
	public void update() {

		bombList.update();
		
		if (state == State.MOVING) {
			switch(direction) {
			case UP:
				sprite.move(0, -speed);
				animation.setiPos(0);
				break;
				
			case DOWN:
				sprite.move(0, speed);
				animation.setiPos(1);
				break;
				
			case RIGHT:
				sprite.move(speed, 0);
				animation.setiPos(2);
				break;
				
			case LEFT:
				sprite.move(-speed, 0);
				animation.setiPos(3);
				break;
			}
			animation.update();
		} else {
			animation.setjPos(1);
		}

		sprite.setRegion(animation.getCurrentRegion());
	
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
