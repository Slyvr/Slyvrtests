package com.slyvronline.slyvrtests.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.slyvronline.core.objects.Sfx;
import com.slyvronline.slyvrtests.Game;

public class LoadSfx {

	public static void load(){
		ArrayList<Sfx> sfx = new ArrayList<Sfx>();
		
//		Sfx paperflip = new Sfx();
//		paperflip.setName("paperflip");
//		paperflip.setSound(Gdx.audio.newSound(Gdx.files.internal("data/sfx/paperflip.wav")));
//		paperflip.setPitch(1.2f);
//		paperflip.setPan(1);
//		paperflip.setVolume(1.5f);
//		paperflip.setLoop(false);
//		sfx.add(paperflip);
		
		Game.getGlobal().setSfx(sfx);
	}
}
