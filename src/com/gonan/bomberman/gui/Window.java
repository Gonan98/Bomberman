package com.gonan.bomberman.gui;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas;
	
	public Window(String title, int width, int height) {
		this.canvas = new Canvas(width, height);
		this.add(canvas);
		this.pack();
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void start() {
		canvas.start();
	}

}
