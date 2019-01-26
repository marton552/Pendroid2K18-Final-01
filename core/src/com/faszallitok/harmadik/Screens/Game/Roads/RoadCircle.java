package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyCircle;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;

public class RoadCircle extends Road {
    public RoadCircle() {
        super(Assets.manager.get(Assets.ROAD_CIRCLE));

        addCollisionShape("bal", new MyRectangle(140, 580, 110, 0));
        addCollisionShape("baliv", new MyRectangle(90, 110, 140, 520, 0, 0, 0, 45));
        addCollisionShape("balt", new MyRectangle(162, 20, 0, 630));

        addCollisionShape("balf", new MyRectangle(140, 615, 110, 1300));
        addCollisionShape("balfiv", new MyRectangle(90, 110, 140, 1235, 0, 0, 0, 135));
        addCollisionShape("balft", new MyRectangle(162, 20, 0, 1225));


        addCollisionShape("jobb", new MyRectangle(140, 580, 820, 0));
        addCollisionShape("jobbiv", new MyRectangle(90, 110, 850, 520, 0, 0, 0, 135));
        addCollisionShape("jobbt", new MyRectangle(162, 20, 915, 630));

        addCollisionShape("jobbf", new MyRectangle(140, 615, 820, 1300));
        addCollisionShape("jobbfiv", new MyRectangle(90, 110, 840, 1235, 0, 0, 0, 45));
        addCollisionShape("jobbft", new MyRectangle(162, 20, 915, 1225));

        addCollisionShape("belul", new MyCircle(140, 400, 820));

    }
}
