package com.AnDi.GameActor;

import com.AnDi.Common.RandomUtilsDown1;
import com.AnDi.Common.RandomUtilsDown2;
import com.badlogic.gdx.math.Intersector;

public class ScrollHandlerUpDown {
        
	private PipeDown pipe6,pipe7;
    
	public static final int SCROLL_SPEED=-220;
	public static final float PIPE_GAP=3.0f;
	
	public ScrollHandlerUpDown(int midPointY){
	
		pipe6 = new PipeDown(RandomUtilsDown1.getRandomBarType().getPosition().x,RandomUtilsDown1.getRandomBarType().getPosition().y,65,65, SCROLL_SPEED);
		pipe7 = new PipeDown(RandomUtilsDown2.getRandomBarType().getPosition().x,RandomUtilsDown2.getRandomBarType().getPosition().y,65,65, SCROLL_SPEED
				);
	}
	public void update(float delta){
		
		pipe6.update(delta);
		pipe7.update(delta);
		
		
	if(pipe6.isScrolledDown()){
		pipe6.reset(RandomUtilsDown1.getRandomBarType().getPosition().y);
	}else if(pipe7.isScrolledDown()){
		pipe7.reset(RandomUtilsDown2.getRandomBarType().getPosition().y);
	}
	
	}
  public void stop(){
		
		pipe6.stop();
		pipe7.stop();

	}
  public boolean collides(Cube cube){
		return(Intersector.overlaps(cube.getBoundingRect(),pipe6.getBarUp2())
				|| Intersector.overlaps(cube.getBoundingRect(),pipe7.getBarDown2())
				);
	}
  public void onRestart(){
		pipe6.onRestart(210,SCROLL_SPEED);
		pipe7.onRestart(pipe7.getY()+5f,SCROLL_SPEED);
	   
	}
	
	
	public static float getPipeGap() {
		return PIPE_GAP;
	}
	public PipeDown getPipe6() {
		return pipe6;
	}
	public void setPipe6(PipeDown pipe6) {
		this.pipe6 = pipe6;
	}
	public PipeDown getPipe7() {
		return pipe7;
	}
	public void setPipe7(PipeDown pipe7) {
		this.pipe7 = pipe7;
	}
	
}
