package com.slyvronline.slyvrtests.objects.menus;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.core.objects.Ent;
import com.slyvronline.core.objects.Menu;
import com.slyvronline.slyvrtests.utils.GameConstants;
import com.slyvronline.slyvrtests.Game;

public class MainMenu extends Menu{
	
	public MainMenu(){
		load();
	}
	
	public void load(){
		this.setName("main");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		
		
		this.setEnts(ents);
	}
	
	public void update(float stateTime){
		updateKeyboardNavigation();
		updateKeyboardSelect();
	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnStart")){
//			Game.getGlobal().getSfxByName("papery").play();
//			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
//			Game.getGlobal().setGame(null);
		}
		if (selected.getName().equals("btnCredits")){
//			Game.getGlobal().getSfxByName("papery").play();
//			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("credits"));
		}
		if (selected.getName().equals("btnExit")){
			Gdx.app.exit();
		}
	}
	
	public void buttonDeselect(){
		if (Gdx.input.isKeyJustPressed(GameConstants.KEY_QUIT)){
			Gdx.app.exit();
		}
	}
}
