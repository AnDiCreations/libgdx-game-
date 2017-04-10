package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum BarType {
     
	BAR_SMALL(300,82.5f,-59),
	BAR_LARGE(270,4.9f,-59),
	BAR_ROUND(240,82.5f,-59),
	BAR_LEWIS(220,4.9f,-59),
	BAR_VETTEL(400,82.5f,-59),
	BAR_SEB(360,4.9f,-59),
	BAR_KIM(320,4.9f,-59),
	BAR_RAI(430,4.9f,-59);
	
	protected Vector2 position;
	
	
	 public Vector2 getPosition() {
		return position;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
	}



	BarType(float x, float y, int SCROLLSPEED) {
		position = new Vector2(x, y);
		
	}
}
