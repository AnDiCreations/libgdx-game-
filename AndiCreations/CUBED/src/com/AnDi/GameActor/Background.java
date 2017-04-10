package com.AnDi.GameActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Background {
         
	private int width;
	private int height;
	private Vector2 position;
	private Vector2 velocity;
	private Rectangle screenRect;
	
   public Background(float x,float y,int width,int height){
	    	
			this.setWidth(width);
			this.setHeight(height);
			setPosition(new Vector2(x,y));
			velocity=new Vector2(20,20);
			screenRect=new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
   }
   
   public void update(float delta){
	   
	       if(position.y< -150){
	       	position.y+=.5f;
	       }else if(position.y+height>screenRect.height){
	       	position.y-=.5f;
	       }
		   
   }
   
   public void updateUp(){
	   position.y-=velocity.y;
	   
   }
   public void updateDown(){
	   
	   position.y+=velocity.y;
	   
	 
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

public Vector2 getPosition() {
	return position;
}

public void setPosition(Vector2 position) {
	this.position = position;
}

public float getX() {
	return position.x;
}
public float getY() {
	return position.y;
}
}
