package com.gonan.bomberman.scenario;

import java.awt.Graphics2D;

import com.gonan.bomberman.graphic.Sprite;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.scenario.collection.BlockList;
import com.gonan.bomberman.util.GameConfig;
import com.gonan.bomberman.util.Hitbox;

public class Level {

    private Sprite sprite;
    private BlockList blockList;
    private Hitbox[] borders;
    public static final int ROWS = 17;
    public static final int COLUMNS = 15;
    
    public Level(Texture texture) {
    	this.sprite = new Sprite(texture);
    	this.blockList = new BlockList();
    	this.borders = new Hitbox[4];
    	
    	// Borde de arriba
    	borders[0] = new Hitbox(0,0,(int)(sprite.getW()),(int)(16*GameConfig.scale));
    	
    	// Borde de abajo
    	borders[1] = new Hitbox(0,(int)(sprite.getH() - 16*GameConfig.scale),(int)(sprite.getW()),(int)(16*GameConfig.scale));
    	
    	// Borde de la derehca
    	borders[2] = new Hitbox((int)(sprite.getW() - 16*GameConfig.scale), 0, (int)(16 * GameConfig.scale), (int)(sprite.getH()));
    	
    	// Borde de la izquierda
    	borders[3] = new Hitbox(0, 0, (int)(16 * GameConfig.scale), (int)(sprite.getH()));
    }
    
    public void renderBackground(Graphics2D g) {
    	sprite.render(g);
    	//for (Hitbox h : borders) h.render(g);
    	//for (Hitbox h : regions) h.render(g);
    }
    
    public void renderBlocks(Graphics2D g) {
    	blockList.render(g);
    }

}
