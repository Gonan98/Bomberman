package com.gonan.bomberman.graphic;

public class Animation {
	
	public enum AnimationType { NON_REPEAT, REPEAT, BOOMERANG }
	
	private AnimationType type;
	private SpriteSheet spriteSheet;
	private float i;
	private float j;
	private float speed;
	private boolean stopped;
	
	public Animation(Texture texture, int rows, int columns, float speed, AnimationType type) {
		this.spriteSheet = new SpriteSheet(texture, rows, columns);
		this.speed = speed;
		this.i = 0;		
		this.j = 0;
		this.type = type;
		this.stopped = false;
		
	}
	
	public void update() {
		if (!stopped) {
			
			j += speed;
			
			if (type == AnimationType.BOOMERANG && animationEnd()) {
				
				speed *= -1;
				if ((int)j == 0) j = 0;
				
			} else if (type == AnimationType.REPEAT && animationEnd()) {
				
				j = 0;
				
			} else if (type == AnimationType.NON_REPEAT && animationEnd()) {
				
				stopped = true;
				
			}
		}
	}
	
	public Sprite getCurrentSprite() {
		return spriteSheet.getSprites()[(int)i][(int)j];
	}
	
	public void setCurrentSprite(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	private boolean animationEnd() {
		return j + speed >= spriteSheet.getColumns() || j + speed < 0;
	}

	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getiPos() {
		return i;
	}

	public void setiPos(float iPos) {
		this.i = iPos;
	}

	public float getjPos() {
		return j;
	}

	public void setjPos(float jPos) {
		this.j = jPos;
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
