package com.faszallitok.harmadik.Screens.Skin;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteActor;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyButton;
import com.faszallitok.harmadik.MyBaseClasses.UI.MyLabel;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.Game.GameScreen;

public class SkinStage extends MyStage {
    public static AssetDescriptor<Texture>[] skins = new AssetDescriptor[]{Assets.CAR_12, Assets.CAR_2};
    private int currSkin = 0;
    private OneSpriteStaticActor kocsi;

    public SkinStage(Batch batch, final MyGdxGame game) {

        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        kocsi = new OneSpriteStaticActor(Assets.manager.get(skins[currSkin]));
        addActor(kocsi);


        MyButton btn = new MyButton("cuc", game.getButtonStyle());
        addActor(btn);
        btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //Itt átváltja a screent, ha rányomunk a gombra.
                //a GameScreen-nek kell a game és egy textúra AssetDescriptor<Texture>
                game.setScreen(new GameScreen(game, skins[currSkin]));
            }
        });



    }

    private void changeSkin(int i) {
        currSkin = i;
        kocsi.setTexture(Assets.manager.get(skins[currSkin]));
    }

    @Override
    public void init() {

    }
}
