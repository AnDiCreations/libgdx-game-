package com.AnDi.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
     
	public static Texture bg5,ice,stone,star,bg3,bg2,collect,gold,can,many,win,pack,egg,logo,title,swipe,title2,gameover,retry,ready,highscore,currentscore,bg;
	
    public static Sound dead,coin,flap;
    public static Music theme;
	
	public static BitmapFont font,shadow;
	
	public static Preferences prefs;
	
	public static TextureRegion pl1,pl2,pl3,pl4,wood;
	
	public static Animation playerAnim;
	
	public static void load(){
		
		pack=new Texture(Gdx.files.internal("pack.png"));
		pack.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		win=new Texture(Gdx.files.internal("CUBED#.png"));
		stone=new Texture(Gdx.files.internal("stone.png"));
		ice=new Texture(Gdx.files.internal("ice.png"));
		bg5=new Texture(Gdx.files.internal("bg5.png"));
		
		pl1=new TextureRegion(pack,1,1,195,125);
		pl1.flip(false, true);
		pl2=new TextureRegion(pack,198,1,195,125);
		pl2.flip(false, true);
		pl3=new TextureRegion(pack,393,1,195,125);
		pl3.flip(false, true);
		pl4=new TextureRegion(pack,588,1,195,125);
		pl4.flip(false, true);
		wood=new TextureRegion(pack,783,68,121,58);
		collect=new Texture(Gdx.files.internal("collect.png"));
		gold=new Texture(Gdx.files.internal("gold.png"));
		many=new Texture(Gdx.files.internal("many.png"));
		can=new Texture(Gdx.files.internal("can.png"));
		star=new Texture(Gdx.files.internal("star.png"));
		
	    TextureRegion[]playerAni={pl1,pl2,pl3,pl3,pl2,pl1,pl1,pl2,pl3,pl3,pl2,pl1,pl1,pl2,pl3,pl3,pl2,pl1,pl1,pl2,pl3,pl4};
	    playerAnim=new Animation(0.01f,playerAni);
	    playerAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	    		
		logo=new Texture(Gdx.files.internal("logo.png"));
		logo.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		title=new Texture(Gdx.files.internal("title.png"));
		title.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		swipe=new Texture(Gdx.files.internal("swipe.png"));
		swipe.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		title2=new Texture(Gdx.files.internal("title2.png"));
		title2.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		gameover=new Texture(Gdx.files.internal("gameover.png"));
		gameover.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		retry=new Texture(Gdx.files.internal("retry.png"));
		retry.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		ready=new Texture(Gdx.files.internal("ready.png"));
		ready.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		highscore=new Texture(Gdx.files.internal("highscore.png"));
		highscore.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		currentscore=new Texture(Gdx.files.internal("currentScore.png"));
		currentscore.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		bg=new Texture(Gdx.files.internal("bg.png"));
		bg.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		bg2=new Texture(Gdx.files.internal("bg2.png"));
		bg2.setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		bg3=new Texture(Gdx.files.internal("bg4.png"));
		
		egg=new Texture(Gdx.files.internal("egg.png"));
		egg.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		 dead=Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
		 coin=Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
         flap = Gdx.audio.newSound(Gdx.files.internal("flap.wav"));
         theme =Gdx.audio.newMusic(Gdx.files.internal("theme.mp3"));
		 
		 font = new BitmapFont(Gdx.files.internal("whitetext.fnt"));
		 font.getData().setScale(1.0f, -1.0f);

		 shadow=new BitmapFont(Gdx.files.internal("shadow.fnt"));
		 shadow.getData().setScale(1.0f,-1.0f);
		 
		 prefs=Gdx.app.getPreferences("AnDi");
		 
		 if(!prefs.contains("highScore")){
			 prefs.putInteger("highScore",0);
		 }
		 if(!prefs.contains("highStar")){
			 prefs.putInteger("highScore",0);
		 }
		 
	}
	public static void setHighScore(int val){
		prefs.putInteger("highScore", val);
		prefs.flush();
	}
	public static int getHighScore(){
		return prefs.getInteger("highScore");
	}
	public static void setStarScore(int val){
		prefs.putInteger("highStar", val);
		prefs.flush();
	}
	public static int getStarScore(){
		return prefs.getInteger("highStar");
	}

	public static void dispose(){
		
		 logo.dispose();
		 title.dispose();
		 swipe.dispose();
		 title2.dispose();
		 gameover.dispose();
		 retry.dispose();
		 ready.dispose();
		 currentscore.dispose();
		 highscore.dispose();
		 
		 dead.dispose();
		 coin.dispose();
		 
			
	}
	}

