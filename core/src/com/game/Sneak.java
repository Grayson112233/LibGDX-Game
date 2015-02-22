package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entities.Entity;
import com.entities.Player;

public class Sneak extends ApplicationAdapter {
	SpriteBatch batch;
	Player guy;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		guy = new Player(100, 100);
	}
	
	public void update(){
		
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			guy.up();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			guy.left();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			guy.down();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			guy.right();
		}
		
	}

	@Override
	public void render () {
		
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		guy.render(batch);
		batch.end();
	}
}
