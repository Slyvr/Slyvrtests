package com.slyvronline.slyvrtests.objects.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.core.objects.Ent;
import com.slyvronline.core.objects.Menu;
import com.slyvronline.slyvrtests.utils.GameConstants;
import com.slyvronline.slyvrtests.Game;

public class GameMenu extends Menu{

	
	public GameMenu(){
		load();
	}
	
	public void load(){
		this.setName("game");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		
		
		this.setEnts(ents);
	}
	
	public void update (float stateTime){
		
	}
	
}
