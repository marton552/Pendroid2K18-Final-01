package com.faszallitok.harmadik.Screens.Game.Roads;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Obsitcle extends OneSpriteStaticActor {
    public boolean beszolt = false;

    public Obsitcle(Texture texture) {
        super(texture);
    }
}
