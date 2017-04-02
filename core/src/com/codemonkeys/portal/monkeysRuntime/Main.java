package com.codemonkeys.portal.monkeysRuntime;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.codemonkeys.portal.monkeyFormManager.ScreenManager;
import com.codemonkeys.portal.monkeyInvitationsSystem.InvitationGenerator;
import com.codemonkeys.portal.monkeyInvitationsSystem.MonkeyHash;

public class Main extends ApplicationAdapter {
	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public OrthographicCamera camera;
	public Runtime runtime;
	public ScreenManager screenManager;
	public String CONNECTED_ID;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera(1366,768);
		camera.setToOrtho(false,1366,768);
		runtime = new Runtime();
		screenManager = new ScreenManager(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screenManager.drawScreen();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
