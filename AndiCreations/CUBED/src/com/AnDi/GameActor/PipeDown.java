package com.AnDi.GameActor;

import com.AnDi.Common.RandomUtilsDown1;
import com.AnDi.Common.RandomUtilsDown2;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class PipeDown extends ScrollableUpDown{
     
	   private Rectangle barUp2,barDown2;
		
		public PipeDown(float x, float y, int width, int height, float scrollSpeed) {
			super(x, y, width, height, scrollSpeed);
			barUp2=new Rectangle();
			barDown2=new Rectangle();
		    
		}
		@Override
		public void reset(float newY) {
			// Call the reset method in the superclass (Scrollable)
			super.reset(newY);
			// Change the x to a random number
			position.y=RandomUtilsDown1.getRandomBarType().getPosition().y;
			position2.y=RandomUtilsDown2.getRandomBarType().getPosition().y;
			
			position.x=RandomUtilsDown1.getRandomBarType().getPosition().x;
			position2.x=RandomUtilsDown2.getRandomBarType().getPosition().x;
			
		}
		
		@Override
		public void update(float delta){
			super.update(delta);
			barUp2.set(position.x,position.y,width,height);
			barDown2.set(position2.x,position2.y,width,height);

		}
		public Rectangle getBarUp2() {
			return barUp2;
		}
		public void setBarUp2(Rectangle barUp2) {
			this.barUp2 = barUp2;
		}
		public Rectangle getBarDown2() {
			return barDown2;
		}
		public void setBarDown2(Rectangle barDown2) {
			this.barDown2 = barDown2;
		}
		public boolean collides(Cube cube){
				if(Intersector.overlaps(cube.getBoundingRect(),barUp2)
						||Intersector.overlaps(cube.getBoundingRect(),barDown2)){

				}
			return false;
		}
		public void onRestart(float y,float scrollSpeed){
			 velocity.y=scrollSpeed;
			 reset(y);
			}
		
		
		
}
