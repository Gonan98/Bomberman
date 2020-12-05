package com.gonan.bomberman.scenario;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.scenario.collection.BlockList;

public class Level {

    private Sprite sprite;
    //private Region[][] regions;
    //private Region[] borders;
    private BlockList blockList;
    public static final int ROWS = 17;
    public static final int COLUMNS = 15;
    
    public Level(Texture texture) {
    	this.sprite = new Sprite(texture);
    	//this.regions = new Region[ROWS][COLUMNS];
    	//this.borders = new Region[4];
    }
    
    public void renderBackground(Graphics2D g) {
    	sprite.render(g);
    }
    
    public void renderBlocks(Graphics2D g) {
    	blockList.render(g);
    }

}
