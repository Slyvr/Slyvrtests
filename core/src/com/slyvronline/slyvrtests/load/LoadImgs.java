package com.slyvronline.slyvrtests.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.slyvronline.core.objects.Img;
import com.slyvronline.slyvrtests.Game;

/**
 * This class creates new Img classes to an arraylist containing a searchable name and the image data
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadImgs {

	static ArrayList<Img> imgs;
	
	public static void load(){
		imgs = new ArrayList<Img>();
		
		//Set run configuration's working directory to core/assets
		FileHandle fh = Gdx.files.local("data/");
		if (!fh.isDirectory()){
			Game.writeLog("error", "Unable to find asset data directory.  If running via code, try setting working directory of run config to core/assets");
		}
		loadImgs(fh);
		
		Game.getGlobal().setImgs(imgs);
	}
	
	public static void loadImgs(FileHandle fh){
		for(FileHandle f : fh.list()){
			if (!f.isDirectory()){
				if (f.name().contains("png")){
					imgs.add(new Img(new Texture(Gdx.files.internal(f.path())),f.name().replace(".png", "")));
				}
			}
			else{
				loadImgs(f);
			}
		}
	}
}
