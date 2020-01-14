package com.testgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;

public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    public OrthographicCamera camera;
    private Tilemap map;
    private Player player;
    public static int width = 1280;
    public static  int height = 720;
    private Vector2 cx;

    public GameScreen(SpriteBatch batch){
        this.batch = batch;
        camera = new OrthographicCamera(1280,720);
        map = new Tilemap();
        player = new Player();
        cx = player.getPos();
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

//        cameraInput();
        setCamera();
        player.update(delta);
        try {
            map.update(delta);
        } catch (IOException e) {
            e.printStackTrace();
        }
        camera.update();

        batch.begin();

        map.render(batch);
        player.render(batch);

        batch.end();

    }

    public void setCamera(){
        camera.position.x = cx.x;
        camera.position.y = cx.y;

    }

    private void cameraInput(){

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            camera.position.x -= 10;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            camera.position.x += 10;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            camera.position.y += 10;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            camera.position.y -= 10;
        }

    }

}
