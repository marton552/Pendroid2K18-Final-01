package com.faszallitok.harmadik.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.faszallitok.harmadik.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "Public");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 576;
		config.height = 1024;
		//config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
