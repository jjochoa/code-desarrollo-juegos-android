/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * Clase base para la mayoría de las pantallas
 */
public abstract class AbstractScreen implements Screen {
	protected final Tyrian game;	 
    protected final BitmapFont font; 
    protected final SpriteBatch batch; 
    protected final Stage stage;
    
    /**
	 * Constructor
	 * @param game Clase principal del juego
	 */
    public AbstractScreen( Tyrian game )     
    {     
        this.game = game;     
        this.font = new BitmapFont();     
        this.batch = new SpriteBatch();             
        //definimos el stage con un viewport de tamaño 0x0px y que mantenga la relación de aspecto
        this.stage = new Stage( 0, 0, true ); 
    }
    
	/**
	 * @see  com.badlogic.gdx.Screen#render(float)
	 */
	@Override public void render(float delta) {
		// (1) procesar la lógica del juego
		
		//updatar los actores
		stage.act(delta);
		
		// (2) dibujamos el resultado
		// Pinta la pantalla en color negro		 
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f ); 
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
        //dibujamos los actores.
        stage.draw();
	}

	/**
	 * @see com.badlogic.gdx.Screen#resize(int, int)
	 */
	@Override public void resize(int width, int height) {
		Gdx.app.log( Tyrian.LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height );

		// redimensionamos viewport del stage
		// también se llama a este método al crear la pantalla.
        stage.setViewport( width, height, true );
	}

	/** 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override public void show() {
		Gdx.app.log( Tyrian.LOG, "Showing screen: " + getName() );
	}

	/**
	 * @see com.badlogic.gdx.Screen#hide()
	 */
	@Override public void hide() {
        Gdx.app.log( Tyrian.LOG, "Hiding screen: " + getName() );
        
        //dispose de la pantalla cuando dejamos la pantallla.
        //Este método no se llama automáticamente por el framework.
        dispose();
	}

	/**
	 * @see com.badlogic.gdx.Screen#pause()
	 */
	@Override public void pause() {
		Gdx.app.log( Tyrian.LOG, "Pausing screen: " + getName() );
	}

	/**
	 * @see com.badlogic.gdx.Screen#resume()
	 */
	@Override public void resume() {
        Gdx.app.log( Tyrian.LOG, "Resuming screen: " + getName() ); 
	}

	/**
	 * @see com.badlogic.gdx.Screen#dispose()
	 */
	@Override public void dispose() {
		Gdx.app.log( Tyrian.LOG, "Disposing screen: " + getName() );
		 
		stage.dispose();
		font.dispose();
        batch.dispose();
	}

	/**
	 * para recuperar el nombre de la pantalla
	 * @return
	 */
	protected String getName() {
        return getClass().getSimpleName();
    }
 

}
