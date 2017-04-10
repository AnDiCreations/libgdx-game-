package com.AnDi.GameActor;

import com.AnDi.Common.RandomUtils;
import com.AnDi.Common.RandomUtils2;
import com.AnDi.Common.RandomUtils3;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Pipe extends Scrollable{
      
private Rectangle barUp,barDown,barSide;
	
	public Rectangle getBarUp() {
		return barUp;
	}
	public void setBarUp(Rectangle barUp) {
		this.barUp = barUp;
	}
	public Pipe(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
		barUp=new Rectangle();
		barDown=new Rectangle();
		barSide=new Rectangle();
		
	}
	@Override
	public void reset(float newX) {
		// Call the reset method in the superclass (Scrollable)
		super.reset(newX);
		// Change the x to a random number
		position.x=RandomUtils.getRandomBarType().getPosition().x;
		position2.x=RandomUtils2.getRandomBarType().getPosition().x;
		
		position.y=RandomUtils.getRandomBarType().getPosition().y;
		position2.y=RandomUtils2.getRandomBarType().getPosition().y;
		
		position3.x=RandomUtils3.getRandomBarType().getPosition().x;
		
		position3.y=RandomUtils3.getRandomBarType().getPosition().y;
		
	}
	public Rectangle getBarDown() {
		return barDown;
	}
	public void setBarDown(Rectangle barDown) {
		this.barDown = barDown;
	}
	public Rectangle getBarSide(){
		return barSide;
	}
	public void setBarSide(Rectangle barSide){
		this.barSide=barSide;
	}
	@Override
	public void update(float delta){
		super.update(delta);
		barUp.set(position.x,position.y,width,height);
		barDown.set(position2.x,position2.y,width,height);
		barSide.set(position3.x,position3.y,width,height);
		
	}
	public boolean collides(Cube cube){
		
			if(Intersector.overlaps(cube.getBoundingRect(),barUp)
					||Intersector.overlaps(cube.getBoundingRect(),barDown)
					||Intersector.overlaps(cube.getBoundingRect(),barSide)){
				
			}
		
		return false;
	}
	public void onRestart(float x,float scrollSpeed){
	 velocity.x=scrollSpeed;
	 reset(x);
	}
}
