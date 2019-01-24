package com.faszallitok.harmadik.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.harmadik.MyGdxGame;

public class MenuScreen extends MyScreen {
    public boolean isPaused = false;
    MenuStage menuStage;

    public MenuScreen(MyGdxGame game) {
        super(game);
        menuStage = new MenuStage(spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void init() {

    }
}
