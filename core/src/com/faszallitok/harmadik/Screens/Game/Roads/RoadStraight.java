package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.faszallitok.harmadik.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.Random;

public class RoadStraight extends Road {

    public ArrayList<Obsitcle> obstacles = new ArrayList<Obsitcle>();
    GameStage stage;

    public RoadStraight(GameStage stage) {
        super(Assets.manager.get(Assets.ROAD_STRAIGHT));
        this.stage = stage;

        addCollisionShape("bal", new MyRectangle(60, getHeight(), 190, 0));
        addCollisionShape("jobb", new MyRectangle(60, getHeight(), 825, 0));
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();

        if(randomInt(0, 101) < 75){
            Obsitcle otherCar = new Obsitcle(Assets.manager.get(GameStage.getRandomCarSkin()));
            otherCar.setSize(otherCar.getWidth() / 3, otherCar.getHeight() / 3);
            //addCollisionShape("othercar", new MyRectangle(otherCar.getWidth() - 60, otherCar.getHeight() - 60, 30, 30));

            boolean jobbOldal = randomInt(0, 3) > 1 ? false : true;
            float carX = 0;
            if(!jobbOldal){ carX = 50 + 250 / 2 - otherCar.getWidth() / 2; otherCar.setRotation(180);}
            else carX = 270 + 250 / 2 - otherCar.getWidth() / 2;

            otherCar.setPosition(carX, randomInt((int)getY() + 500, (int)getY() + (int)getHeight() - 500));

            addCollisionShape("othercar", new MyRectangle(otherCar.getWidth() - 60, otherCar.getHeight() - 60, otherCar.getX() + 30, otherCar.getY() + 30));

            //otherCar.setDebug(true);
            obstacles.add(otherCar);
            //System.out.println("Obsticle "+obstacles.size());
        }
    }

    AssetDescriptor<Sound> getRandomBreszolas() {
        AssetDescriptor<Sound>[] sounds = new AssetDescriptor[]{Assets.SOUND_1, Assets.SOUND_2, Assets.SOUND_3};
        return sounds[randomInt(0, sounds.length)];
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (int i = 0; i < obstacles.size(); i++) {
            if(obstacles.get(i).getY() + obstacles.get(i).getHeight() < stage.car.getY()) {
               if(obstacles.get(i).beszolt == false) {
                   // Megelőzte.
                   Assets.manager.get(getRandomBreszolas()).play(0.5f);
                   obstacles.get(i).beszolt = true;
               }

            }
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        //batch.setProjectionMatrix(getStage().getCamera().combined);
        //batch.begin();
        for(int i = 0; i < obstacles.size(); i++) obstacles.get(i).draw(batch, parentAlpha);
        //batch.end();
    }

    private int randomInt(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min) ) + min;
    }

}
