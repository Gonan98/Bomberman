package com.gonan.bomberman.graphic;

import com.gonan.bomberman.util.Region;

public class Animation {
	
	private Region[][] regions;
	private float iPos;
	private float jPos;
	private int frames;
	private float speed;
	
	public Animation(int frameWidth, int frameHeight, int rows, int columns, float speed) {
		this.frames = rows * columns;
		this.regions = new Region[rows][columns];
		this.speed = speed;
		this.iPos = 0;		
		this.jPos = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				regions[i][j] = new Region(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
			}
		}
	}
	
	public void update() {
		jPos += speed;
		if (jPos > regions[0].length) jPos = 0;
	}
	
	public Region getCurrentRegion() {
		return regions[(int)iPos][(int)jPos];
	}

	public Region[][] getRegions() {
		return regions;
	}

	public void setRegions(Region[][] regions) {
		this.regions = regions;
	}

	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getiPos() {
		return iPos;
	}

	public void setiPos(float iPos) {
		this.iPos = iPos;
	}

	public float getjPos() {
		return jPos;
	}

	public void setjPos(float jPos) {
		this.jPos = jPos;
	}

}
