package com.slyvronline.slyvrtests.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.slyvronline.slyvrtests.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Slyvrtests";
		
		//Set fullscreen full monitor resolution - game developed assuming 1920 x 1080
/*		cfg.fullscreen = true;
		cfg.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
        cfg.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;*/
		
		//Set 'borderless' fullscreen
/*		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		cfg.fullscreen = false;
		cfg.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
        cfg.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;*/
		
		//Set windowed mode - half resolution
        cfg.fullscreen = false;
		cfg.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width/2;
        cfg.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height/2;
		
		Game game = new Game();
		try{
			new LwjglApplication(game, cfg);
		}
		catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
}
