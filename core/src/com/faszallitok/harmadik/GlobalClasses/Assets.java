package com.faszallitok.harmadik.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;

	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "alegreyaregular.otf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.borderColor = Color.WHITE;
		fontParameter.fontParameters.borderWidth = 1;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}

	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	//Atlasok
	public static final AssetDescriptor<TextureAtlas> EXPLOSION_ATLAS = new AssetDescriptor<TextureAtlas>("atlasok/explosion.atlas", TextureAtlas.class);

	//Menu
	public static final AssetDescriptor<Texture> MENU_BG = new AssetDescriptor<Texture>("bg.png", Texture.class);
    public static final AssetDescriptor<Texture> MARTIN = new AssetDescriptor<Texture>("martin.png", Texture.class);

	public static final AssetDescriptor<Texture> END = new AssetDescriptor<Texture>("end.png", Texture.class);
	public static final AssetDescriptor<Texture> MENU_ICON = new AssetDescriptor<Texture>("menu-icon.png", Texture.class);

	//garazs
	public static final AssetDescriptor<Texture> GAR_BG = new AssetDescriptor<Texture>("Textures/garazs_bg.png", Texture.class);
	public static final AssetDescriptor<Texture> GAR_TOP = new AssetDescriptor<Texture>("Textures/garazs.png", Texture.class);

	//hand
	public static final AssetDescriptor<Texture> HAND = new AssetDescriptor<Texture>("Textures/hand.png", Texture.class);

	//Roads
	public static final AssetDescriptor<Texture> ROAD_STRAIGHT = new AssetDescriptor<Texture>("roads/straight.png", Texture.class);
	public static final AssetDescriptor<Texture> ROAD_RIVER = new AssetDescriptor<Texture>("roads/river.png", Texture.class);
	public static final AssetDescriptor<Texture> ROAD_CROSS = new AssetDescriptor<Texture>("roads/cross.png", Texture.class);
	public static final AssetDescriptor<Texture> ROAD_CIRCLE = new AssetDescriptor<Texture>("roads/circle.png", Texture.class);
	public static final AssetDescriptor<Texture> ROAD_LEFT = new AssetDescriptor<Texture>("roads/left.png", Texture.class);
	public static final AssetDescriptor<Texture> ROAD_RIGHT = new AssetDescriptor<Texture>("roads/right.png", Texture.class);

	//Car
	public static final AssetDescriptor<Texture> CAR_1 = new AssetDescriptor<Texture>("cars/car1.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_2 = new AssetDescriptor<Texture>("cars/car2.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_3 = new AssetDescriptor<Texture>("cars/car3.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_4 = new AssetDescriptor<Texture>("cars/car4.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_5 = new AssetDescriptor<Texture>("cars/car5.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_6 = new AssetDescriptor<Texture>("cars/car6.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_7 = new AssetDescriptor<Texture>("cars/car7.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_8 = new AssetDescriptor<Texture>("cars/car8.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_9 = new AssetDescriptor<Texture>("cars/car9.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_10 = new AssetDescriptor<Texture>("cars/car10.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_11 = new AssetDescriptor<Texture>("cars/car11.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_12 = new AssetDescriptor<Texture>("cars/car12.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_13 = new AssetDescriptor<Texture>("cars/car13.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_14 = new AssetDescriptor<Texture>("cars/car14.png", Texture.class);
	public static final AssetDescriptor<Texture> CAR_15 = new AssetDescriptor<Texture>("cars/car15.png", Texture.class);


	//Button
	public static final AssetDescriptor<Texture> BTN_BACK = new AssetDescriptor<Texture>("ui_textures/btn_back.png", Texture.class);
	public static final AssetDescriptor<Texture> BTN_HOVER = new AssetDescriptor<Texture>("ui_textures/btn_hover.png", Texture.class);

	public static final AssetDescriptor<Texture> WHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/white.png", Texture.class);
	public static final AssetDescriptor<Texture> FULLWHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/fullwhite.png", Texture.class);

	//Slider
	public static final AssetDescriptor<Texture> SLIDER_BG = new AssetDescriptor<Texture>("ui_textures/slider.png", Texture.class);
	public static final AssetDescriptor<Texture> SLIDER_KNOB = new AssetDescriptor<Texture>("ui_textures/sliderknob.png", Texture.class);
	public static final AssetDescriptor<Texture> SLIDER_KNOBH = new AssetDescriptor<Texture>("ui_textures/sliderknob2.png", Texture.class);

	//Etc UI
	public static final AssetDescriptor<Texture> DARK = new AssetDescriptor<Texture>("ui_textures/dark.png", Texture.class);

	//Sounds

	//Music
	public static final AssetDescriptor<Music> MENU_MUSIC = new AssetDescriptor<Music>("zene/1.ogg", Music.class);



	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(EXPLOSION_ATLAS);

		manager.load(MENU_BG);
		manager.load(MARTIN);
		manager.load(END);

		manager.load(GAR_BG);
		manager.load(GAR_TOP);

		manager.load(HAND);
		manager.load(ROAD_STRAIGHT);
		manager.load(ROAD_RIVER);
		manager.load(ROAD_CROSS);
		manager.load(ROAD_CIRCLE);
		manager.load(ROAD_LEFT);
		manager.load(ROAD_RIGHT);

		manager.load(CAR_1);
		manager.load(CAR_2);
		manager.load(CAR_3);
		manager.load(CAR_4);
		manager.load(CAR_5);
		manager.load(CAR_6);
		manager.load(CAR_7);
		manager.load(CAR_8);
		manager.load(CAR_9);
		manager.load(CAR_10);
		manager.load(CAR_11);
		manager.load(CAR_12);
		manager.load(CAR_13);
		manager.load(CAR_14);
		manager.load(CAR_15);

		manager.load(MENU_ICON);
		manager.load(BTN_BACK);
		manager.load(BTN_HOVER);

		manager.load(WHITE_TEXTURE);
		manager.load(FULLWHITE_TEXTURE);

		manager.load(SLIDER_BG);
		manager.load(SLIDER_KNOB);
		manager.load(SLIDER_KNOBH);

		manager.load(DARK);

		manager.load(MENU_MUSIC);

		manager.load(ALEGREYAREGULAR_FONT);

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
