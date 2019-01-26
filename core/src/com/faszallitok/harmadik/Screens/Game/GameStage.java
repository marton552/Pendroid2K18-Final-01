package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyStage;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.MyGdxGame;
import com.faszallitok.harmadik.Screens.Game.Roads.Road;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadCircle;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadCross;
import com.faszallitok.harmadik.Screens.Game.Roads.RoadStraight;

import java.util.ArrayList;

public class GameStage extends MyStage {
    private ArrayList<Road> roads = new ArrayList<Road>();
    private int SPEED = 5;

    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(576, 1024, new OrthographicCamera(576, 1024)), batch, game);

        for(int i = 0; i < 3; i++) {
            addRoad();
        }


    }

    int randomInt(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min) ) + min;
    }

    Road addRoad() {
        float lastY = roads.size() > 0 ? roads.get(roads.size() - 1).getY() + roads.get(roads.size() - 1).getHeight() : 0;

        Road road = getRandomRoad();
        road.setSize(road.getWidth() / 1.5f, road.getHeight() / 1.5f);
        road.setPosition(getViewport().getWorldWidth() / 2 - road.getWidth() / 2, lastY);
        addActor(road);
        roads.add(road);

        return road;
    }

    Road getRandomRoad() {
        int randNum = randomInt(1, 4); //3 típusú út.
        //randNum = 3;
        if(randNum == 1)        return new RoadStraight();
        else if (randNum == 2)  return new RoadCross();
        else if (randNum == 3)  return new RoadCircle();

        return new RoadStraight();
    }

    private int tick = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        getCamera().position.y += SPEED;
        for (int i = 0; i < roads.size(); i++) {
            if(roads.get(i).getY() + roads.get(i).getHeight()+getViewport().getWorldHeight() <= getCamera().position.y){
                //System.out.println("Kint van. ("+i+")");
                getActors().removeValue(roads.get(i), false);
                roads.set(i, null);
                roads.remove(i);
                addRoad();
            }
        }

        tick++;
        //if(tick > 100) { SPEED++; tick = 0;}
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            getCamera().position.y -= 5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            getCamera().position.y += 5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            getCamera().position.x += 5;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            getCamera().position.x -= 5;
        }
    }

    @Override
    public void init() {

    }
}
