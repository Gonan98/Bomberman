package com.gonan.bomberman.scenario;

import com.gonan.bomberman.collection.EnemyList;
import com.gonan.bomberman.collection.TileList;
import com.gonan.bomberman.entity.Enemy;
import com.gonan.bomberman.graphic.Tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Map {

	private final int[][] layout;
	private final TileList tileList;
	private final EnemyList enemyList;
	private final Tile ground;
	private final Tile solid;
	private final Tile brick;
	private final int rows;
	private final int columns;
	
	public Map(BufferedImage blocksImg, BufferedImage enemyImg, int rows, int columns, float scale) {

		tileList = new TileList();
		enemyList = new EnemyList(3);

		brick = new Tile(blocksImg, 0,0,1,3, scale);
		solid = new Tile(blocksImg, 1,0,1,3, scale);
		ground = new Tile(blocksImg, 2,0,1,3, scale);

		this.rows = rows;
		this.columns = columns;

		this.layout = new int[rows][columns];

		generateLayout(blocksImg, scale);
		generateBricks(blocksImg, scale);
		generateEnemies(enemyImg, scale);
	}

	private void generateLayout(BufferedImage img, float scale) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || j == 0 || i == rows - 1 || j == columns - 1) || (i > 1 && i % 2 == 0 && j % 2 == 0)) {
					layout[i][j] = 1;
					tileList.add(new Tile(img, j * 48, i * 48, 1,0,1,3, scale));
				} else {
					layout[i][j] = 0;
					tileList.add(new Tile(img, j * 48, i * 48, 2,0,1,3, scale));
				}
			}
		}
	}

	private void generateBricks(BufferedImage img, float scale) {
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			int y = r.nextInt(rows);
			int x = r.nextInt(columns);

			if (layout[y][x] == 0) {
				layout[y][x] = 2;
				tileList.add(new Tile(img, x * 48, y * 48, 0,0,1,3, scale));
			}
		}
	}

	private void generateEnemies(BufferedImage img, float scale) {
		Random r = new Random();
		while (enemyList.getEnemies().size() < enemyList.getCapacity()) {
			int y = r.nextInt(rows);
			int x = r.nextInt(columns);
			if (layout[y][x] == 0) enemyList.add(new Enemy(img, x * 48, y * 48, 1, 13, scale));
		}
	}
	
	public void draw(Graphics2D g2d) {

		//tileList.draw(g2d);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				switch (layout[i][j]) {
					case 0:
						ground.setPosition(j * ground.getW(), i * ground.getH());
						ground.draw(g2d);
						break;
					case 1:
						solid.setPosition(j * ground.getW(), i * ground.getH());
						solid.draw(g2d);
						break;
					case 2:
						brick.setPosition(j * ground.getW(), i * ground.getH());
						brick.draw(g2d);
						break;
					default:
						break;
				}
			}
		}
	}

	public void drawEnemies(Graphics2D g2d) {
		enemyList.draw(g2d);
	}

	public void updateEnemies() {
		enemyList.move(layout);
	}

	public int[][] getLayout() {
		return layout;
	}

	public TileList getTileList() {
		return tileList;
	}

	public void setLayoutObject(float x, float y, int o) {
		layout[(int)(y / 48)][(int)(x / 48)] = o;
	}
}
