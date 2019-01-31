package com.faszallitok.harmadik.Screens.Game.Roads;

import com.faszallitok.harmadik.GlobalClasses.Assets;
import com.faszallitok.harmadik.Screens.Game.GameStage;

public class RoadRiver extends RoadStraight {

    public RoadRiver(GameStage stage) {
        super(stage);
        setTexture(Assets.manager.get(Assets.ROAD_RIVER));


    }
}
