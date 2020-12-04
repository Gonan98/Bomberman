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
import com.gonan.bomberman.entity.Enemy;
import com.gonan.bomberman.graphic.Animation;
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.input.MyKeyAdapter;
import com.gonan.bomberman.util.GameConfig;

public class Canvas extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Texture playerTexture;
	private Texture bombTexture;
	private Texture explosionTexture;
	private Texture enemyTexture;
	private Texture enemyTexture2;
	private Enemy enemy;
	private Enemy enemy2;
	private Bomber player;
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
		this.explosionTexture = new Texture("res/bomb_explosion.png");
		this.player = new Bomber(playerTexture, bombTexture, explosionTexture, 0, 0);
		this.enemy = new Enemy(enemyTexture, new Animation(16, 24, 4, 4, 0.3f), 64, 64);
		this.enemy2 = new Enemy(enemyTexture2, new Animation(16, 16, 1, 6, 0.3f), 128, 64);
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
		player.render((Graphics2D)g);
		enemy.render((Graphics2D)g);
		enemy2.render((Graphics2D)g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Update
		player.update();
		enemy.update();
		enemy2.update();

		// Draw
		repaint();
	}
	
}
