/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * Pantalla de menú principal
 */
public class MenuScreen extends AbstractScreen {

	/**
	 * Constructor
	 * @param game Clase principal del juego
	 */
	public MenuScreen( Tyrian game )
	{       
		super( game );
    }
	
	@Override public void show() {
		super.show();
		Table table = super.getTable();
		table.add("Bienvenido a Tyrian para Android.").spaceBottom(20); 
		table.row();
		
		// registrar el botón de StartGame		 
        TextButton startGameButton = new TextButton( "Start game", getSkin() );
        startGameButton.addListener(new InputListener() {
            public boolean touchDown ( InputEvent  event, float x, float y, int pointer, int button ) 
            {              	
                game.setScreen( new StartGameScreen( game ) );
                return false;
            } 
        } ); 
        table.add( startGameButton ).size( 300, 60 ).uniform().spaceBottom( 10 ); 
        table.row(); 
 
        // registrar el botón de "options" 
        TextButton optionsButton = new TextButton( "Options", getSkin() ); 
        optionsButton.addListener( new InputListener() { 
            public boolean touchDown( InputEvent event, float x, float y, int pointer, int button ) 
            { 
                game.setScreen( new OptionsScreen( game ) ); 
                return false;
            } 
        } ); 
        table.add( optionsButton ).uniform().fill().spaceBottom( 10 );
        table.row();
 
        // registrar el botón de "hallOfFameButton" 
        TextButton hallOfFameButton = new TextButton( "Hall of Fame", getSkin() ); 
        hallOfFameButton.addListener( new InputListener() { 
            public boolean touchDown( InputEvent event, float x, float y, int pointer, int button ) 
            { 
                game.setScreen( new HallOfFameScreen( game ) );
                return false;
            } 
        } ); 
        table.add( hallOfFameButton).uniform().fill();
	}
}
