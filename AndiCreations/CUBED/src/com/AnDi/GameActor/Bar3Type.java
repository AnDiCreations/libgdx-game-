package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum Bar3Type {
    
	BAR_SMALL2(250,330.5f,-59),
	BAR_LARGE2(350,330.5f,-59),
	BAR_ROUND2(410,330.5f,-59),
	BAR_LEWIS2(320,330.5f,-59),
	BAR_VETTEL(320,330.5f,-59),
	BAR_SEB(250,330.5f,-59),
	BAR_KIM(450,330.5f,-59);
	
	protected Vector2 position;
	
	
	 public Vector2 getPosition() {
		return position;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
	}

	Bar3Type(float x, float y, int SCROLLSPEED) {
		position = new Vector2(x, y);
		
	}
}