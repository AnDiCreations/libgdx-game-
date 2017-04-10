package com.AnDi.GameActor;

import com.AnDi.Common.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Cube {
       
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private int width;
	private int height;
	
	private Rectangle boundingRect,screenRect;
    public boolean isAlive;
  
    
    public Cube(float x,float y,int width,int height){
    	
		this.width=width;
		this.height=height;
		position=new Vector2(x,y);
		velocity=new Vector2(5,5);
		acceleration=new Vector2(0,0);
		boundingRect=new Rectangle();
		screenRect=new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        isAlive=true;
        
	}
   public void update(float delta){
		
		boundingRect.set(position.x,position.y,width,height);
		
        if(position.y < 0){
        	position.y+=1.5f;
        }else if(position.y+height>screenRect.height){
        	position.y-=1.5f;
        }else if(position.x<0){
        	position.x+=1.5f;
        }else if(position.x + width>screenRect.width){
        	position.x-=1.5f;
        }
		
	}
   public void updateReady(float delta){
	   
	   if(position.y<0){
		   position.y+=velocity.y;
		   
	   }
	   else if(position.y+height>screenRect.height){
		   position.y-=velocity.y;
	   }
	   
   }
   public void moveUp(){
       position.y-=62;
      AssetLoader.flap.play();
	}
	
	public void moveDown(){
	   position.y +=60;
	   AssetLoader.flap.play();
	}
	public void moveRight(){
		position.x +=65;
		  AssetLoader.flap.play();
	}
	public void moveLeft(){
		position.x -=65;
		  AssetLoader.flap.play();
	} 
	public void die(){
		isAlive=false;
		velocity.y=0;
		velocity.x=0;
	}
	public void onRestart(float y,float x){
		position.y=y;
		position.x=x;
		velocity.x=0;
		velocity.y=0;
		acceleration.x=0;
		acceleration.y=0;
		isAlive=true;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	public Vector2 getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
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
	public Rectangle getBoundingRect() {
		return boundingRect;
	}
	public void setBoundingRect(Rectangle boundingRect) {
		this.boundingRect = boundingRect;
	}
	
	public float getX() {
		return position.x;
	}
	public float getY() {
		return position.y;
	}
	
}
	
