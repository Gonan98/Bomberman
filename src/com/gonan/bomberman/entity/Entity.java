package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.util.Direction;
import com.gonan.bomberman.util.Region;

public abstract class Entity {
	
	protected Direction direction;
	protected Sprite sprite;
	protected Region hitbox;
	protected Animation animation;
	protected float speed;
	
	public abstract void render(Graphics2D g);
	public abstract void update();
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Region getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Region hitbox) {
		this.hitbox = hitbox;
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
