package com.gonan.bomberman;

import com.gonan.bomberman.gui.Window;

public class App {

	public static void main(String[] args) {
		Window window = new Window("Bomberman Clone", 17 * 48, 15 * 48);
		window.start();
	}
	
}
