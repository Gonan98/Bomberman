package com.gonan.bomberman.graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	private BufferedImage image;
	private int width;
	private int height;
	
	public Texture(String filename) {
		try {
			this.image = ImageIO.read(new File(filename));
			this.width = image.getWidth();
			this.height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
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
