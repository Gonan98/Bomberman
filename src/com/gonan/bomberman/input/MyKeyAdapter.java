package com.gonan.bomberman.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.gonan.bomberman.entity.Bomber;
import com.gonan.bomberman.entity.Bomber.State;
import com.gonan.bomberman.util.Direction;

public class MyKeyAdapter extends KeyAdapter {
	
	private Bomber bomber;
	
	public MyKeyAdapter(Bomber bomber) {
		this.bomber = bomber;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            bomber.setState(State.MOVING);
            bomber.setDirection(Direction.UP);
            break;

        case KeyEvent.VK_DOWN:
            bomber.setState(State.MOVING);
            bomber.setDirection(Direction.DOWN);
            break;

        case KeyEvent.VK_RIGHT:
            bomber.setState(State.MOVING);
            bomber.setDirection(Direction.RIGHT);
            break;

        case KeyEvent.VK_LEFT:
            bomber.setState(State.MOVING);
            bomber.setDirection(Direction.LEFT);
            break;

        default:
            break;
    }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_LEFT:
            bomber.setState(State.STILL);
            break;

        default:
            break;
    }
	}
}
