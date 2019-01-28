package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;

public class RoadLeft extends Road {
    public RoadLeft() {
        super(Assets.manager.get(Assets.ROAD_LEFT));
        addCollisionShape("bal1", new MyRectangle(20, 300, 210, 0, 0, 0, 0, 13));
        addCollisionShape("bal2", new MyRectangle(20, 300, 150, 290, 0, 0, 0, 9));
        addCollisionShape("bal3", new MyRectangle(20, 300, 115, 590, 0, 0, 0, 5));
        addCollisionShape("bal4", new MyRectangle(20, 300, 105, 890, 0, 0, 0, -2));
        addCollisionShape("bal5", new MyRectangle(20, 300, 120, 1190, 0, 0, 0, -6));
        addCollisionShape("bal6", new MyRectangle(20, 425, 180, 1490, 0, 0, 0, -13));


        addCollisionShape("jobb1", new MyRectangle(20, 300, 210 + 580, 0, 0, 0, 0, 13));
        addCollisionShape("jobb2", new MyRectangle(20, 300, 115 + 580, 590, 0, 0, 0, 5));
        addCollisionShape("jobb3", new MyRectangle(20, 300, 150 + 580, 290, 0, 0, 0, 9));
        addCollisionShape("jobb4", new MyRectangle(20, 300, 105 + 580, 890, 0, 0, 0, -2));
        addCollisionShape("jobb5", new MyRectangle(20, 300, 120 + 580, 1190, 0, 0, 0, -6));
        addCollisionShape("jobb6", new MyRectangle(20, 425, 180 + 580, 1490, 0, 0, 0, -13));

    }
}
