package com.faszallitok.harmadik.Screens.Skin;

import com.badlogic.gdx.Gdx;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.Game.GameStage;

public class SkinScreen extends MyScreen {
    SkinStage skinStage;

    public SkinScreen(MyGdxGame game) {
        super(game);

        skinStage = new SkinStage(spriteBatch, game);
        Gdx.input.setInputProcessor(skinStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        skinStage.act(delta);
        skinStage.draw();
    }

    @Override
    public void init() {

    }
}
