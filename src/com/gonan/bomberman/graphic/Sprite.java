package com.gonan.bomberman.graphic;

import java.awt.Graphics2D;

import com.gonan.bomberman.util.GameConfig;

public class Sprite {
	
	private float x;
	private float y;
	private float w;
	private float h;
	private Texture texture;
	
	public Sprite(Texture texture) {
		this.texture = texture;
		this.x = 0;
		this.y = 0;
		this.w = texture.getWidth() * GameConfig.scale;
		this.h = texture.getHeight() * GameConfig.scale;
	}
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//public void move(float xOffSet, float yOffSet) {
	//	this.x += xOffSet;
	//	this.y += yOffSet;
	//}
	
	public void render(Graphics2D g) {
		g.drawImage(texture.getImage(), (int)x, (int)y, (int)w, (int)h, null);
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

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
