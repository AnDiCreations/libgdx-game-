package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum Bar2Type {
    
	BAR_SMALL2(300,160.5f,-59),
	BAR_LARGE2(280,160.5f,-59),
	BAR_ROUND2(230,225.5f,-59),
	BAR_LEWIS2(340,225.5f,-59);
	
	
	protected Vector2 position;
	
	
	 public Vector2 getPosition() {
		return position;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
	}



	Bar2Type(float x, float y, int SCROLLSPEED) {
		position = new Vector2(x, y);
		
	}
}