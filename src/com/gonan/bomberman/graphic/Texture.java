package com.gonan.bomberman.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	private BufferedImage image;
	private String filename;
	private int width;
	private int height;
	
	public Texture(String filename) {
		try {
			this.filename = filename;
			this.image = ImageIO.read(new File(filename));
			this.width = image.getWidth();
			this.height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public Texture(String filename, int x, int y, int width, int height) {
		try {
			this.filename = filename;
			this.image = ImageIO.read(new File(filename)).getSubimage(x, y, width, height);
			this.width = image.getWidth();
			this.height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String getFilename() {
		return filename;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
}
