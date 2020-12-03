package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.util.Direction;
import com.gonan.bomberman.util.Region;

public class Bomber extends Entity {
	
	public enum State { STILL, MOVING }
	
	private State state;
	
	public Bomber(Texture texture, float x, float y) {
		this.sprite = new Sprite(texture, new Region(16,24,16,24));
		this.animation = new Animation(16, 24, 4, 3, 0.2f);
		this.direction = Direction.DOWN;
		this.state = State.STILL;
		this.speed = 8f;
	}

	@Override
	public void render(Graphics2D g) {
		sprite.render(g);
	}

	@Override
	public void update() {
		
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
		
		if (sprite.getRegion() != animation.getCurrentRegion()) {
			sprite.setRegion(animation.getCurrentRegion());
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
