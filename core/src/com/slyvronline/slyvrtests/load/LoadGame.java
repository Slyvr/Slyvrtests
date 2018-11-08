package com.slyvronline.slyvrtests.load;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.core.objects.GameInstance;
import com.slyvronline.slyvrtests.Game;

public class LoadGame extends Thread{

	GameInstance gameInst;
	private boolean newgame;
	
	public LoadGame() {
		
	}
	
	public LoadGame(boolean newgame) {
		this.newgame=newgame;
	}
	
	public void run(){
		try{
			gameInst = new GameInstance();
			
			
			Game.getGlobal().setGame(gameInst);
		}
		catch(Exception ex){
			Game.writeLog("exception", ex);
			ex.printStackTrace();
		}
	}

}
