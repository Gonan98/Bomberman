package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;

public class Bomb extends Entity {
	
	public enum BombState { ACTIVE, EXPLODING, EXTICNT }
	
	private int timeToExplode;
	private BombState state;
	private Explosion explosion;
	
	public Bomb(Animation animation, Animation explosionAnimation, float x, float y) {
		this.x = x;
		this.y = y;
		this.animation = animation;
		this.explosion = new Explosion(explosionAnimation, x, y);
		this.timeToExplode = 2;
		this.state = BombState.ACTIVE;
	}

	@Override
	public void render(Graphics2D g) {
		if (state == BombState.ACTIVE) {
			animation.getCurrentSprite().render(g);
		} else {
			explosion.render(g);
		}
	}

	@Override
	public void update() {
		if (state == BombState.ACTIVE) {
			animation.update();
			animation.getCurrentSprite().setPosition(x,y);
			if (animation.getjPos() == 0) {
				timeToExplode--;
				if (timeToExplode == 0) state = BombState.EXPLODING;
			}
		} else {
			explosion.update();
			if (explosion.getAnimation().isStopped()) state = BombState.EXTICNT;
		}
	}

	public BombState getState() {
		return state;
	}

	public void setState(BombState state) {
		this.state = state;
	}

	public int getTimeToExplode() {
		return timeToExplode;
	}

	public void setTimeToExplode(int timeToExplode) {
		this.timeToExplode = timeToExplode;
	}
}
