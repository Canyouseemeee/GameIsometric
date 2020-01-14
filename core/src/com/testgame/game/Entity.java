package com.testgame.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;

public interface Entity {
    public void render(SpriteBatch batch);
    public void update(float delta) throws IOException;
}
