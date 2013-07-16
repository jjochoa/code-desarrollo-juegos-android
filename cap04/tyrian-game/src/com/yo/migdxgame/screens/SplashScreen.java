/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * Pantalla de Inicio
 */
public class SplashScreen extends AbstractScreen {
	 private Texture splashTexture;
	 private TextureRegion splashTextureRegion;
	 
	 /**
	 * Constructor
	 * @param game Clase principal del juego
	 */
	 public SplashScreen(Tyrian game ) 
	 {
		 super( game );
	 }
		 
	 @Override public void show()
	 {
		 super.show();
	 
		 // cargar la imagen de splash y crear la region de textura
		 splashTexture = new Texture( "splash.png" );
		 // seleccionar Linear para mejorar el estiramiento
		 splashTexture.setFilter( TextureFilter.Linear, TextureFilter.Linear );
		 // en nuestro imagen atlas, nuestra imagen splash empieza en el (0,0) en la 
		 // esquina superior izquierda y tiene una dimensión de  512x301
		 splashTextureRegion = new TextureRegion( splashTexture, 0, 0, 512, 301 );
	 }
	 	 
	    @Override public void render( float delta )
	    {
	    	super.render( delta );
	    	// usamos el SpriteBatch para dibujar texturas 2D (está definido en la clase base: AbstractScreen
	    	batch.begin();
	    	// le indicamos al batch que dibuje la región que empieza en (0,0) en la esquina inferior izquierda
	    	// con el tamaño de la pantalla
	        batch.draw( splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
	        // el metodo end realiza el dibujado
	        batch.end();
	    }
	    
	    @Override public void dispose()	 
	    {
	        super.dispose();
	        splashTexture.dispose();
	    }
	 

}
