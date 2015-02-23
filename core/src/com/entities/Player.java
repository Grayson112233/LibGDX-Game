package com.entities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
	public float bullet_speed = 20;
	
	public boolean moving = false;
	public boolean heading = true;
	
	public ArrayList<Bullet> bullets;
	
	public int shoot_cooldown = 20;
	public int shoot_counter = 0;
	
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
		bullets = new ArrayList<Bullet>();
	}
	
	public void update(){
		if(shoot_counter > 0){
			shoot_counter -= 1;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			up();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			left();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			down();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			right();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			shoot_right();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			shoot_left();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			shoot_up();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			shoot_down();
		}
		for(int i = 0; i < bullets.size(); i ++){
			bullets.get(i).update();
		}
		clamp();
		moving = false;
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
		for(int i = 0; i < bullets.size(); i ++){
			bullets.get(i).render(batch);
		}
	}
	
	public int getWidth(){
		return a_idle_right.frames[0].getWidth();
	}
	
	public int getHeight(){
		return a_idle_right.frames[0].getHeight();
	}
	
	public void up(){
		setY(y + speed);
		moving = true;
	}
	
	public void down(){
		setY(y - speed);
		moving = true;
	}
	
	public void left(){
		setX(x - speed);
		moving = true;
		heading = false;
	}
	public void right(){
		setX(x + speed);
		moving = true;
		heading = true;
	}
	public void shoot_right(){
		if(shoot_counter == 0){
			bullets.add(new Bullet(x, y, bullet_speed, 0));
			shoot_counter = shoot_cooldown;
		}
	}
	public void shoot_left(){
		if(shoot_counter == 0){
			bullets.add(new Bullet(x, y, -bullet_speed, 0));
			shoot_counter = shoot_cooldown;
		}
	}
	public void shoot_up(){
		if(shoot_counter == 0){
			bullets.add(new Bullet(x, y, 0, bullet_speed));
			shoot_counter = shoot_cooldown;
		}
	}
	public void shoot_down(){
		if(shoot_counter == 0){
			bullets.add(new Bullet(x, y, 0, -bullet_speed));
			shoot_counter = shoot_cooldown;
		}
	}
}