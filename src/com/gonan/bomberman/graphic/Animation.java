package com.gonan.bomberman.graphic;

import com.gonan.bomberman.util.Region;

public class Animation {
	
	public enum AnimationType { NON_REPEAT, REPEAT, BOOMERANG }
	
	//private Sprite sprite;
	private Region[][] regions;
	private float iPos;
	private float jPos;
	private float speed;
	private boolean stopped;
	private AnimationType type;
	
	public Animation(int frameWidth, int frameHeight, int rows, int columns, float speed, AnimationType type) {
		//this.sprite = new Sprite(texture);
		this.regions = new Region[rows][columns];
		this.speed = speed;
		this.iPos = 0f;		
		this.jPos = 0f;
		this.type = type;
		this.stopped = false;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				regions[i][j] = new Region(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
			}
		}
		
		//sprite.setRegion(this.getCurrentRegion());
		
	}
	
	public void update() {
		if (!stopped) {
			jPos += speed;
			if (type == AnimationType.BOOMERANG && animationEnd()) {
				speed *= -1;
				if ((int)jPos == 0) jPos = 0f;
			} else if (type == AnimationType.REPEAT && animationEnd()) {
				jPos = 0f;
			} else if (type == AnimationType.NON_REPEAT && animationEnd()) {
				stopped = true;
			}
		}
	}
	
	private boolean animationEnd() {
		return jPos + speed >= regions[0].length || jPos + speed < 0;
	}
	
	public Region getCurrentRegion() {
		return regions[(int)iPos][(int)jPos];
	}

	public void setCurrentRegion(int i, int j) {
		this.iPos = i;
		this.jPos = j;
	}
	
	public boolean isLastFrame() {
		return jPos >= regions[0].length - 1;
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

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public AnimationType getType() {
		return type;
	}

	public void setType(AnimationType type) {
		this.type = type;
	}
	
}
