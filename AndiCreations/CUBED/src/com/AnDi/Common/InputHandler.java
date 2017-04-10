package com.AnDi.Common;


import com.badlogic.gdx.input.GestureDetector;

public class InputHandler extends GestureDetector{
	
	
	public interface DirectionListener{
		void onLeft();
		void onRight();
		void onDown();
		void onUp();
	}
	public InputHandler(DirectionListener directionListener){
		super(new DirectionGestureListener(directionListener));
	}
	static class DirectionGestureListener extends GestureAdapter{
		DirectionListener directionListener;
		public DirectionGestureListener(DirectionListener directionListener){
			this.directionListener=directionListener;
		}
		@Override
		public boolean fling(float velocityX,float velocityY,int button){
			if(Math.abs(velocityX)>Math.abs(velocityY)){
				if(velocityX>0){
					directionListener.onRight();
				}else{
					directionListener.onLeft();
				}
			}else{
				if(velocityY>0){
					directionListener.onDown();
				}else{
					directionListener.onUp();
				}
			}
			return super.fling(velocityX,velocityY,button);
		}
	}

	public InputHandler(GestureListener listener) {
		super(listener);  
    	
		
	}

}
