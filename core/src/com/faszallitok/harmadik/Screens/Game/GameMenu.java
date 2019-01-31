package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyButton;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyLabel;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.Menu.MenuScreen;

public class GameMenu extends MyStage {
    MyLabel title;
    MyButton quit;
    MyButton back;

    public GameMenu(Batch batch, MyGdxGame game, final GameScreen screen) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        Pixmap darkPixmap = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        darkPixmap.setColor(new Color(0, 0, 0, 0.6f));
        darkPixmap.fill();
        OneSpriteStaticActor bg = new OneSpriteStaticActor(new Texture(darkPixmap));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        bg.setPosition(0, 0);
        addActor(bg);

        title = new MyLabel("Menü", game.getLabelStyle());
        title.setAlignment(Align.center);
        title.setFontScale(1.6f);
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2, getViewport().getWorldHeight() / 2 + 50);

        addActor(title);

        quit = new MyButton("Kilépés a menübe", game.getButtonStyle());
        quit.setPosition(getViewport().getWorldWidth() / 2 - quit.getWidth() / 2, getViewport().getWorldHeight() / 2 - 50);
        quit.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(screen.isPaused) getGame().setScreen(new MenuScreen(getGame()));
            }
        });
        addActor(quit);

        back = new MyButton("Vissza", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, getViewport().getWorldHeight() / 2 - 110);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(screen.isPaused) screen.isPaused = false;
            }
        });
        addActor(back);

    }

    @Override
    public void init() {

    }
}
