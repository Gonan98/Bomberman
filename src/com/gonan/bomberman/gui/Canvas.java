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
import com.gonan.bomberman.graphic.Texture;
import com.gonan.bomberman.input.MyKeyAdapter;
import com.gonan.bomberman.util.GameConfig;

public class Canvas extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Texture playerTexture;
	private Bomber player;
	private MyKeyAdapter myKeyAdapter;
	private Timer timer;

	public Canvas(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		
		this.playerTexture = new Texture("res/bomberman_spritesheet.png");
		this.player = new Bomber(playerTexture, 0, 0);
		this.timer = new Timer((int)(1000 / GameConfig.FPS), this);
		this.myKeyAdapter = new MyKeyAdapter(player);
		this.addKeyListener(myKeyAdapter);
	}
	
	public void start() {
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		player.render((Graphics2D)g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Update
		player.update();
		
		// Draw
		repaint();
	}
	
}
