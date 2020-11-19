package com.gonan.bomberman.entity;

import com.gonan.bomberman.graphic.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Sprite  {

    enum Direction { UP, DOWN, RIGHT, LEFT }

    private Direction direction;

    public Enemy(BufferedImage texture, float posX, float posY, int rows, int columns, float scale) {
        super(texture, posX, posY, rows, columns, scale);
        this.frameX = 0;
        this.frameY = 0;
        this.frameSpeed = 0.2f;
        this.speed = 3;
        hitbox = new Hitbox(x, y + 3 * h / 4, w, h / 4);
        setRandomDirection();
    }

    private void setRandomDirection() {
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                direction = Direction.UP;
                break;
            case 1:
                direction = Direction.DOWN;
                break;
            case 2:
                direction = Direction.RIGHT;
                break;
            case 3:
                direction = Direction.LEFT;
                break;
            default:
                break;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        hitbox.draw(g2d);
        //g2d.fillRect((int)x, (int)(y + speed), (int)(w), (int)(h - speed));
        //g2d.fillRect((int)(x + speed), (int)y, (int)(w - speed), (int)h);
    }

    public void move(int[][] m) {
        switch (direction) {
            case UP:
                if (m[(int)((y - speed)/h)][(int)((x)/w)] == 0) {
                    y -= speed;
                } else {
                    setRandomDirection();
                }
                break;
            case DOWN:
                if (m[(int)((y + h)/h)][(int)((x)/w)] == 0) {
                    y += speed;
                } else {
                    setRandomDirection();
                }
                break;
            case RIGHT:
                if (m[(int)((y)/h)][(int)((x + w)/w)] == 0) {
                    x += speed;
                } else {
                    setRandomDirection();
                }
                break;
            case LEFT:
                if (m[(int)((y)/h)][(int)((x - speed)/w)] == 0) {
                    x -= speed;
                } else {
                    setRandomDirection();
                }
                break;
            default:
                break;
        }
        hitbox.x = x;
        hitbox.y = y + 3 * h / 4;
        frameX += frameSpeed;
        if (frameX > 11) frameX = 0;
    }
}
