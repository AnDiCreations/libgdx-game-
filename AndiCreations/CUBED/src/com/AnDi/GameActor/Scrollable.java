package com.AnDi.GameActor;


import com.AnDi.Common.RandomUtils;
import com.AnDi.Common.RandomUtils2;
import com.AnDi.Common.RandomUtils3;
import com.badlogic.gdx.math.Vector2;

public class Scrollable {
    
	// Protected is similar to private, but allows inheritance by subclasses.
				protected Vector2 position,position2,position3,position4,position5;
				protected Vector2 velocity;
				protected int width;
				protected int height;
				protected boolean isScrolledLeft;

				public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
					position = new Vector2(RandomUtils.getRandomBarType().getPosition().x,RandomUtils.getRandomBarType().getPosition().y);
					position2=new Vector2(RandomUtils2.getRandomBarType().getPosition().x,RandomUtils2.getRandomBarType().getPosition().y);
					position3 = new Vector2(RandomUtils3.getRandomBarType().getPosition().x,RandomUtils3.getRandomBarType().getPosition().y);
					
					velocity = new Vector2(scrollSpeed, 0);
					this.width = width;
					this.height = height;
					isScrolledLeft = false;
				}

				public void update(float delta) {
					position.add(velocity.cpy().scl(delta));
	                position2.add(velocity.cpy().scl(delta));
	                position3.add(velocity.cpy().scl(delta));
	 
					// If the Scrollable object is no longer visible:
					if (position.x + width < 0) {
						position.x=RandomUtils.getRandomBarType().getPosition().x;
						position.y=RandomUtils.getRandomBarType().getPosition().y;
						
					}else if(position2.x + width < 0){
						position2.x=RandomUtils2.getRandomBarType().getPosition().x;
						position2.y=RandomUtils2.getRandomBarType().getPosition().y;
						
					}else if(position3.x + width <0){
						position3.x=RandomUtils3.getRandomBarType().getPosition().x;
						position3.y=RandomUtils3.getRandomBarType().getPosition().y;
						
					}
				}

				// Reset: Should Override in subclass for more specific behavior.
				public void reset(float newX) {
					
					position.x = RandomUtils.getRandomBarType().getPosition().x;
					position2.x = RandomUtils2.getRandomBarType().getPosition().x;
					position3.x=RandomUtils3.getRandomBarType().getPosition().x;
					
				}
				public void stop(){
					velocity.x=0;
				}

				
				// Getters for instance variables
				public boolean isScrolledLeft() {
					return isScrolledLeft;
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

				public Vector2 getPosition4() {
					return position4;
				}

				public void setPosition4(Vector2 position4) {
					this.position4 = position4;
				}

				public Vector2 getPosition5() {
					return position5;
				}

				public void setPosition5(Vector2 position5) {
					this.position5 = position5;
				}
}
