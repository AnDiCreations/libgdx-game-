package com.AnDi.GameWorld;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.AnDi.Common.AssetLoader;
import com.AnDi.GameActor.Background;
import com.AnDi.GameActor.Cube;
import com.AnDi.GameActor.FinalBar;
import com.AnDi.GameActor.Pipe;
import com.AnDi.GameActor.PipeDown;
import com.AnDi.GameActor.ScrollHandler;
import com.AnDi.GameActor.ScrollHandlerUpDown;
import com.AnDi.TweenAccessor.Value;
import com.AnDi.TweenAccessor.ValueAccessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
       
	private GameWorld myWorld;
	private OrthographicCamera cam;
	
	private SpriteBatch batch;
	private ShapeRenderer shapeRender;
	
	private int midPointY;
	private int gameWidth;
	
	private Cube cube;
	private FinalBar bar;
	private Pipe pipe1,pipe2,pipe3;
	private PipeDown pipe6,pipe7;
	private ScrollHandler scroller;
	private ScrollHandlerUpDown scroller2;
	private Background bg;
	
	private TweenManager manager;
	private Value alpha = new Value();
	private Color transitionColor;

	
	public GameRenderer(GameWorld world,int gameWidth,int midPointY){
		setMyWorld(world);
		
		this.setGameWidth(gameWidth);
		this.setMidPointY(midPointY);
		
		cam=new OrthographicCamera();
		cam.setToOrtho(true,gameWidth,408);
		
		batch=new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		shapeRender=new ShapeRenderer();
		shapeRender.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		initAssets();
		
		transitionColor = new Color();
		prepareTransition(255, 255, 255, .5f);
	}

	private void initAssets() {

		
	}

	private void initGameObjects() {
		
	        cube= myWorld.getCube();
	        scroller=myWorld.getScroller();
		    scroller2=myWorld.getScroller2();
		    pipe1=scroller.getPipe1();
		    pipe2=scroller.getPipe2();
		    pipe3=scroller.getPipe3();
		    pipe6=scroller2.getPipe6();
		    pipe7=scroller2.getPipe7();
		    bar=myWorld.getBar();
		    bg=myWorld.getBg();
		    
	}
	
    public void render(float delta,float runTime){
		
		Gdx.gl.glClearColor(1,1,1,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(myWorld.isRunning()){
	
		batch.begin();
		batch.draw(AssetLoader.bg,bg.getX(),bg.getY()-50,gameWidth,600);
		batch.draw(AssetLoader.egg,bar.getFinalBar().getX(),bar.getFinalBar().getY(),bar.getFinalBar().getWidth()+4,bar.getFinalBar().getHeight());
		
		batch.draw(AssetLoader.wood,pipe1.getBarUp().getX(),pipe1.getBarUp().getY(),pipe1.getBarUp().getWidth(),pipe1.getBarUp().getHeight());
		batch.draw(AssetLoader.wood,pipe2.getBarDown().getX(),pipe2.getBarDown().getY(),pipe2.getBarDown().getWidth(),pipe2.getBarDown().getHeight());
		batch.draw(AssetLoader.wood,pipe3.getBarSide().getX(),pipe3.getBarSide().getY(),pipe3.getBarSide().getWidth(),pipe1.getBarSide().getHeight());
		batch.draw(AssetLoader.wood,pipe6.getBarUp2().getX(),pipe6.getBarUp2().getY(),pipe6.getBarUp2().getWidth(),pipe6.getBarUp2().getHeight());
		batch.draw(AssetLoader.wood,pipe7.getBarDown2().getX(),pipe7.getBarDown2().getY(),pipe7.getBarDown2().getWidth(),pipe7.getBarDown2().getHeight());
		batch.end();

		
		if(bar.collides(cube)){
			batch.begin();
			batch.draw(AssetLoader.win,cube.getX(),cube.getY(),cube.getWidth(),cube.getHeight());
			batch.end();
		}else{
			batch.begin();
			batch.draw(AssetLoader.playerAnim.getKeyFrame(runTime),cube.getX(),cube.getY(),cube.getWidth(),cube.getHeight());
			batch.end();
		AssetLoader.theme.pause();
		}
		
		 //Score
		batch.begin();
		String score=myWorld.getScore()+"";
		AssetLoader.shadow.draw(batch,""+myWorld.getScore(),20-(3*score.length()),midPointY-180);
		AssetLoader.font.draw(batch,""+myWorld.getScore(),20-(3*score.length()-1),midPointY-179);
		batch.end();
		
	
		}else if(myWorld.isReady()){
			
			    batch.begin();
			    batch.draw(AssetLoader.bg,bg.getX(),bg.getY()-50,gameWidth,600);
			    batch.draw(AssetLoader.egg,bar.getFinalBar().getX(),bar.getFinalBar().getY(),bar.getFinalBar().getWidth()+4,bar.getFinalBar().getHeight());
				
				batch.draw(AssetLoader.wood,pipe1.getBarUp().getX(),pipe1.getBarUp().getY(),pipe1.getBarUp().getWidth(),pipe1.getBarUp().getHeight());
				batch.draw(AssetLoader.wood,pipe2.getBarDown().getX(),pipe2.getBarDown().getY(),pipe2.getBarDown().getWidth(),pipe2.getBarDown().getHeight());
				batch.draw(AssetLoader.wood,pipe3.getBarSide().getX(),pipe3.getBarSide().getY(),pipe3.getBarSide().getWidth(),pipe1.getBarSide().getHeight());
				batch.draw(AssetLoader.wood,pipe6.getBarUp2().getX(),pipe6.getBarUp2().getY(),pipe6.getBarUp2().getWidth(),pipe6.getBarUp2().getHeight());
				batch.draw(AssetLoader.wood,pipe7.getBarDown2().getX(),pipe7.getBarDown2().getY(),pipe7.getBarDown2().getWidth(),pipe7.getBarDown2().getHeight());
				
			    batch.draw(AssetLoader.ready,gameWidth/6,midPointY-150,200,100);
			    
			   
				batch.end();
				AssetLoader.theme.pause();
			
		}else if(myWorld.isMenu()){
					
			
			        batch.begin();
			        batch.draw(AssetLoader.bg,bg.getX(),bg.getY()-50,gameWidth,600);
			    	batch.draw(AssetLoader.wood,pipe1.getBarUp().getX(),pipe1.getBarUp().getY(),pipe1.getBarUp().getWidth(),pipe1.getBarUp().getHeight());
					batch.draw(AssetLoader.wood,pipe2.getBarDown().getX(),pipe2.getBarDown().getY(),pipe2.getBarDown().getWidth(),pipe2.getBarDown().getHeight());
					batch.draw(AssetLoader.wood,pipe3.getBarSide().getX(),pipe3.getBarSide().getY(),pipe3.getBarSide().getWidth(),pipe1.getBarSide().getHeight());
					batch.draw(AssetLoader.wood,pipe6.getBarUp2().getX(),pipe6.getBarUp2().getY(),pipe6.getBarUp2().getWidth(),pipe6.getBarUp2().getHeight());
					batch.draw(AssetLoader.wood,pipe7.getBarDown2().getX(),pipe7.getBarDown2().getY(),pipe7.getBarDown2().getWidth(),pipe7.getBarDown2().getHeight());
				    batch.draw(AssetLoader.playerAnim.getKeyFrame(runTime),gameWidth/2-25,midPointY,cube.getWidth(),cube.getHeight());
					batch.draw(AssetLoader.title2,gameWidth/6,midPointY-150,200,100);
					batch.draw(AssetLoader.swipe, gameWidth/3,midPointY+66,100,50);
					batch.end();
					AssetLoader.theme.play();
			       
				}
		  else if(myWorld.isGameOver()){
			
		
		    batch.begin();
		    batch.draw(AssetLoader.bg,bg.getX(),bg.getY()-50,gameWidth,600);
			batch.draw(AssetLoader.wood,pipe1.getBarUp().getX(),pipe1.getBarUp().getY(),pipe1.getBarUp().getWidth(),pipe1.getBarUp().getHeight());
			batch.draw(AssetLoader.wood,pipe2.getBarDown().getX(),pipe2.getBarDown().getY(),pipe2.getBarDown().getWidth(),pipe2.getBarDown().getHeight());
			batch.draw(AssetLoader.wood,pipe3.getBarSide().getX(),pipe3.getBarSide().getY(),pipe3.getBarSide().getWidth(),pipe3.getBarSide().getHeight());
			batch.draw(AssetLoader.wood,pipe6.getBarUp2().getX(),pipe6.getBarUp2().getY(),pipe6.getBarUp2().getWidth(),pipe6.getBarUp2().getHeight());
			batch.draw(AssetLoader.wood,pipe7.getBarDown2().getX(),pipe7.getBarDown2().getY(),pipe7.getBarDown2().getWidth(),pipe7.getBarDown2().getHeight());
			
			batch.draw(AssetLoader.gameover,gameWidth/4,midPointY-180,150,75);
			
			@SuppressWarnings("unused")
			String score=myWorld.getScore()+"";
			AssetLoader.shadow.draw(batch,""+myWorld.getScore(),gameWidth/2-30,midPointY+1);
			AssetLoader.font.draw(batch,""+myWorld.getScore(),gameWidth/2-29,midPointY);
			batch.draw(AssetLoader.currentscore,gameWidth/3,midPointY-55,100,50);
			
			@SuppressWarnings("unused")
			int length2 = ("" + AssetLoader.getHighScore()).length();
			AssetLoader.shadow.draw(batch, "" + AssetLoader.getHighScore(),
					gameWidth/2-30, midPointY+120);
			
			AssetLoader.font.draw(batch, "" + AssetLoader.getHighScore(),
					gameWidth/2-29, midPointY+119);
            batch.draw(AssetLoader.highscore,gameWidth/3,midPointY+55,100,50);

			batch.draw(AssetLoader.retry,gameWidth/3,midPointY-100,100,50);
			
			batch.end();
			AssetLoader.theme.play();
		   }

			
			if(bar.collides(cube)){
				batch.begin();
				batch.draw(AssetLoader.win,cube.getX(),cube.getY(),cube.getWidth(),cube.getHeight());
				batch.end();
			}else{
				batch.begin();
				batch.draw(AssetLoader.playerAnim.getKeyFrame(runTime),cube.getX(),cube.getY(),cube.getWidth(),cube.getHeight());
				batch.end();
			
			}
			
			 //Score
			batch.begin();
			String score=myWorld.getScore()+"";
			AssetLoader.shadow.draw(batch,""+myWorld.getScore(),20-(3*score.length()),midPointY-180);
			AssetLoader.font.draw(batch,""+myWorld.getScore(),20-(3*score.length()-1),midPointY-179);
			batch.end();
				
		    drawTransition(delta);
		
    }
    public void prepareTransition(int r, int g, int b, float duration) {
    	
		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
		alpha.setValue(1);
		Tween.registerAccessor(Value.class, new ValueAccessor());
		manager = new TweenManager();
		Tween.to(alpha, -1, duration).target(0)
				.ease(TweenEquations.easeOutQuad).start(manager);
	}

	private void drawTransition(float delta) {
		
		if (alpha.getValue() > 0) {
			manager.update(delta);
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			shapeRender.begin(ShapeType.Filled);
			shapeRender.setColor(transitionColor.r, transitionColor.g,
					transitionColor.b, alpha.getValue());
			shapeRender.rect(0, 0, gameWidth, 600);
			shapeRender.end();
			Gdx.gl.glDisable(GL20.GL_BLEND);

		}
	}

	public int getGameWidth() {
		return gameWidth;
	}

	public void setGameWidth(int gameWidth) {
		this.gameWidth = gameWidth;
	}

	public int getMidPointY() {
		return midPointY;
	}

	public void setMidPointY(int midPointY) {
		this.midPointY = midPointY;
	}

	public GameWorld getMyWorld() {
		return myWorld;
	}

	public void setMyWorld(GameWorld myWorld) {
		this.myWorld = myWorld;
	}

	public OrthographicCamera getCam() {
		return cam;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}
}
