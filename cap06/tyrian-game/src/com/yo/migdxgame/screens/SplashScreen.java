/**
 * 
 */
package com.yo.migdxgame.screens;





import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
 
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * Pantalla de Inicio
 */
public class SplashScreen extends AbstractScreen {
	 private Texture splashTexture;
	 private Image splashImage;
	 
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
		 TextureRegion textureReg = new TextureRegion(splashTexture,512,301);
		 TextureRegionDrawable splashRegion = new TextureRegionDrawable(textureReg);
		 //aquí creamos el actor de la imagen de splah. El tamaño será definido cuando sea llamado el método
		 // resize().
		 splashImage = new Image( splashRegion, Scaling.stretch);
		 splashImage.setFillParent(true);
		 
		// esto es necesario para que el efecto fade-in funcione correctamene. Solo		 
		// hacce la imágen completamente transparente
		splashImage.getColor().a = 0f;
	 
		// configuro el efecto de fade-in/out de la imágen de splash
		// sequence indica que se harán de forma consecutiva.
	        splashImage.addAction( sequence( fadeIn( 0.75f ), delay( 2f ), fadeOut( 0.75f ),	 
	            new Action() {	 
	                @Override	 
	                public boolean act(	 
	                    float delta )	 
	                {	 
	                	// la última acción nos direcciona hacia la siguiente pantalla (menu)
	                    game.setScreen( new MenuScreen( game ) );
	                    return true;
	                } 
	            } ) );
	
	        // por último añadimos el actor al stage.
	        stage.addActor( splashImage );
	 }	 	 
	    
	    @Override public void dispose()	 
	    {
	        super.dispose();
	        splashTexture.dispose();
	    }
	 

}
