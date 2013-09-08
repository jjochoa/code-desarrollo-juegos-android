package com.yo.migdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;


/**
 * Clase principal de la aplciación.
 * Hereda de Game para poder cambiar de pantalla
 * 
 * @author sagocr dev
 * 
 */
public class Tyrian extends Game {	
	// constante para logging     
	public static final String LOG = Tyrian.class.getSimpleName();
	// helper class que muestra en el log el FPS actual cada segundo
	private FPSLogger fpsLogger; 
	
	/**
	 * Constructor: Arranca el juego
	 */
	@Override public void create() {	
		Gdx.app.log( Tyrian.LOG, "Creating game" ); 
		fpsLogger = new FPSLogger(); 
		
	}

	/**
	 * Destructor: elimina los objetos que el recolector de basura de Java no libera.
	 */
	@Override public void dispose() {
		super.dispose();
		Gdx.app.log( Tyrian.LOG, "Disposing game" ); 
		
		//otros dispose
	}

	/**
	 * Renderiza la pantalla
	 */
	@Override public void render() {		
		super.render();
		
		// muestro en el log los FPS
		fpsLogger.log();
	}

	/**
	 * Redimensiona la pantalla
	 * @param width Ancho nuevo de la pantalla
	 * @param height Alto nuevo de la pantalla
	 */
	@Override public void resize(int width, int height) {
		super.resize( width, height );
		Gdx.app.log( Tyrian.LOG, "Resizing game to: " + width + " x " + height ); 
		
		// muestra la pantalla de splash cuando el juego se redimensiona por primera vez
		// asi evitamos llamadas repetidas a resize
 
        if( getScreen() == null ) {            
        		// he de poner la ruta entera porque existe ya una clase SplashScreen
                setScreen( new com.yo.migdxgame.screens.SplashScreen( this ) );          
        }
        

	}

	/**
	 * Detiene el juego, bien porque se esta cerrando o porque otra aplicación toma el control
	 */
	@Override public void pause() {
		super.pause();
		Gdx.app.log( Tyrian.LOG, "Pausing game" ); 
	}

	/**
	 * Reanuda el juego pausado
	 */
	@Override public void resume() {
		super.resume();
		Gdx.app.log( Tyrian.LOG, "Resuming game" ); 
	}
	
	/**
	 * Activa una pantalla
	 * @param screen pantalla a activar.
	 */
	@Override public void setScreen( Screen screen ) 
    { 
        super.setScreen( screen ); 
        Gdx.app.log( Tyrian.LOG, "Setting screen: " + screen.getClass().getSimpleName() ); 
    }
 

}
