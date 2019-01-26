package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;

public class RoadCross extends Road {
    public RoadCross() {
        super(Assets.manager.get(Assets.ROAD_CROSS));
        addCollisionShape("bal", new MyRectangle(140, 655, 110, 0));
        addCollisionShape("balfent", new MyRectangle(140, 695, 110, 1220));

        addCollisionShape("jobb", new MyRectangle(150, 655, 820, 0));
        addCollisionShape("jobbfent", new MyRectangle(150, 695, 820, 1220));


    }
}
