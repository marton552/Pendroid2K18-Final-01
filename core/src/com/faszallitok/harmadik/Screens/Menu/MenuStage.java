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
import com.faszallitok.harmadik.Screens.Skin.SkinScreen;

public class MenuStage extends MyStage {

    private MyButton play;
    private MyButton about;
    private MyButton quit;
    private MyButton challege;

    OneSpriteStaticActor bg;
    private OneSpriteStaticActor martin;
    private OneSpriteStaticActor title;
    private float martinStartX = 0;
    float x;
    float y;

    private OneSpriteStaticActor story1;
    private OneSpriteStaticActor story2;
    private OneSpriteStaticActor story3;

    public MenuStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        float w = getViewport().getWorldWidth();
        float h = getViewport().getWorldHeight();

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG));
        bg.setSize(w, h);
        addActor(bg);

        Assets.manager.get(Assets.METAL).stop();
        title = new OneSpriteStaticActor(Assets.manager.get(Assets.TITLE));
        addActor(title);
        title.setSize(title.getWidth(),title.getHeight());
        x=getViewport().getWorldWidth()/2-title.getWidth()/2;
        y=getViewport().getWorldHeight()-title.getHeight()-50;
        title.setPosition(x,y);

        martin = new OneSpriteStaticActor(Assets.manager.get(Assets.MARTIN));
        martin.setSize(martin.getWidth() / 1.8f, martin.getHeight() / 1.8f);
        martinStartX = w - martin.getWidth() / 2 - 130;
        martin.setPosition(martinStartX,0);
        addActor(martin);

        challege = new MyButton("Metal Challenge", game.getButtonStyle());
        challege.setPosition(w / 2 - challege.getWidth() / 2, 400);
        challege.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                storymode();
                //getGame().setScreen(new GameScreen(getGame(), Assets.METALCAR, true));
            }
        });
        addActor(challege);

        play = new MyButton("Játék", game.getButtonStyle());
        play.setPosition(w / 2 - play.getWidth() / 2, 460);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new SkinScreen(getGame()));
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

        //story
        story1 = new OneSpriteStaticActor(Assets.manager.get(Assets.STORY1));
        story1.setSize(w, h);
        story1.setPosition(0-getViewport().getWorldWidth(),0);
        addActor(story1);
        story2 = new OneSpriteStaticActor(Assets.manager.get(Assets.STORY2));
        story2.setSize(w, h);
        story2.setPosition(0-getViewport().getWorldWidth(),0);
        addActor(story2);
        story3 = new OneSpriteStaticActor(Assets.manager.get(Assets.STORY4));
        story3.setSize(w, h);
        story3.setPosition(0-getViewport().getWorldWidth(),0);
        addActor(story3);
    }

    private int animSpeed = 0;
    private float tick = 3;
    int story = 0;
    float count = 0-getViewport().getWorldWidth();

    public void storymode(){
        quit.setVisible(false);
        about.setVisible(false);
        play.setVisible(false);
        challege.setVisible(false);
        martin.setVisible(false);
        title.setVisible(false);
        bg.setVisible(false);
        story = 1;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        animSpeed++;
        tick += 0.01;
        //if(tick > 2) tick = 0;
        //System.out.println(Math.cos(tick));

        //if(Math.cos(tick) < 0.4f && Math.cos(tick) > -0.4f)
        martin.setX(martinStartX + ((float)Math.cos(tick) * 10) / 1);
        title.setY(y + ((float)Math.cos(tick) * 10) / 1);

        //story
        if(story!=0){
            if(story==1){
                count+=10;
                story1.setX(count);
                if (count >=0) {
                    story = 2; count = 0-getViewport().getWorldWidth();
                }
            }
            if(story==2){
                count+=10;
                story2.setX(count);
                if (count >= 0) {
                    story = 3; count = getViewport().getWorldWidth();
                }
            }
            if(story==3){
                count-=10;
                story3.setX(count);
                if (count <= 0) {
                    story = 4; count = getViewport().getWorldWidth();
                }
            }
            if(story==4){
                count-=10;
                if (count <= 0) {
                    getGame().setScreen(new GameScreen(getGame(), Assets.METALCAR, true));
                }
            }
        }
    }

    @Override
    public void init() {

    }
}
