package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;

public class RoadRight extends Road {
    public RoadRight() {
        super(Assets.manager.get(Assets.ROAD_RIGHT));

        addCollisionShape("bal1", new MyRectangle(20, 300, 210 + 60, 0, 0, 0, 0, -13));
        addCollisionShape("bal2", new MyRectangle(20, 300, 150 + 180, 290, 0, 0, 0, -9));
        addCollisionShape("bal3", new MyRectangle(20, 300, 115 + 250, 590, 0, 0, 0, -5));
        addCollisionShape("bal4", new MyRectangle(20, 300, 105 + 265, 890, 0, 0, 0, 2));
        addCollisionShape("bal5", new MyRectangle(20, 300, 120 + 225, 1190, 0, 0, 0, 6));
        addCollisionShape("bal6", new MyRectangle(20, 425, 180 + 100, 1490, 0, 0, 0, 13));

        addCollisionShape("jobb1", new MyRectangle(20, 300, 210 + 60 + 590, 0, 0, 0, 0, -13));
        addCollisionShape("jobb2", new MyRectangle(20, 300, 150 + 180 + 590, 290, 0, 0, 0, -9));
        addCollisionShape("jobb3", new MyRectangle(20, 300, 115 + 250 + 590, 590, 0, 0, 0, -5));
        addCollisionShape("jobb4", new MyRectangle(20, 300, 105 + 265 + 590, 890, 0, 0, 0, 2));
        addCollisionShape("jobb5", new MyRectangle(20, 300, 120 + 225 + 590, 1190, 0, 0, 0, 6));
        addCollisionShape("jobb6", new MyRectangle(20, 425, 180 + 100 + 590, 1490, 0, 0, 0, 13));
    }
}
