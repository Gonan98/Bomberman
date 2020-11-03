package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Image;

public class Explosion extends Image {	
	
	public Explosion(BufferedImage img, 
			float posX, 
			float posY, 
			float frameX, 
			float frameY, 
			int rows, 
			int columns,
			float scale) {
		super(img, posX, posY, frameX, frameY, rows, columns, scale);
		frameSpeed = 0.8f;
	}

	@Override
	public void draw(Graphics2D g2d) {
		update();
		super.draw(g2d);
	}
	
	private void update() {
        frameY += frameSpeed;
	}
	
	public boolean isEnded() {
		return frameY >= 4;
	}

}
