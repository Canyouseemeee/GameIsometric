package com.testgame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile  {

    private Texture t;
    public Vector2 tilemapPos;
    public Vector2 worldPos;

    public Tile(Texture t,Vector2 tilemapPos, Vector2 worldPos){
        this.t = t;
        this.tilemapPos = tilemapPos;
        this.worldPos = worldPos;
    }

//    public void update(float delta){
//        worldPos.x += 2;
//        worldPos.y += 4;
//    }
    public void render(SpriteBatch batch) {
        batch.draw(t,worldPos.x,worldPos.y);
    }

    public Vector2 getWorldPos() {
        return worldPos;
    }

    public void setWorldPos(Vector2 worldPos) {
        this.worldPos = worldPos;
    }

}
