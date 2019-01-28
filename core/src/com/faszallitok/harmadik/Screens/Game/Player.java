package com.faszallitok.harmadik.Screens.Game;

import com.badlogic.gdx.graphics.Texture;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.MyRectangle;
import com.faszallitok.harmadik.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Player extends OneSpriteStaticActor {
    public Player(Texture texture) {
        super(texture);
        setDebug(true);
    }

}
