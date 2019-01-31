package com.faszallitok.harmadik.Screens.About;

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

public class AboutStage extends MyStage {
    private MyButton back;
    private MyLabel title;
    private MyLabel info;

    public AboutStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        title = new MyLabel("A Játékról", game.getLabelStyle());
        title.setAlignment(Align.center);
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2, getViewport().getWorldHeight() - 90);
        title.setFontScale(1.6f);
        addActor(title);

        info = new MyLabel("Az autót az ujjaddal tudod irányítani,\nígy kellaz úton maradnod,\nés az autókat kikerülnöd\n\nKészítők: A Fa Szállítók csapata", game.getLabelStyle());
        info.setAlignment(Align.center);
        info.setPosition(getViewport().getWorldWidth() / 2 - info.getWidth() / 2, getViewport().getWorldHeight()/7);
        addActor(info);

        back = new MyButton("Menü", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 20 );
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new MenuScreen(getGame()));
            }
        });
        addActor(back);

    }

    @Override
    public void init() {

    }
}
