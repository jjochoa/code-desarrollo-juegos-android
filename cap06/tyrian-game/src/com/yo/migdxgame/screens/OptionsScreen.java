/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * pantalla de opciones
 */
public class OptionsScreen extends AbstractScreen {

	/**
	 * Constructor
	 * @param game Clase principal del juego
	 */
	public OptionsScreen( Tyrian game )
	{       
		super( game );
    }
	
	@Override public void show() {
		super.show();
		Table table = super.getTable();
		table.add("OptionScreen").spaceBottom(20); 
		table.row();
	}
}
