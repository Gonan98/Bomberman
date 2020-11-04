package com.gonan.bomberman.scenario;

import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Tile;

public class Block extends Tile {

	private boolean isIndestructible;
	
	public Block(BufferedImage image, float x, float y, int frameX, int frameY, int rows, int columns, float scale) {
		super(image, x, y, frameX, frameY, rows, columns, scale);
	}

	public boolean isIndestructible() {
		return isIndestructible;
	}

	public void setIndestructible(boolean isIndestructible) {
		this.isIndestructible = isIndestructible;
	}

}
