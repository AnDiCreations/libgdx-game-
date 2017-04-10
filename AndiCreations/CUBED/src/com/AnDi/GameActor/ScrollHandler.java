package com.AnDi.GameActor;

import com.AnDi.Common.RandomUtils;
import com.AnDi.Common.RandomUtils2;
import com.AnDi.Common.RandomUtils3;
import com.badlogic.gdx.math.Intersector;

public class ScrollHandler {
     
private Pipe pipe1,pipe2,pipe3;
	
	public static final int SCROLL_SPEED=-220;
	public static final float PIPE_GAP=3.0f;
	
	public ScrollHandler(int midPointY){
	
		pipe1 = new Pipe(RandomUtils.getRandomBarType().getPosition().x,RandomUtils.getRandomBarType().getPosition().y,65,65, SCROLL_SPEED);
		pipe2 = new Pipe(RandomUtils2.getRandomBarType().getPosition().x,RandomUtils2.getRandomBarType().getPosition().y,65,65, SCROLL_SPEED
				);
		pipe3 = new Pipe(RandomUtils3.getRandomBarType().getPosition().x,RandomUtils3.getRandomBarType().getPosition().y,65,65, SCROLL_SPEED
				);
		
	}
	public void update(float delta){
		
		pipe1.update(delta);
		pipe2.update(delta);
		pipe3.update(delta);
		
	if(pipe1.isScrolledLeft()){
		pipe1.reset(RandomUtils.getRandomBarType().getPosition().x);
	}else if(pipe2.isScrolledLeft()){
		pipe2.reset(RandomUtils2.getRandomBarType().getPosition().x);
	}else if(pipe3.isScrolledLeft()){
		pipe3.reset(RandomUtils3.getRandomBarType().getPosition().x);
	}
	
	}
	public void stop(){
		
		pipe1.stop();
		pipe2.stop();
		pipe3.stop();
	}
	public boolean collides(Cube cube){
		return(Intersector.overlaps(cube.getBoundingRect(),pipe1.getBarUp())
				|| Intersector.overlaps(cube.getBoundingRect(),pipe2.getBarDown())
				|| Intersector.overlaps(cube.getBoundingRect(),pipe3.getBarSide())
				);
	}
	public void onRestart(){
		pipe1.onRestart(210,SCROLL_SPEED);
		pipe2.onRestart(pipe1.getTailX()+5f,SCROLL_SPEED);
		pipe3.onRestart(pipe2.getTailX()+5f,SCROLL_SPEED);
	}
	
	public static float getPipeGap() {
		return PIPE_GAP;
	}
	
	public Pipe getPipe1() {
		return pipe1;
	}
	public void setPipe1(Pipe pipe1) {
		this.pipe1 = pipe1;
	}
	public Pipe getPipe2() {
		return pipe2;
	}
	public void setPipe2(Pipe pipe2) {
		this.pipe2 = pipe2;
	}
	public Pipe getPipe3() {
		return pipe3;
	}
	public void setPipe3(Pipe pipe3) {
		this.pipe3 = pipe3;
	}
	
}
