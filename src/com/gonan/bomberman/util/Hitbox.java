package com.gonan.bomberman.util;

import java.awt.Graphics2D;

public class Hitbox {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Hitbox(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean collide(Hitbox b) {
		return (this.x < b.x + b.width &&
				this.x + this.width > b.x &&
				this.y < b.y + b.height &&
				this.y + this.height > b.y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
