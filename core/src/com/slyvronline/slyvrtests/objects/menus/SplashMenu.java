package com.slyvronline.slyvrtests.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.core.objects.Ent;
import com.slyvronline.core.objects.Menu;
import com.slyvronline.slyvrtests.Game;
import com.slyvronline.slyvrtests.utils.GameConstants;

public class SplashMenu extends Menu{

	
	public SplashMenu(){
		load();
	}
	
	public void load(){
		this.setName("splash");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		this.setEnts(ents);
	}
	
	private static long startMillis;
	
	public void update(float stateTime){
		
		if (startMillis==0) startMillis = System.currentTimeMillis();
		else{
			if (startMillis+GameConstants.SPLASH_MENU_WAIT<=System.currentTimeMillis()){
				Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
			}
		}
	}
}
