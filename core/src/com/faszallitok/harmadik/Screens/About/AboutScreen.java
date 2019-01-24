package com.faszallitok.harmadik.Screens.About;

import com.badlogic.gdx.Gdx;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.harmadik.MyGdxGame;

public class AboutScreen extends MyScreen {
    AboutStage aboutStage;

    public AboutScreen(MyGdxGame game) {
        super(game);

        aboutStage = new AboutStage(spriteBatch, game);
        Gdx.input.setInputProcessor(aboutStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        aboutStage.act(delta);
        aboutStage.draw();
    }

    @Override
    public void init() {

    }
}
