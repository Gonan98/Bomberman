package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BombExplosion extends Explosion {
	
	private List<Explosion> explosions;
	
	public BombExplosion(BufferedImage img, 
			float posX, 
			float posY, 
			float frameX, 
			float frameY, 
			int rows, 
			int columns,
			float scale) {
		
		super(img, posX, posY, frameX, frameY, rows, columns, scale);
		explosions = new ArrayList<>();
		explosions.add(new Explosion(img, x, y - h, 0, 0, 5, 7, scale));
		explosions.add(new Explosion(img, x, y + h, 1, 0, 5, 7, scale));
		explosions.add(new Explosion(img, x + w, y, 3, 0, 5, 7, scale));
		explosions.add(new Explosion(img, x - w, y, 2, 0, 5, 7, scale));
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		for (Explosion e : explosions) e.draw(g2d);
	}

}
