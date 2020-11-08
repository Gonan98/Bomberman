package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Sprite;

public class Bomb extends Sprite {

	public enum State { ACTIVATED, EXPLODE }
	
	private int detonateTime = 3;
	
	private State state;
	
	public Bomb(BufferedImage img, float posX, float posY, int rows, int columns, float scale) {
		super(img, posX, posY, rows, columns, scale);
		frameX = 0;
		frameY = 0;
		frameSpeed = 0.2f;
		state = State.ACTIVATED;
	}

	@Override
	public void draw(Graphics2D g2d) {
		update();
		super.draw(g2d);
	}
	
	private void update() {
        frameX += frameSpeed;
        if (frameX >= 4) {
            frameX = 0;
            detonateTime--;
            if (detonateTime == 0) detonate();
        }
	}
	
	public void detonate() {
		state = State.EXPLODE;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
