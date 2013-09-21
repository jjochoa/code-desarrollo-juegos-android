/**
 * 
 */
package com.yo.migdxgame.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.yo.migdxgame.Tyrian;

/**
 * @author sagoc dev
 * pantalla de r�cords
 */
public class HallOfFameScreen extends AbstractScreen {

	/**
	 * Constructor
	 * @param game Clase principal del juego
	 */
	public HallOfFameScreen( Tyrian game )
	{       
		super( game );
    }
	 
	@Override public void show() {
		super.show();
		Table table = super.getTable();
		table.add("HallOfFrameScreen").spaceBottom(20); 
		table.row();
	}
}
