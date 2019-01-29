package com.faszallitok.harmadik.Screens.End;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyButton;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyLabel;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.Menu.MenuScreen;

public class EndStage extends MyStage {
    public EndStage(Batch batch, final MyGdxGame game, int score) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        MyLabel title = new MyLabel("Ütköztél!", game.getLabelStyle());
        title.getStyle().fontColor = Color.WHITE;
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2, getViewport().getWorldHeight() - title.getHeight() - 100);
        title.setAlignment(Align.center);
        title.setFontScale(2f);
        addActor(title);

        MyLabel txt = new MyLabel("Szerezett pontok száma: "+score, game.getLabelStyle());
        txt.setFontScale(0.8f);
        txt.setAlignment(Align.center);
        txt.setPosition(getViewport().getWorldWidth() / 2 - txt.getWidth() / 2, getViewport().getWorldHeight() / 2 - txt.getHeight() / 2 + 50);
        txt.setColor(Color.WHITE);
        addActor(txt);

        MyButton back = new MyButton("Menü", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 10);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
        addActor(back);

    }

    @Override
    public void init() {

    }
}
