package com.gonan.bomberman.scenario;

import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Image;

public class TileMap extends Image {
	
	private boolean isIndestructible;
	
	public TileMap(BufferedImage img, float posX, float posY, float frameX, float frameY, int rows, int columns,
			float scale) {
		super(img, posX, posY, frameX, frameY, rows, columns, scale);
	}

	public boolean isIndestructible() {
		return isIndestructible;
	}

	public void setIndestructible(boolean isIndestructible) {
		this.isIndestructible = isIndestructible;
	}

}
