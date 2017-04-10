package com.AnDi.GameWorld;

import com.AnDi.Common.AssetLoader;
import com.AnDi.Common.InputHandler;
import com.AnDi.GameActor.Background;
import com.AnDi.GameActor.Cube;
import com.AnDi.GameActor.FinalBar;
import com.AnDi.GameActor.ScrollHandler;
import com.AnDi.GameActor.ScrollHandlerUpDown;
import com.badlogic.gdx.Gdx;

public class GameWorld {
	
	private GameState currentState;
	public int midPointY;
	
	private Cube cube;
	private FinalBar bar;
	private ScrollHandler scroller;
	private ScrollHandlerUpDown scroller2;
	private GameRenderer renderer;
	private Background bg;
	
    private int score=0;
    private int StarScore=0;
    private float runTime=0;
    
	public enum GameState{
		MENU,READY,RUNNING,GAMEOVER,HIGHSCORE,
	}
	
	public GameWorld(int midPointY){
		
		currentState=GameState.MENU;
		this.midPointY=midPointY;
		
		setCube(new Cube(10,midPointY+88,55,53));
		scroller=new ScrollHandler(midPointY+66);
		scroller2=new ScrollHandlerUpDown(midPointY);
		setBar(new FinalBar(100,100,65,65,this));
		setBg(new Background(0,0,200,500));
		
		
           Gdx.input.setInputProcessor(new InputHandler(new InputHandler.DirectionListener(){
			 
			 @Override
				public void onUp(){
				 
				 if(cube.isAlive){
					 
						cube.moveUp();
			
			           }
		
						if(isGameOver()||isHighScore()){
							restart();
						}
					    if(isMenu()){
				            ready();
				            
						}
					   
				}
				
				@Override
				public void onDown(){
					
					if(cube.isAlive){
						
						cube.moveDown();
				
				        }
					
						if(isGameOver()||isHighScore()){
							restart();
						}
						
						if(isMenu()){
							ready();
						}
									}
				@Override
				public void onRight(){
					
					if(cube.isAlive){
						
						cube.moveRight();
					
						}
					
			            if(isGameOver()||isHighScore()){
			            	restart();
			            }
			            
			            if(isMenu()){
							ready();
							
						}
			            
				}
				@Override
				public void onLeft(){
					
					if(cube.isAlive){
						
						cube.moveLeft();
					
						}
			            if(isGameOver()||isHighScore()){
			            	restart();
			            }
			            if(isMenu()){
							ready();
						}
			          				
				}
			}));
		 
	}
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}

	public void update(float delta){
		
		 setRunTime(getRunTime() + delta);
		 
		switch(currentState){
		case READY:
		case MENU:
			updateReady(delta);
			break;
			
		case RUNNING:
			updateRunning(delta);
			break;
			default:
				break;
			
		
		}
		
	}

	private void updateReady(float delta) {
		cube.updateReady(delta);
		scroller2.update(delta);
		scroller.update(delta);
		
	}

	private void updateRunning(float delta) {
		
		if(delta > .15f){
			delta = .15f;
		}
		cube.update(delta);
		bar.update();
		scroller.update(delta);
		scroller2.update(delta);

		
		if(scroller.collides(cube)||scroller.collides(cube) && cube.isAlive){
			scroller.stop();
			scroller2.stop();
			currentState=GameState.GAMEOVER;
			AssetLoader.dead.play();
			
			renderer.prepareTransition(255, 255, 255, .3f);
			
			if(score >= AssetLoader.getHighScore()){
				AssetLoader.setHighScore(score);
				currentState=GameState.GAMEOVER;
			}
		}
		if(scroller2.collides(cube)||scroller.collides(cube) && cube.isAlive){
			scroller2.stop();
			scroller.stop();
			currentState=GameState.GAMEOVER;
			AssetLoader.dead.play();
			
			renderer.prepareTransition(255, 255, 255, .3f);
			
			if(score>AssetLoader.getHighScore()){
				AssetLoader.setHighScore(score);
				currentState=GameState.GAMEOVER;
				
			}
			
		}
		if(bar.collides(cube)){
		  
		  AssetLoader.coin.play();
		  
		  renderer.prepareTransition(255, 255, 255, .3f);
		}
		
		if(AssetLoader.getHighScore()>10){
		
		}
		else if(AssetLoader.getHighScore()>20){
		
		}
		else if(AssetLoader.getHighScore()>30){
			
		}
		if(AssetLoader.getStarScore()>5){
			
			
		}
		
	}
	
    public void start(){
    	
		currentState = GameState.RUNNING;
    }
	
    public void ready() {
		currentState = GameState.READY;
		renderer.prepareTransition(255, 255, 255, .3f);
	}
	public void restart(){
		score=0;
		setStarScore(0);
		scroller.onRestart();
		scroller2.onRestart();
		cube.onRestart(midPointY-5,10);
	
		ready();
	}
	public boolean isGameOver(){
		
		return currentState == GameState.GAMEOVER;
		
	}
   public boolean isReady(){
		
		return currentState == GameState.READY;
		
	}
	public boolean isHighScore(){
		
		return currentState==GameState.HIGHSCORE;
	}
	
	public int getScore(){
		return score;
	}
	public void addStarScore(int increment){
		setStarScore(getStarScore() + increment);
	}
	public void addScore(int increment){
		score += increment;
	}

	public Cube getCube() {
		return cube;
	}

	public void setCube(Cube cube) {
		this.cube = cube;
	}

	public ScrollHandler getScroller() {
		return scroller;
	}

	public void setScroller(ScrollHandler scroller) {
		this.scroller = scroller;
	}

	public ScrollHandlerUpDown getScroller2() {
		return scroller2;
	}

	public void setScroller2(ScrollHandlerUpDown scroller2) {
		this.scroller2 = scroller2;
	}

	public FinalBar getBar() {
		return bar;
	}

	public void setBar(FinalBar bar) {
		this.bar = bar;
	}

	public float getRunTime() {
		return runTime;
	}

	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}
	public boolean isMenu(){
		return currentState==GameState.MENU;
	}
	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}
	public Background getBg() {
		return bg;
	}
	public void setBg(Background bg) {
		this.bg = bg;
	}
	
	public int getStarScore() {
		return StarScore;
	}
	public void setStarScore(int starScore) {
		StarScore = starScore;
	}
	

}
