package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.util.Direction;
import com.gonan.bomberman.util.Hitbox;

public abstract class Entity {
	
	protected Direction direction;
	protected Hitbox hitbox;
	protected Animation animation;
	protected float x;
	protected float y;
	protected float speed;
	
	public abstract void render(Graphics2D g);
	public abstract void update();
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
}
