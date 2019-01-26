package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;

public class RoadStraight extends Road {
    public RoadStraight() {
        super(Assets.manager.get(Assets.ROAD_STRAIGHT));
        addCollisionShape("bal", new MyRectangle(60, getHeight(), 190, 0));
        addCollisionShape("jobb", new MyRectangle(60, getHeight(), 825, 0));
    }
}
