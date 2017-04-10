package com.AnDi.GameActor;

import com.AnDi.Common.RandomUtilsDown1;
import com.AnDi.Common.RandomUtilsDown2;
import com.badlogic.gdx.math.Vector2;

public class ScrollableUpDown {
       
	protected Vector2 position,position2,position3;
	protected Vector2 velocity;
	protected int width;
	protected int height;
	protected boolean isScrolledDown;

	public ScrollableUpDown(float x, float y, int width, int height, float scrollSpeed) {
		position = new Vector2(RandomUtilsDown1.getRandomBarType().getPosition().x,RandomUtilsDown1.getRandomBarType().getPosition().y);
		position2=new Vector2(RandomUtilsDown2.getRandomBarType().getPosition().x,RandomUtilsDown2.getRandomBarType().getPosition().y);
		
		velocity = new Vector2(0,scrollSpeed);
		this.width = width;
		this.height = height;
		isScrolledDown = false;
	}

	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
        position2.add(velocity.cpy().scl(delta));

       
		// If the Scrollable object is no longer visible:
		if (position.y + height < 0) {
			position.y=RandomUtilsDown1.getRandomBarType().getPosition().y;
			position.x=RandomUtilsDown1.getRandomBarType().getPosition().x;
			
		}else if(position2.y + height < 0){
			position2.y=RandomUtilsDown2.getRandomBarType().getPosition().y;
			position2.x=RandomUtilsDown2.getRandomBarType().getPosition().x;
		}
	}

	// Reset: Should Override in subclass for more specific behavior.
	public void reset(float newX) {
		
		position.y = RandomUtilsDown1.getRandomBarType().getPosition().y;
		position2.y = RandomUtilsDown2.getRandomBarType().getPosition().y;
		
		
	}
	public void stop(){
		velocity.y=0;
	}
	
	// Getters for instance variables
	public boolean isScrolledDown() {
		return isScrolledDown;
	}

	public float getTailX() {
		return position.x + width;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Vector2 getPosition2() {
		return position2;
	}

	public void setPosition2(Vector2 position2) {
		this.position2 = position2;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getPosition3() {
		return position3;
	}

	public void setPosition3(Vector2 position3) {
		this.position3 = position3;
	}

	
}   
