package com.testgame.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class testgame extends Game {
	private SpriteBatch batch;
	private GameScreen screen;
	private int x;

	@Override
	public void create () {
		batch = new SpriteBatch();
		screen = new GameScreen(batch);
		setScreen(screen);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {

	}
}
