package com.gonan.bomberman.graphic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Image {
	
	protected final int rows;
	protected final int columns;
	protected float frameX;
	protected float frameY;
	protected final float frameW;
	protected final float frameH;
	protected float frameSpeed;
	protected final BufferedImage[][] frames;
	
	protected float x;
	protected float y;
	protected final float w;
	protected final float h;
	protected float speed;
	
	public Image(BufferedImage img, int rows, int columns, float scale) {
		this.rows = rows;
		this.columns = columns;
		this.frameW = (float)(img.getWidth() / columns);
		this.frameH = (float)(img.getHeight() / rows);
		this.frameSpeed = 0.5f;
		this.w = frameW * scale;
		this.h = frameH * scale;
		
		frames = new BufferedImage[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				frames[i][j] = img.getSubimage(j * (int)frameW, i * (int)frameH, (int)frameW, (int)frameH);
			}
		}
	}
	
	public Image(BufferedImage img, float posX, float posY, int rows, int columns, float scale) {
		this.rows = rows;
		this.columns = columns;
		this.frameW = (float)(img.getWidth() / columns);
		this.frameH = (float)(img.getHeight() / rows);
		this.frameSpeed = 0.5f;
		this.w = frameW * scale;
		this.h = frameH * scale;
		this.x = posX;
		this.y = posY;
		
		frames = new BufferedImage[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				frames[i][j] = img.getSubimage(j * (int)frameW, i * (int)frameH, (int)frameW, (int)frameH);
			}
		}
	}
	
	public Image(BufferedImage img, float posX, float posY, float frameX, float frameY, int rows, int columns, float scale) {
		this.rows = rows;
		this.columns = columns;
		this.frameX = frameX;
		this.frameY = frameY;
		this.frameW = (float)(img.getWidth() / columns);
		this.frameH = (float)(img.getHeight() / rows);
		this.frameSpeed = 0.5f;
		this.w = frameW * scale;
		this.h = frameH * scale;
		this.x = posX;
		this.y = posY;
		
		frames = new BufferedImage[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				frames[i][j] = img.getSubimage(j * (int)frameW, i * (int)frameH, (int)frameW, (int)frameH);
			}
		}
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(frames[(int)frameY][(int)frameX], (int)x, (int)y, (int)w, (int)h, null);
	}
	
	//public void draw(Graphics2D g2d, int[][] m) {
	//	if (m[(int)(y / w)][(int)(x / w)] == 0) {
	//		g2d.drawImage(frames[(int)frameY][(int)frameX], (int)x, (int)y, (int)w, (int)h, null);
	//	}
	//}

	public float getFrameX() {
		return frameX;
	}

	public void setFrameX(float frameX) {
		this.frameX = frameX;
	}

	public float getFrameY() {
		return frameY;
	}

	public void setFrameY(float frameY) {
		this.frameY = frameY;
	}

	public float getFrameSpeed() {
		return frameSpeed;
	}

	public void setFrameSpeed(float frameSpeed) {
		this.frameSpeed = frameSpeed;
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

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public float getFrameW() {
		return frameW;
	}

	public float getFrameH() {
		return frameH;
	}

	public BufferedImage[][] getFrames() {
		return frames;
	}

	public float getW() {
		return w;
	}

	public float getH() {
		return h;
	}
}
