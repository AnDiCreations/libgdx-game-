package com.AnDi.GameActor;

import com.badlogic.gdx.math.Vector2;

public enum FinalBarType {
	
	BAR_ROW(10,7.5f),
	BAR_LARGE2(88f,7.5f),
	BAR_ROW2(200,7.5f),
	
	BAR_COLUMN(88f,330),
	BAR_COLUMN2(10,330);
	
	protected Vector2 position;
	
	 public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	FinalBarType(float x, float y) {
		position = new Vector2(x, y);
		
	}
}
