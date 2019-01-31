package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.End.EndScreen;
import com.faszallitok.harmadik.Screens.End.EndStage;
import com.faszallitok.harmadik.Screens.Game.Roads.Road;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadCircle;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadCross;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadLeft;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadRight;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadRiver;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadStraight;
import com.faszallitok.harmadik.Screens.Menu.MenuScreen;

import java.util.ArrayList;

public class GameStage extends MyStage {
    private ArrayList<Road> roads = new ArrayList<Road>();
    private int SPEED = 7;
    public Player car;
    public int SCORE = 0;

    private float pDirX = 0;
    private float pDirY = 0;
    private long startTimer = System.currentTimeMillis();

    private GameScreen screen;
    private OneSpriteAnimatedActor explosion;
    private OneSpriteAnimatedActor explosion1;
    private OneSpriteAnimatedActor explosion3;
    private boolean startedExplosion = false;
    OneSpriteStaticActor red;
    boolean bool1;

    public GameStage(Batch batch, MyGdxGame game, GameScreen screen, AssetDescriptor<Texture> skin, boolean challange) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);
        this.screen = screen;
        bool1 = challange;

        for(int i = 0; i < 3; i++) {
            addRoad();
        }

        car = new Player(Assets.manager.get(skin));
        car.setSize(car.getWidth() / 3, car.getHeight() / 3);
        car.setPosition(getViewport().getWorldWidth() / 2 - car.getWidth() / 2, 100);
        pDirX = car.getX();
        car.addCollisionShape("player", new MyRectangle(car.getWidth() - 60, car.getHeight() - 60, 30, 30));
        addActor(car);


        addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                //car.setX(x - car.getWidth() / 2);
                pDirX = x - car.getWidth() / 2;
                pDirY = y;// - car.getHeight() / 2;
            }
        });

        red = new OneSpriteStaticActor(Assets.manager.get(Assets.RED));
        red.setSize(getViewport().getWorldWidth()*3,getViewport().getWorldHeight()*2);
        addActor(red);
        red.setZIndex(100);
        red.setVisible(false);
        explosion1 = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_ATLAS));
        explosion1.setSize(explosion1.getWidth() * 2, explosion1.getHeight() * 2);
        addActor(explosion1);
        explosion3 = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_ATLAS));
        explosion3.setSize(explosion3.getWidth() * 2, explosion3.getHeight() * 2);
        addActor(explosion3);
        explosion1.setVisible(false);
        explosion3.setVisible(false);
        if(challange) {
            red.setVisible(true);
            explosion1.setVisible(true);
            explosion3.setVisible(true);
            Assets.manager.get(Assets.METAL).play();
        }
    }

    static int randomInt(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min) ) + min;
    }

    Road addRoad() {
        float lastY = roads.size() > 0 ? roads.get(roads.size() - 1).getY() + roads.get(roads.size() - 1).getHeight() : 0;

        Road road = getRandomRoad();
        road.setSize(road.getWidth() / 1.5f, road.getHeight() / 1.5f);
        road.setPosition(getViewport().getWorldWidth() / 2 - road.getWidth() / 2, lastY);
        //if(road instanceof RoadStraight) {}
        //else addActor(road);
        addActor(road);
        roads.add(road);

        return road;
    }

    Road getRandomRoad() {
        int randNum = randomInt(1, 7); //3 típusú út.
        //randNum = 1;
        if(randNum == 1)        return new RoadStraight(this);
        else if (randNum == 2)  return new RoadCross();
        else if (randNum == 3)  return new RoadCircle();
        else if (randNum == 4)  return new RoadLeft();
        else if (randNum == 5)  return new RoadRight();
        else if (randNum == 6)  return new RoadRiver(this);

        return new RoadStraight(this);
    }

    public static AssetDescriptor<Texture> getRandomCarSkin() {
        AssetDescriptor<Texture>[] skins = new AssetDescriptor[]{Assets.CAR_1, Assets.CAR_2, Assets.CAR_3, Assets.CAR_4, Assets.CAR_5, Assets.CAR_6,
                                                                Assets.CAR_7, Assets.CAR_8, Assets.CAR_9, Assets.CAR_10, Assets.CAR_11, Assets.CAR_12, Assets.CAR_13};
        return skins[GameStage.randomInt(0, skins.length)];
    }


    private int tick = 0;
    private int tick3 = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        if(startedExplosion == false) {
            car.setY(car.getY() + SPEED);
            getCamera().position.y = car.getY() + 300;
            red.setX(car.getX()-getViewport().getWorldWidth());
            red.setY(car.getY()-getViewport().getWorldHeight()/3);
            red.setZIndex(100);
            car.setRotation(-(float) calcAngle(pDirX - car.getX(), (float) Math.sqrt(Math.pow(pDirX - car.getX(), 2) + Math.pow(pDirY - car.getY(), 2))));

            if (car.getX() != pDirX)
                car.setX(car.getX() - (car.getX() - pDirX) / 7);

            if (car.getX() + car.getWidth() / 2 - getViewport().getWorldWidth() / 2 > roads.get(0).getX() && car.getX() + car.getWidth() / 2 + getViewport().getWorldWidth() / 2 < roads.get(0).getX() + roads.get(0).getWidth())
                getCamera().position.x = car.getX() + car.getWidth() / 2;

            for (int i = 0; i < roads.size(); i++) {
                if (roads.get(i).getY() + roads.get(i).getHeight() + getViewport().getWorldHeight() <= getCamera().position.y) {
                    getActors().removeValue(roads.get(i), false);
                    roads.set(i, null);
                    roads.remove(i);
                    addRoad();
                }
            }

            if (startTimer + 1000 < System.currentTimeMillis()) {
                SCORE++;
                startTimer = System.currentTimeMillis();
                screen.gameHud.updateGameHud(SCORE);
            }

            tick++;
            tick3++;
            explosion1.setZIndex(9);
            explosion3.setZIndex(9);
            if(bool1){
                if(tick > 100){
                    SPEED++;
                    tick = 0;
                    explosion1.setPosition(car.getX()-getViewport().getWorldWidth(),car.getY()+randomInt(-200,200));
                }
                if(tick3 > 150){
                    SPEED++;
                    tick3 = 0;
                    explosion3.setPosition(car.getX()-getViewport().getWorldWidth()/2,car.getY()+randomInt(-200,200));
                }
            }
            else if (tick > 500) {
                SPEED++;
                tick = 0;
            }


            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                getCamera().position.y -= 5;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                getCamera().position.y += 5;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                getCamera().position.x += 5;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                getCamera().position.x -= 5;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                SPEED = 10;
            }//else SPEED = 0;


            for (int i = 0; i < roads.size(); i++) {
                if (car.overlaps(roads.get(i))) {
                    gameOver();
                }
            }
        }else {
            if(explosion.isRunning() == false) game.setScreen(new EndScreen(game, SCORE));
        }
    }

    private void gameOver() {
        explosion = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_ATLAS));
        explosion.setSize(explosion.getWidth() * 2, explosion.getHeight() * 2);
        explosion.setPosition(car.getX() + car.getWidth() / 2 - explosion.getWidth() / 2, car.getY() + car.getHeight() / 2 - explosion.getHeight() / 2);
        explosion.start();
        explosion.setLooping(false);
        Assets.manager.get(Assets.SOUND_EXPLOSION).play(0.7f);
        Assets.manager.get(Assets.METAL).stop();
        car.setVisible(false);
        addActor(explosion);
        startedExplosion = true;
    }

    double calcAngle(float a, float c) {
        //System.out.println("a: "+a+" c: "+c+" = "+(Math.toDegrees(Math.asin(a / c))));
        return Math.round(Math.toDegrees(Math.asin(a / c)));
    }


    @Override
    public void draw() {
        super.draw();

        getBatch().setProjectionMatrix(getCamera().combined);
        getBatch().begin();
        if(car.isVisible()) car.draw(getBatch(), 1);
        if(startedExplosion) explosion.draw(getBatch(), 1);
        getBatch().end();
    }

    @Override
    public void init() {

    }
}
