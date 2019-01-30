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
import com.faszallitok.harmadik.Screens.Game.Roads.RoadStraight;
import com.faszallitok.harmadik.Screens.Menu.MenuScreen;

import java.util.ArrayList;

public class GameStage extends MyStage {
    private ArrayList<Road> roads = new ArrayList<Road>();
    private int SPEED = 7;
    private Player car;
    public int SCORE = 0;

    private float pDirX = 0;
    private long startTimer = System.currentTimeMillis();

    private GameScreen screen;
    private OneSpriteAnimatedActor explosion;
    private boolean startedExplosion = false;

    public GameStage(Batch batch, MyGdxGame game, GameScreen screen, AssetDescriptor<Texture> skin) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);
        this.screen = screen;

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
            }
        });


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
        int randNum = randomInt(1, 6); //3 típusú út.
        //randNum = 1;
        if(randNum == 1)        return new RoadStraight();
        else if (randNum == 2)  return new RoadCross();
        else if (randNum == 3)  return new RoadCircle();
        else if (randNum == 4)  return new RoadLeft();
        else if (randNum == 5)  return new RoadRight();


        return new RoadStraight();
    }

    public static AssetDescriptor<Texture> getRandomCarSkin() {
        AssetDescriptor<Texture>[] skins = new AssetDescriptor[]{Assets.CAR_1, Assets.CAR_2, Assets.CAR_3, Assets.CAR_4, Assets.CAR_5, Assets.CAR_6,
                                                                Assets.CAR_7, Assets.CAR_8, Assets.CAR_9, Assets.CAR_10, Assets.CAR_11, Assets.CAR_12, Assets.CAR_13};
        return skins[GameStage.randomInt(0, skins.length)];
    }


    private int tick = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        if(startedExplosion == false) {
            car.setY(car.getY() + SPEED);
            getCamera().position.y = car.getY() + 300;

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
            if (tick > 500) {
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
        car.setVisible(false);
        addActor(explosion);
        startedExplosion = true;
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
