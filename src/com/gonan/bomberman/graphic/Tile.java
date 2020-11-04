package com.gonan.bomberman.graphic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	
	private final BufferedImage image;
	private float x;
	private float y;
	private final float w;
	private final float h;
	
	public Tile(BufferedImage image, float x, float y, int frameX, int frameY, int rows, int columns, float scale) {
		this.image = image.getSubimage(frameX * image.getWidth() / columns, frameY * image.getHeight() / rows, image.getWidth() / columns, image.getHeight() / rows);
		this.x = x;
		this.y = y;
		this.w = image.getWidth() / columns * scale;
		this.h = image.getHeight() / rows * scale;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, (int)x, (int)y, (int)w, (int)h, null);
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

	public BufferedImage getImage() {
		return image;
	}

	public float getW() {
		return w;
	}

	public float getH() {
		return h;
	}

}
