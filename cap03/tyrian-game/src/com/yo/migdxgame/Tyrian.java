package com.yo.migdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tyrian implements ApplicationListener {
	
	// constant useful for logging     
	public static final String LOG = Tyrian.class.getSimpleName();
	// a libgdx helper class that logs the current FPS each second 
	private FPSLogger fpsLogger; 
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	@Override
	public void create() {	
		Gdx.app.log( Tyrian.LOG, "Creating game" ); 
		fpsLogger = new FPSLogger(); 
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight(); 
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		Gdx.app.log( Tyrian.LOG, "Disposing game" ); 
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		
		// output the current FPS         
		fpsLogger.log(); 
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log( Tyrian.LOG, "Resizing game to: " + width + " x " + height ); 
	}

	@Override
	public void pause() {
		Gdx.app.log( Tyrian.LOG, "Pausing game" ); 
	}

	@Override
	public void resume() {
		Gdx.app.log( Tyrian.LOG, "Resuming game" ); 
	}
}
