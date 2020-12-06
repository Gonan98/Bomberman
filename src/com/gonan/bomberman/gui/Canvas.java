package com.gonan.bomberman.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.gonan.bomberman.entity.Bomber;
import com.gonan.bomberman.entity.DestroyableBlock;
import com.gonan.bomberman.entity.Enemy;
import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.graphic.Animation.AnimationType;
import com.gonan.bomberman.input.MyKeyAdapter;
import com.gonan.bomberman.scenario.Level;
import com.gonan.bomberman.util.GameConfig;

public class Canvas extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Texture playerTexture;
	private Texture bombTexture;
	private Texture explosionTexture;
	private Texture enemyTexture;
	private Texture enemyTexture2;
	private Texture firstLevelTexture;
	private Texture blockTexture;
	
	private Animation playerAnimation;
	private Animation enemyAnimation;
	private Animation enemy2Animation;
	private Animation blockAnimation;
	
	private Enemy enemy;
	private Enemy enemy2;
	private Bomber player;
	private Level level;
	private DestroyableBlock block;
	
	private MyKeyAdapter myKeyAdapter;
	private Timer timer;

	public Canvas(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		this.setBackground(Color.DARK_GRAY);
		
		this.playerTexture = new Texture("res/bomberman_spritesheet.png");
		this.enemyTexture = new Texture("res/enemy1.png");
		this.enemyTexture2 = new Texture("res/enemy2.png");
		this.bombTexture = new Texture("res/bomberman_bomb.png");
		this.explosionTexture = new Texture("res/central_explosion.png");
		this.firstLevelTexture = new Texture("res/stage1.png"); 
		this.blockTexture = new Texture("res/stage1_destroyable_block.png");
		
		this.playerAnimation = new Animation(playerTexture, 4, 3, 0.2f, AnimationType.BOOMERANG);
		this.enemyAnimation = new Animation(enemyTexture, 4, 4, 0.5f, AnimationType.REPEAT);
		this.enemy2Animation = new Animation(enemyTexture2, 1, 6, 0.3f, AnimationType.BOOMERANG);
		this.blockAnimation = new Animation(blockTexture, 1, 4, 0.3f, AnimationType.REPEAT);    
		
		this.player = new Bomber(playerAnimation, bombTexture, explosionTexture, 48, 24);
		this.enemy = new Enemy(enemyAnimation, 64, 64);
		this.enemy2 = new Enemy(enemy2Animation, 256, 64);
		this.block = new DestroyableBlock(blockAnimation, 256, 256);
		
		this.level = new Level(firstLevelTexture);
		
		this.timer = new Timer((int)(1000 / GameConfig.FPS), this);
		this.myKeyAdapter = new MyKeyAdapter(player);
		this.addKeyListener(myKeyAdapter);
	}
	
	public void start() {
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		level.renderBackground((Graphics2D)g);
		player.render((Graphics2D)g);
		enemy.render((Graphics2D)g);
		enemy2.render((Graphics2D)g);
		block.render((Graphics2D)g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Update
		player.update();
		enemy.update();
		enemy2.update();
		block.update();

		// Draw
		repaint();
	}
	
}
