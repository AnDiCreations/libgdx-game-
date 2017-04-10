package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum Bar7Type {
    
	BAR_SMALL2(198,350.5f,-59),
	BAR_LARGE2(135,390.5f,-59),
	BAR_ROUND2(198,450.9f,-59),
	BAR_LEWIS2(135,400.5f,-59);
	
	
	protected Vector2 position;
	
	
	 public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	Bar7Type(float x, float y, int SCROLLSPEED) {
		position = new Vector2(x, y);
		
	}
}
