/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * Clase base para la mayoría de las pantallas
 */
public abstract class AbstractScreen implements Screen {
	protected final Tyrian game;	 
    protected BitmapFont font; 
    //protected final SpriteBatch batch; 
    protected Stage stage;
    protected Skin skin;
    protected Table table;
    
    /**
	 * Constructor
	 * @param game Clase principal del juego
	 */
    public AbstractScreen( Tyrian game )     
    {     
    	Gdx.app.log( Tyrian.LOG, "Create screen: ");
        this.game = game;                  
        //definimos el stage con un viewport de tamaño 0x0px y que mantenga la relación de aspecto
        this.stage = new Stage( 0, 0, true );
        // que sea stage quien reciba los eventos de input.
     	Gdx.input.setInputProcessor(this.stage);
    }
    
    
    // carga Lazily de objetos
    public BitmapFont getFont()
    { 
        if( font == null ) { 
            font = new BitmapFont(); 
        } 
        return font; 
    }
 
    protected Skin getSkin()    
    { 
        if( skin == null ) { 
            FileHandle skinFile = Gdx.files.internal( "skin/uiskin.json" ); 
            skin = new Skin(skinFile); 
        } 
        return skin; 
    }
 
    protected Table getTable() 
    { 
        if( table == null ) { 
            table = new Table( getSkin() ); 
            table.setFillParent( true ); 
            table.debug(); 
            
            stage.addActor( table ); 
        } 
        return table; 
    }
     
    /** 
	 * @see com.badlogic.gdx.Screen#show()
	 */
	@Override public void show() {
		Gdx.app.log( Tyrian.LOG, "Showing screen: " + getName() );
		
		
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
		if (font != null)
			font.dispose();
        //batch.dispose();
	}

	/**
	 * para recuperar el nombre de la pantalla
	 * @return
	 */
	protected String getName() {
        return getClass().getSimpleName();
    }
 

}
