package com.slyvronline.slyvrtests.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.core.objects.Ent;
import com.slyvronline.core.objects.Menu;
import com.slyvronline.slyvrtests.Game;

public class CreditsMenu extends Menu{

	public CreditsMenu(){
		load();
	}
	
	public void load(){
		this.setName("credits");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		updateKeyboardNavigation();
		updateKeyboardSelect();
	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnBack")){
//			Game.getGlobal().getSfxByName("papery").play();
//			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
		}
	}
	
	public void buttonDeselect(){
//		Game.getGlobal().getSfxByName("papery").play();
//		Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("main"));
	}
}
