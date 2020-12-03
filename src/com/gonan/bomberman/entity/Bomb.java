package com.gonan.bomberman.entity;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.util.Region;

public class Bomb extends Entity {
	
	public enum BombState { ACTIVE, EXPLODING, EXTICNT }
	
	private int timeToExplode;
	private BombState state;
	
	public Bomb(Texture texture, float x, float y) {
		this.sprite = new Sprite(texture, new Region(0, 0, 16, 16), x, y);
		this.animation = new Animation(16, 16, 1, 3, 0.1f);
		this.timeToExplode = 3;
		this.state = BombState.ACTIVE;
	}

	@Override
	public void render(Graphics2D g) {
		sprite.render(g);
	}

	@Override
	public void update() {
		animation.update();
		sprite.setRegion(animation.getCurrentRegion());
		if (animation.getjPos() == 0) {
			timeToExplode--;
		}
		// if (timeToExplode == 0) state = BombState.EXPLODING;
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
