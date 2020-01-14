package com.testgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



public class Player implements Entity {
    private Texture img;
    public Vector2 pos;
    private float time;
    private GameScreen screen;
    private SpriteBatch batch;


    public Player(){

        img = new Texture(Gdx.files.internal("player.png"));
        setPos(new Vector2(5, 10));
        time = 2;

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(img, getPos().x, getPos().y);

    }


    @Override
    public void update(float delta) {
        time =+ delta;
        if (pos.x < GameScreen.width+618){
            pos.x +=4;
        }
        if (pos.y < GameScreen.height+234){
            pos.y +=2;
        }
            move();
//        pos.y -= 1;
    }

    private void move(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            pos.y += 25;

        }else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            pos.y -=25;
        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
//            getPos().x -= 32;
//            getPos().y += 16;
//            time = 0;
//        }
//        else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
//            getPos().x += 32;
//            getPos().y -= 16;
//            time = 0;
//        }
//        else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
//            getPos().x -= 32;
//            getPos().y -= 16;
//            time = 0;
//        }
//        else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
//            getPos().x += 32;
//            getPos().y += 16;
//            time = 0;
//        }

    }


    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
}
