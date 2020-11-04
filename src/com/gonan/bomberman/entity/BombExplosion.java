package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class BombExplosion extends Explosion {
	
	private LinkedList<Explosion> northExplosions;
	private LinkedList<Explosion> southExplosions;
	private LinkedList<Explosion> eastExplosions;
	private LinkedList<Explosion> westExplosions;
	private int range;
	
	public BombExplosion(BufferedImage img, 
			float posX, 
			float posY, 
			float frameX, 
			float frameY, 
			int rows, 
			int columns,
			float scale) {
		
		super(img, posX, posY, frameX, frameY, rows, columns, scale);
		this.range = 4;
		northExplosions = new LinkedList<>();
		southExplosions = new LinkedList<>();
		eastExplosions = new LinkedList<>();
		westExplosions = new LinkedList<>();
		
		if (range > 1) {
			for (int i = 0; i < range - 1; i++) {
				northExplosions.add(new Explosion(img, x, y - h * (i + 1), 4, 0, 5, 7, scale));
				southExplosions.add(new Explosion(img, x, y + h * (i + 1), 4, 0, 5, 7, scale));
				eastExplosions.add(new Explosion(img, x + w * (i + 1), y, 5, 0, 5, 7, scale));
				westExplosions.add(new Explosion(img, x - w * (i + 1), y, 5, 0, 5, 7, scale));
			}
			northExplosions.add(new Explosion(img, x, northExplosions.getLast().getY() - h, 0, 0, 5, 7, scale));
			southExplosions.add(new Explosion(img, x, southExplosions.getLast().getY() + h, 1, 0, 5, 7, scale));
			eastExplosions.add(new Explosion(img, eastExplosions.getLast().getX() + w, y, 3, 0, 5, 7, scale));
			westExplosions.add(new Explosion(img, westExplosions.getLast().getX() - w, y, 2, 0, 5, 7, scale));
		} else {
			northExplosions.add(new Explosion(img, x, y - h, 0, 0, 5, 7, scale));
			southExplosions.add(new Explosion(img, x, y + h, 1, 0, 5, 7, scale));
			eastExplosions.add(new Explosion(img, x + w, y, 3, 0, 5, 7, scale));
			westExplosions.add(new Explosion(img, x - w, y, 2, 0, 5, 7, scale));
		}
		
	}
	
	
	public void draw(Graphics2D g2d, int[][] m) {
		super.draw(g2d);
		for (Explosion e : northExplosions) {
			if (m[(int)(e.getY() / w)][(int)(e.getX() / w)] == 1) break;
			e.draw(g2d);
		}
		for (Explosion e : southExplosions) {
			if (m[(int)(e.getY() / w)][(int)(e.getX() / w)] == 1) break;
			e.draw(g2d);
		}
		for (Explosion e : eastExplosions) {
			if (m[(int)(e.getY() / w)][(int)(e.getX() / w)] == 1) break;
			e.draw(g2d);
		}
		for (Explosion e : westExplosions) {
			if (m[(int)(e.getY() / w)][(int)(e.getX() / w)] == 1) break;
			e.draw(g2d);
		}
	}

}
