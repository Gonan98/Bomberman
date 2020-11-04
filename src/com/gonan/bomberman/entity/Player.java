package com.gonan.bomberman.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gonan.bomberman.graphic.Image;

public class Player extends Image {
	
	public enum Direction { UP, DOWN, RIGHT, LEFT }
	
	private boolean isMoving;
	private Direction direction;

	public Player(BufferedImage img, float posX, float posY, int rows, int columns, float scale) {
		super(img, posX, posY, rows, columns, scale);
		frameX = 0;
		frameY = 2;
		speed = 12;
		isMoving = false;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		
		//g2d.fillRect((int)x, (int)(y + h/2), (int)(w), (int)(h/2 - speed));
		//g2d.fillRect((int)x, (int)(y + h/2), (int)(w - speed), (int)(h/2));
	}
	
	public void move(int[][] matrix) {
        if (isMoving) {
            switch (direction) {
                case UP:
                	frameY = 0;
                	if (matrix[(int)((y + h/2 - speed) / w)][(int)(x / w)] == 0 && matrix[(int)((y + h/2 - speed) / w)][(int)((x + w - speed) / w)] == 0) {
                		y -= speed;
                	}
                    break;
                case DOWN:
                	frameY = 2;
                	if (matrix[(int)((y + h) / w)][(int)(x / w)] == 0 && matrix[(int)((y + h) / w)][(int)((x + w - speed) / w)] == 0) {
                		y += speed;
                	}
                    break;
                case RIGHT:
                	frameY = 1;
                	if (matrix[(int)((y + h/2) / w)][(int)((x + w) / w)] == 0 && matrix[(int)((y + h - speed) / w)][(int)((x + w) / w)] == 0) {
                		x += speed;
                	}
                    break;
                case LEFT:
                	frameY = 3;
                	if (matrix[(int)((y + h/2) / w)][(int)((x - speed) / w)] == 0 && matrix[(int)((y + h - speed) / w)][(int)((x - speed) / w)] == 0) {
                		x -= speed;
                	}
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
