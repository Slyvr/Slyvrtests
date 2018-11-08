package com.slyvronline.slyvrtests.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.slyvronline.core.objects.Font;
import com.slyvronline.slyvrtests.Game;

/**
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadFonts {

	public static void load(){
		ArrayList<Font> fonts = new ArrayList<Font>();
		
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/fonts/Roboto-Regular.ttf"));
//	    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
//	    parameter.size = 60;
//	    parameter.color = Color.WHITE;
//	    parameter.borderWidth = 2;
//	    BitmapFont fntRoboto60 = generator.generateFont(parameter);
//	    
//	    parameter.size = 30;
//	    BitmapFont fntRoboto30 = generator.generateFont(parameter);
//	    
//	    parameter.size = 20;
//	    BitmapFont fntRoboto20 = generator.generateFont(parameter);
//	    
//	    generator.dispose();
	    
		Game.getGlobal().setFonts(fonts);
	}
}
