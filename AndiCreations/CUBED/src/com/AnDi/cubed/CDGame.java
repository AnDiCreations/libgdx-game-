package com.AnDi.cubed;

import com.AnDi.Common.AssetLoader;
import com.AnDi.Screen.SplashScreen;
import com.badlogic.gdx.Game;

public class CDGame  extends Game{
	 
	@Override
	public void create() {	
		AssetLoader.load();
		setScreen(new SplashScreen(this));
		
	}

	@Override
	public void dispose(){
		AssetLoader.dispose();
	}
	
}
