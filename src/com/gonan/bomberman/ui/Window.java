package com.gonan.bomberman.ui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private final GamePanel gamePanel;
	
	public Window() {
		gamePanel = new GamePanel();
		this.add(gamePanel);
		this.pack();
		this.setTitle("Bomberman Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
