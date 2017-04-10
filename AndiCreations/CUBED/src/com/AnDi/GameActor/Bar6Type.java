package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum Bar6Type {
    
	BAR_SMALL2(5.5f,470.5f,-59),
	BAR_LARGE2(82f,400.5f,-59),
	BAR_ROUND2(82f,350.9f,-59),
	BAR_LEWIS2(5.5f,450.5f,-59);
	
	protected Vector2 position;
	
	
	 public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	Bar6Type(float x, float y, int SCROLLSPEED) {
		position = new Vector2(x, y);
		
	}
}