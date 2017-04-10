package com.AnDi.Screen;

import com.AnDi.GameWorld.GameRenderer;
import com.AnDi.GameWorld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{
   
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	
    public GameScreen(){
		
		float screenWidth=Gdx.graphics.getWidth();
		float screenHeight=Gdx.graphics.getHeight();
		float gameHeight=408;
		float gameWidth=screenWidth/(screenHeight/gameHeight);
	
		int midPointY=(int)(gameHeight/2);
		
		world=new GameWorld(midPointY);
		renderer=new GameRenderer(world,(int)gameWidth,midPointY);
		world.setRenderer(renderer);
	}
	
	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		runTime+=delta;
		world.update(delta);
		renderer.render(delta,runTime);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
