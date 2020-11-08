package com.gonan.bomberman.scenario;

import com.gonan.bomberman.graphic.Tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

	private int[][] layout;
	private Tile ground;
	private Tile solid;
	private Tile brick;
	private final int rows;
	private final int columns;
	
	public Map(BufferedImage img, int rows, int columns, float scale) {

		brick = new Tile(img, 0,0,1,3, scale);
		solid = new Tile(img, 1,0,1,3, scale);
		ground = new Tile(img, 2,0,1,3, scale);

		this.rows = rows;
		this.columns = columns;

		this.layout = new int[rows][columns];

		generateLayout();
		generateBricks();
		
	}

	private void generateLayout() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || j == 0 || i == rows - 1 || j == columns - 1) || (i > 1 && i % 2 == 0 && j % 2 == 0)) {
					layout[i][j] = 1;
				} else {
					layout[i][j] = 0;
				}
			}
		}
	}

	private void generateBricks() {
		Random r = new Random();

		for (int i = 0; i < 200; i++) {
			int y = r.nextInt(rows);
			int x = r.nextInt(columns);

			if (layout[y][x] == 0) layout[y][x] = 2;
		}
	}
	
	public void draw(Graphics2D g2d) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				switch (layout[i][j]) {
					case 0:
						ground.setX(solid.getW() * j);
						ground.setY(solid.getH() * i);
						ground.draw(g2d);
						break;
					case 1:
						solid.setX(solid.getW() * j);
						solid.setY(solid.getH() * i);
						solid.draw(g2d);
						break;
					case 2:
						brick.setX(solid.getW() * j);
						brick.setY(solid.getH() * i);
						brick.draw(g2d);
						break;
					default:
						break;
				}
			}
		}

	}

	public int[][] getLayout() {
		return layout;
	}

}
