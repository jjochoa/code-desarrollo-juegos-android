/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yo.migdxgame.Tyrian;

/**
 * @author sgomezc
 * Clase base para la mayoría de las pantallas
 */
public abstract class AbstractScreen implements Screen {
	protected final Tyrian game;	 
    protected final BitmapFont font; 
    protected final SpriteBatch batch; 

    /**
	 * Constructor
	 * @param game Clase principal del juego
	 */
    public AbstractScreen( Tyrian game )     
    {     
        this.game = game;     
        this.font = new BitmapFont();     
        this.batch = new SpriteBatch();     
    }
    
	/**
	 * @see  com.badlogic.gdx.Screen#render(float)
	 */
	@Override public void render(float delta) {
		// Pinta la pantalla en color negro		 
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f ); 
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
	}

	/**
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override public void resize(int width, int height) {
	}

	/** 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override public void show() {
	}

	/**
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override public void hide() {		
	}

	/**
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override public void pause() {
	}

	/**
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override public void resume() {
	}

	/**
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override public void dispose() {
		font.dispose();
        batch.dispose();
	}

}
