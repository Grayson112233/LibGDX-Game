package com.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Animation;
import com.physics.Hitbox;

public class Player extends Entity{
	
	public Animation a_idle_right;
	public Animation a_idle_left;
	public Animation a_walking_right;
	public Animation a_walking_left;
	
	public int speed = 5;
	
	public boolean moving = false;
	public boolean heading = true;
	
	public Player(float x, float y){
		super(y, x);
		a_idle_right = new Animation(1);
		a_idle_right.addFrame(new Texture("entities/player/stand_right.png"), 1);
		
		a_idle_left = new Animation(1);
		a_idle_left.addFrame(new Texture("entities/player/stand_left.png"), 1);
		
		a_walking_right = new Animation(2);
		a_walking_right.addFrame(new Texture("entities/player/walk1_right.png"), 20);
		a_walking_right.addFrame(new Texture("entities/player/walk2_right.png"), 20);
		
		a_walking_left = new Animation(2);
		a_walking_left.addFrame(new Texture("entities/player/walk1_left.png"), 20);
		a_walking_left.addFrame(new Texture("entities/player/walk2_left.png"), 20);
		
		hitbox = new Hitbox(x, y, getWidth(), getHeight());
	}
	
	public void render(SpriteBatch batch){
		if(moving){
			if(heading){
				a_walking_right.render(batch, x, y);
			}
			else{
				a_walking_left.render(batch, x, y);
			}
			
		}
		else{
			if(heading){
				a_idle_right.render(batch, x, y);
			}
			else{
				a_idle_left.render(batch, x, y);
			}
		}
		moving = false;
	}
	
	public int getWidth(){
		return a_idle_right.frames[0].getWidth();
	}
	
	public int getHeight(){
		return a_idle_right.frames[0].getHeight();
	}
	
	public void up(){
		y += speed;
		moving = true;
	}
	
	public void down(){
		y -= speed;
		moving = true;
	}
	
	public void left(){
		x -= speed;
		moving = true;
		heading = false;
	}
	public void right(){
		x += speed;
		moving = true;
		heading = true;
	}
	
}