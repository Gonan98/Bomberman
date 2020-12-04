package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.graphic.Animation.AnimationType;
import com.gonan.bomberman.util.Region;

public class Bomb extends Entity {
	
	public enum BombState { ACTIVE, EXPLODING, EXTICNT }
	
	private int timeToExplode;
	private BombState state;
	private Explosion explosion;
	
	public Bomb(Texture bombTexture, Texture explosionTexture, float x, float y) {
		this.explosion = new Explosion(explosionTexture, x, y);
		this.sprite = new Sprite(bombTexture, new Region(0, 0, 16, 16), x, y);
		this.animation = new Animation(16, 16, 1, 3, 0.2f, AnimationType.BOOMERANG);
		this.timeToExplode = 2;
		this.state = BombState.ACTIVE;
	}

	@Override
	public void render(Graphics2D g) {
		if (state == BombState.ACTIVE) {
			sprite.render(g);
		} else {
			explosion.render(g);
		}
	}

	@Override
	public void update() {
		//System.out.println(animation.getjPos());
		if (state == BombState.ACTIVE) {
			animation.update();
			sprite.setRegion(animation.getCurrentRegion());
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
