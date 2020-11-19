package com.gonan.bomberman.entity;

import java.awt.*;

public class Hitbox {

    public float x;
    public float y;
    public float w;
    public float h;

    public Hitbox() {
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;
    }

    public Hitbox(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawRect((int)x,(int)y,(int)w,(int)h);
    }

    public boolean intersect(Hitbox b) {
        return (this.x < b.x + b.w &&
                this.x + this.w > b.x &&
                this.y < b.y + b.h &&
                this.y + this.h > b.y);
    }
}
