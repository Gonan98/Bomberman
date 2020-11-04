package com.gonan.bomberman.scenario;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Map {
	
	private List<Block> blocks;
	private int[][] layout;
	
	public Map(BufferedImage img, int rows, int columns, float scale) {
		
		this.blocks = new ArrayList<>();
		
		this.layout = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || j == 0 || i == rows - 1 || j == columns - 1) || (i > 1 && i % 2 == 0 && j % 2 == 0)) {
					layout[i][j] = 1;
					blocks.add(new Block(img,j*48,i*48,1,0,1,3,scale));
				} else {
					layout[i][j] = 0;
					blocks.add(new Block(img,j*48,i*48,2,0,1,3,scale));
				}
			}
		}
		
	}
	
	public void draw(Graphics2D g2d) {
		for (Block block : blocks) {
			block.draw(g2d);
		}
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public int[][] getLayout() {
		return layout;
	}

}
