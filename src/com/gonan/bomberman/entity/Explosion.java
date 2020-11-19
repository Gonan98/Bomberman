package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.gonan.bomberman.graphic.Sprite;

public class Explosion extends Sprite {

	private int range;

	private List<Sprite> sideExplosions;
	
	public Explosion(BufferedImage img, float posX, float posY, int rows, int columns, float scale) {
		super(img, posX, posY, rows, columns, scale);
		range = 1;
		frameX = 6;
		frameY = 0;
		frameSpeed = 0.5f;
		hitbox = new Hitbox(x,y,w,h);
		sideExplosions = new ArrayList<>();

		// Norte
		Sprite north = new Sprite(img,x,y-h,rows,columns,scale);
		north.setFrame(0,0);

		sideExplosions.add(north);
		// Sur
		Sprite south = new Sprite(img,x,y+h,rows,columns,scale);
		south.setFrame(1,0);
		sideExplosions.add(south);
		// Este
		Sprite east = new Sprite(img,x+w,y,rows,columns,scale);
		east.setFrame(3,0);
		sideExplosions.add(east);
		// Oeste
		Sprite west = new Sprite(img,x-w,y,rows,columns,scale);
		west.setFrame(2,0);
		sideExplosions.add(west);
	}

	@Override
	public void draw(Graphics2D g2d) {
		update();
		super.draw(g2d);
		for (Sprite sprite : sideExplosions) sprite.draw(g2d);
	}

	public void draw(Graphics2D g2d, int[][] m) {
		update();
		super.draw(g2d);
		for (Sprite sprite : sideExplosions) {
			if (m[(int)(sprite.getY()/48)][(int)(sprite.getX()/48)] != 1) {
				sprite.draw(g2d);
				if (m[(int)(sprite.getY()/48)][(int)(sprite.getX()/48)] == 2) m[(int)(sprite.getY()/48)][(int)(sprite.getX()/48)] = 0;
			}
		}
	}

	public void drawSideExplosion(Graphics2D g2d) {
		for (Sprite sprite : sideExplosions) sprite.draw(g2d);
	}

	private void update() {
        frameY += frameSpeed;
		for (Sprite sprite : sideExplosions) {
			sprite.setFrameY(sprite.getFrameY() + frameSpeed);
		}
	}

	public List<Sprite> getSideExplosions() {
		return sideExplosions;
	}

	public boolean isEnded() {
		return frameY >= 4;
	}

}
