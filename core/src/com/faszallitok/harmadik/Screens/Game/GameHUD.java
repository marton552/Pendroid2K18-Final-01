package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyLabel;
import com.faszallitok.harmadik.MyGdxGame;

public class GameHUD extends MyStage {
    MyLabel scoreLabel;

    public GameHUD(Batch batch, MyGdxGame game, final GameScreen screen) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        OneSpriteStaticActor menu = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_ICON));
        menu.setSize(menu.getWidth() / 20, menu.getHeight() / 20);
        menu.setPosition(getViewport().getWorldWidth() - menu.getWidth() - 10, getViewport().getWorldHeight() - menu.getHeight() - 10);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                screen.isPaused = true;
            }
        });
        addActor(menu);

        scoreLabel = new MyLabel("0", game.getLabelStyle());
        scoreLabel.setFontScale(2);
        addActor(scoreLabel);
        updateGameHud(0);
    }

    public void updateGameHud(int score) {
        scoreLabel.setText(""+score);
        scoreLabel.setPosition(getViewport().getWorldWidth() / 2 - scoreLabel.getWidth() / 2, getViewport().getWorldHeight() - scoreLabel.getHeight() - 5);
    }

    @Override
    public void init() {

    }
}
