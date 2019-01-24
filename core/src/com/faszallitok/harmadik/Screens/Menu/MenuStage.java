package com.faszallitok.harmadik.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyButton;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.About.AboutScreen;
import com.faszallitok.harmadik.Screens.Game.GameScreen;

public class MenuStage extends MyStage {

    private MyButton play;
    private MyButton about;
    private MyButton quit;

    public MenuStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        float w = getViewport().getWorldWidth();

        play = new MyButton("Játék", game.getButtonStyle());
        play.setPosition(getViewport().getWorldWidth() / 2 - play.getWidth() / 2, 400);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new GameScreen(getGame()));
            }
        });
        addActor(play);

        about = new MyButton("A Játékról", game.getButtonStyle());
        about.setPosition(w / 2 - play.getWidth() /2, 340);
        about.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new AboutScreen(getGame()));
            }
        });
        addActor(about);

        quit = new MyButton("Kilépés", game.getButtonStyle());
        quit.setPosition(w / 2 - play.getWidth() /2, 280);
        quit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        addActor(quit);
    }

    @Override
    public void init() {

    }
}
