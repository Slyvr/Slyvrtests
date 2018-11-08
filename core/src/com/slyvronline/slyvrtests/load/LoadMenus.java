package com.slyvronline.slyvrtests.load;

import java.util.ArrayList;

import com.slyvronline.core.objects.Menu;
import com.slyvronline.slyvrtests.objects.menus.MainMenu;
import com.slyvronline.slyvrtests.objects.menus.SplashMenu;
import com.slyvronline.slyvrtests.Game;


/**
 * This class loads the in game menu screens and populates them with 
 * all the entities and where they're lcoated
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadMenus {

	public static void load(){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new SplashMenu());
		menus.add(new MainMenu());
		
		Game.getGlobal().setMenus(menus);
		Game.getGlobal().setCurrentMenu(menus.get(0));
	}
}
