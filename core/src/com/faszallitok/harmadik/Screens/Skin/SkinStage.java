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
    public static AssetDescriptor<Texture>[] skins = new AssetDescriptor[]{Assets.CAR_12, Assets.CAR_13, Assets.CAR_14, Assets.CAR_15};
    private int currSkin = 0;
    private OneSpriteStaticActor kocsi;
    private OneSpriteStaticActor toplayer;
    private int megy = 0;
    private float tick = 0;
    private int currect = 0;
    private boolean free = true;

    public SkinStage(Batch batch, final MyGdxGame game) {

        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.GAR_BG));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        kocsi = new OneSpriteStaticActor(Assets.manager.get(skins[currSkin]));
        addActor(kocsi);
        kocsi.setSize(kocsi.getWidth()/2,kocsi.getHeight()/2);
        kocsi.setPosition(getViewport().getWorldWidth()/2-kocsi.getWidth()/2,getViewport().getWorldHeight()/4);
        kocsi.setRotation(-90);

        toplayer = new OneSpriteStaticActor(Assets.manager.get(Assets.GAR_TOP));
        toplayer.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(toplayer);


        MyButton bal = new MyButton("<",game.getButtonStyle());
        MyButton jobb = new MyButton(">",game.getButtonStyle());
        addActor(bal);
        addActor(jobb);
        bal.setPosition(getViewport().getWorldWidth()/10,getViewport().getWorldHeight()/10);
        bal.setWidth(bal.getWidth()/4);
        jobb.setWidth(jobb.getWidth()/4);
        jobb.setPosition(getViewport().getWorldWidth()-getViewport().getWorldWidth()/10-jobb.getWidth(),getViewport().getWorldHeight()/10);


        MyButton btn = new MyButton("Play", game.getButtonStyle());
        addActor(btn);
        btn.setPosition(getViewport().getWorldWidth()/2-btn.getWidth()/2,getViewport().getWorldHeight()/10);
        btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(free){
                    free=false;
                megy = 3;
                tick = -90;}
            }
        });

        jobb.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(free){
                    free=false;
                megy = 1;
                currect++;
                tick = getViewport().getWorldWidth()/2-kocsi.getWidth()/2;}
            }
        });

        bal.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(free){
                    free=false;
                megy = 1;
                currect--;
                tick=getViewport().getWorldWidth()/2-kocsi.getWidth()/2;}
            }
        });


    }


    public void act(float delta) {
        if(megy==1){
        super.act(delta);
        tick += 10;
        kocsi.setX(tick);
        if(tick >getViewport().getWorldWidth()+kocsi.getWidth())changeSkin();}
        else if(megy == 2){
            super.act(delta);
            tick += 10;
            kocsi.setX(tick);
        if(tick >getViewport().getWorldWidth()/2-kocsi.getWidth()/2){megy=0; free=true;}}
        else if(megy==3){
            super.act(delta);
            tick += 5;
            kocsi.setRotation(tick);
            if(tick>=0){
                tick=getViewport().getWorldHeight()/4;
                megy=4;
            }
        }
        else if(megy==4){
            super.act(delta);
            tick += 15;
            kocsi.setY(tick);
            if(tick>getViewport().getWorldHeight()+kocsi.getWidth()){
                game.setScreen(new GameScreen(game, skins[currect], false));
            }
        }
        }


    private void changeSkin() {
        if(currect>=skins.length)currect=0;
        if(currect<0)currect=skins.length-1;
        kocsi.setTexture(Assets.manager.get(skins[currect]));
        kocsi.setX(kocsi.getWidth()*-1);
        megy=2;
        tick=kocsi.getWidth()*-1;
    }


    @Override
    public void init() {

    }
}
