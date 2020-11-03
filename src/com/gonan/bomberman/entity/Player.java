package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Image;

public class Player extends Image {
	
	public enum Direction { UP, DOWN, RIGHT, LEFT }
	
	private boolean isMoving;
	private Direction direction;

	public Player(BufferedImage img, int rows, int columns, float scale) {
		super(img, rows, columns, scale);
		frameX = 0;
		frameY = 2;
		speed = 16;
		isMoving = false;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
	}
	
	public void move() {
        if (isMoving) {
            switch (direction) {
                case UP:
                    y -= speed;
                    frameY = 0;
                    break;
                case DOWN:
                    y += speed;
                    frameY = 2;
                    break;
                case RIGHT:
                    x += speed;
                    frameY = 1;
                    break;
                case LEFT:
                    x -= speed;
                    frameY = 3;
                    break;
                default:
                    break;
            }
            frameX += frameSpeed;
            if (frameX >= 3) frameX = 0;
        } else {
            frameX = 0;
        }
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
}
