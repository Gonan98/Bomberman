package com.gonan.bomberman.graphic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite {
	
	protected final int rows;
	protected final int columns;
	protected float frameX;
	protected float frameY;
	protected final float frameW;
	protected final float frameH;
	protected float frameSpeed;
	protected final BufferedImage texture;
	
	protected float x;
	protected float y;
	protected final float w;
	protected final float h;
	protected float speed;

	public Sprite(BufferedImage texture, float posX, float posY, int rows, int columns, float scale) {
		this.texture = texture;
		this.rows = rows;
		this.columns = columns;
		this.frameW = (float)(texture.getWidth() / columns);
		this.frameH = (float)(texture.getHeight() / rows);

		this.x = posX;
		this.y = posY;
		this.w = frameW * scale;
		this.h = frameH * scale;
	}

	private BufferedImage currentFrame() {
		return texture.getSubimage((int)frameX * (int)frameW,(int)frameY * (int)frameH,(int)frameW,(int)frameH);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(currentFrame(), (int)x, (int)y, (int)w, (int)h, null);
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

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

	public void setFrame(float frameX, float frameY) {
		this.frameX = frameX;
		this.frameY = frameY;
	}

	public float getFrameW() {
		return frameW;
	}

	public float getFrameH() {
		return frameH;
	}

	public float getFrameSpeed() {
		return frameSpeed;
	}

	public void setFrameSpeed(float frameSpeed) {
		this.frameSpeed = frameSpeed;
	}

	public BufferedImage getTexture() {
		return texture;
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

	public float getW() {
		return w;
	}

	public float getH() {
		return h;
	}
}
