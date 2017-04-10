package com.AnDi.GameActor;

import java.util.ArrayList;
import java.util.Random;

import com.AnDi.Common.AssetLoader;
import com.AnDi.GameWorld.GameWorld;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class FinalBar {
     
	private Rectangle finalBar;
	private Vector2 position;
	public GameWorld gameWorld;
	
	private int width;
	private int height;
	private boolean isScored=false;
	
    private ArrayList<Integer>usedNumbers;
    private Random r;
	
	public FinalBar(float x,float y,int width,int height,GameWorld gameWorld){
	
	this.gameWorld=gameWorld;
	this.width=width;
	this.height=height;
	finalBar=new Rectangle();
	position=new Vector2(x,y);
	usedNumbers = new ArrayList<Integer>();
    r = new Random();
    
	}
	public void update(){

		finalBar.set(position.x,position.y,width,height);
		
	}
	public void reset(int maxNumber){
		Integer res = r.nextInt(maxNumber);
	  if(usedNumbers.contains(res)){
		  reset(5);
	  }
	  usedNumbers.add(res);
	  if(usedNumbers.size()==maxNumber){
		  usedNumbers.clear();
	  }
	  if(res == 0){
	    	position = FinalBarType.BAR_COLUMN.getPosition();
	    	usedNumbers.add(0);
	    }else if(res ==1){
	    	position =FinalBarType.BAR_COLUMN2.getPosition();
	    	usedNumbers.add(1);
	    }else if(res == 2){
	    	position =FinalBarType.BAR_LARGE2.getPosition();
	    	usedNumbers.add(2);
	    }else if(res == 3){
	    	position =FinalBarType.BAR_ROW.getPosition();
	    	usedNumbers.add(3);
	    }else if(res == 4){
	    	position =FinalBarType.BAR_ROW2.getPosition();
	    	usedNumbers.add(4);
	    }
	    
	    isScored=false;
	    System.out.println(res);
	    
	}
	
	public boolean collides(Cube cube){
		
		if(Intersector.overlaps(cube.getBoundingRect(),finalBar)){
			reset(5);
			AssetLoader.coin.play();
			
		if(!isScored()){
			
			addScore(1);
			
		      }
		}
	
	return false;
   }
	public void addScore(int increment){
		gameWorld.addScore(increment);
	}
	public boolean isScored(){
		return isScored;
	}
	public void setScored(boolean b){
		isScored=b;
	}
	public Rectangle getFinalBar() {
		return finalBar;
	}
	public void setFinalBar(Rectangle finalBar) {
		this.finalBar = finalBar;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
