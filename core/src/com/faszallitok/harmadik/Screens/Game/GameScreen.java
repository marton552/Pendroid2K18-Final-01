package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyScreen;
import com.faszallitok.harmadik.MyGdxGame;

public class GameScreen extends MyScreen {

    public boolean isPaused = false;
    GameMenu gameMenu;
    GameStage gameStage;
    public GameHUD gameHud;

    public GameScreen(MyGdxGame game) {
        super(game);

        gameMenu = new GameMenu(spriteBatch, game, this);
        gameHud = new GameHUD(spriteBatch, game, this);
        gameStage = new GameStage(spriteBatch, game, this);

        InputMultiplexer multiplexer = new InputMultiplexer();

        multiplexer.addProcessor(gameMenu);
        multiplexer.addProcessor(gameHud);

        multiplexer.addProcessor(gameStage);


        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.draw();
        gameHud.draw();

        if(isPaused) {
            gameMenu.draw();
            gameMenu.act(delta);
        }else {
            gameStage.act(delta);
            gameHud.act(delta);
        }
    }

    @Override
    public void init() {

    }
}
