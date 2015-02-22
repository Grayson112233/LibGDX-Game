package com.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Animation;
import com.physics.Hitbox;

public class Player extends Entity{
	
	public Animation a_idle;
	public Animation a_walking;
	
	public Player(){
		super(0, 0);
		a_idle = new Animation(1);
		a_idle.addFrame(new Texture("entities/player/stand.png"), 1);
								
		a_walking = new Animation(2);
		a_walking.addFrame(new Texture("entities/player/walk1.png"), 20);
		a_walking.addFrame(new Texture("entities/player/walk2.png"), 20);
		
		hitbox = new Hitbox(x, y, getWidth(), getHeight());
	}
	
	public Player(float x, float y){
		super(x, y);
		a_idle = new Animation(1);
		a_idle.addFrame(new Texture("entities/player/stand.png"), 1);
								
		a_walking = new Animation(2);
		a_walking.addFrame(new Texture("entities/player/walk1.png"), 20);
		a_walking.addFrame(new Texture("entities/player/walk2.png"), 20);
		
		hitbox = new Hitbox(x, y, getWidth(), getHeight());
	}
	
	public void render(SpriteBatch batch){
		a_walking.render(batch, x, y);
	}
	
	public int getWidth(){
		return a_idle.frames[0].getWidth();
	}
	
	public int getHeight(){
		return a_idle.frames[0].getHeight();
	}
	
}