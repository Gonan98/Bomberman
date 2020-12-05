package com.gonan.bomberman.graphic;

public class SpriteSheet {
	
	private Sprite[][] sprites;
	private int rows;
	private int columns;
	
	public SpriteSheet(Texture texture, int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.sprites = new Sprite[rows][columns];
		
		int frameWidth = texture.getWidth() / columns;
		int frameHeight = texture.getHeight() / rows;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sprites[i][j] = new Sprite(new Texture(texture.getFilename(), j * frameWidth, i * frameHeight, frameWidth, frameHeight));
			}
		}
		
	}
	
	public void setPosition(float x, float y) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sprites[i][j].setPosition(x, y);
			}
		}
	}

	public Sprite[][] getSprites() {
		return sprites;
	}

	public void setSprites(Sprite[][] sprites) {
		this.sprites = sprites;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

}
