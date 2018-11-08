package com.slyvronline.slyvrtests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.slyvronline.core.objects.Global;
import com.slyvronline.slyvrtests.load.LoadFonts;
import com.slyvronline.slyvrtests.load.LoadImgs;
import com.slyvronline.slyvrtests.load.LoadMenus;
import com.slyvronline.slyvrtests.load.LoadMusic;
import com.slyvronline.slyvrtests.load.LoadSfx;

public class Game extends ApplicationAdapter {
	private static Global global;
	
	@Override
	public void create() {
		global = new Global();
		global.setDefaultScreenWidth(Gdx.graphics.getWidth());
		global.setDefaultScreenHeight(Gdx.graphics.getHeight());
		OrthographicCamera cam = new OrthographicCamera(global.getDefaultScreenWidth(),global.getDefaultScreenHeight());
		cam.position.set(0,0,0);
		cam.update();
		global.setCamera(cam);
		
		DisplayMode displayMode = Gdx.graphics.getDisplayMode();
		
		if (displayMode != null)
			this.writeLog("info", "Monitor Resolution: "+displayMode.width+"x"+displayMode.height);
		
		this.writeLog("info", "Game Resolution: "+Gdx.graphics.getWidth()+"x"+Gdx.graphics.getHeight());
		
		LoadImgs.load();
		LoadFonts.load();
		LoadMenus.load();
		LoadSfx.load();
		LoadMusic.load();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = global.getBatch();
		SpriteBatch menuBatch = global.getMenuBatch();
		
		//UPDATES
		global.getCamera().update();
		global.getCurrentMenu().update(global.getStateTime());
		if (global.getGame() != null){
			global.getGame().update();
		}
		
		//RENDERS
		batch.setProjectionMatrix(global.getCamera().combined);
		batch.begin();
		if (global.getGame() != null){
			global.getGame().render(batch);
		}
		batch.end();
		
		menuBatch.begin();
		global.getCurrentMenu().render(menuBatch);
		menuBatch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public static Global getGlobal(){
		return global;
	}
	
	public static void writeLog(String type, Exception ex){
		writeLog(type, ex.getMessage());
	}
	public static void writeLog(String type, String text){
		Gdx.app.log(type, text);
	}
	public static void writeLog(String text){
		writeLog("Unknown",text);
	}
}
