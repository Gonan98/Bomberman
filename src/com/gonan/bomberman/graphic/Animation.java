package com.gonan.bomberman.graphic;

import com.gonan.bomberman.util.Region;

public class Animation {
	
	private Region[][] regions;
	private float iPos;
	private float jPos;
	private float speed;
	private int limit;
	
	public Animation(int frameWidth, int frameHeight, int rows, int columns, float speed) {
		this.regions = new Region[rows][columns];
		this.speed = speed;
		this.iPos = 0;		
		this.jPos = 0;
		this.limit = columns;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				regions[i][j] = new Region(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
			}
		}
	}
	
	public void update() {
		jPos += speed;
	}

	public void restart() {
		jPos = 0;
	}
	
	public Region getCurrentRegion() {
		return regions[(int)iPos][(int)jPos];
	}

	public void setCurrentRegion(int i, int j) {
		this.iPos = i;
		this.jPos = j;
	}

	public Region[][] getRegions() {
		return regions;
	}

	public void setRegions(Region[][] regions) {
		this.regions = regions;
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

	public boolean isLastFrame() {
		return (int)jPos == limit;
	}
}
