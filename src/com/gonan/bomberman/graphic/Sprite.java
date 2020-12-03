package com.gonan.bomberman.graphic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gonan.bomberman.util.GameConfig;
import com.gonan.bomberman.util.Region;

public class Sprite {
	
	private float x;
	private float y;
	private float w;
	private float h;
	private Texture texture;
	private Region region;
	
	public Sprite(Texture texture, float x, float y) {
		this.texture = texture;
		this.region = new Region(0, 0, texture.getWidth(), texture.getHeight());
		this.x = x;
		this.y = y;
		this.w = region.getWidth() * GameConfig.scale;
		this.h = region.getHeight() * GameConfig.scale;
	}
	
	public Sprite(Texture texture, Region region, float x, float y) {
		this.texture = texture;
		this.region = region;
		this.x = x;
		this.y = y;
		this.w = region.getWidth() * GameConfig.scale;
		this.h = region.getHeight() * GameConfig.scale;
	}
	
	public BufferedImage getCurrentImage() {
		return texture.getImage().getSubimage(region.getX(), region.getY(), region.getWidth(), region.getHeight());
	}
	
	public void move(float xOffSet, float yOffSet) {
		this.x += xOffSet;
		this.y += yOffSet;
	}
	
	public void render(Graphics2D g) {
		g.drawImage(getCurrentImage(), (int)x, (int)y, (int)w, (int)h, null);
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region drawRegion) {
		this.region = drawRegion;
	}

}
