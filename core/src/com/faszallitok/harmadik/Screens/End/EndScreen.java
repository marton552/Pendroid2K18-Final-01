package com.faszallitok.harmadik.Screens.End;

import com.badlogic.gdx.Gdx;
import com.faszallitok.harmadik.MusicPlayer;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.harmadik.MyGdxGame;

public class EndScreen extends MyScreen {
    EndStage endStage;

    public EndScreen(MyGdxGame game, int score) {
        super(game);
        MusicPlayer.startMenuMusic();

        endStage = new EndStage(spriteBatch, game, score);
        Gdx.input.setInputProcessor(endStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        endStage.act(delta);
        endStage.draw();
    }

    @Override
    public void init() {

    }
}
