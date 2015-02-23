package com.entities;

import com.badlogic.gdx.Gdx;
import com.physics.Hitbox;

public class Entity{
	
	public float x;
	public float y;
	
	public Hitbox hitbox = new Hitbox(0, 0, 0, 0);
	
	public Entity(){
		setCoords(0, 0);
	}
	
	public Entity(float x, float y){
		setCoords(x, y);
	}
	
	public void setCoords(float x, float y){
		setX(x);
		setY(y);
	}
	
	public void moveBy(float x, float y){
		setX(this.x + x);
		setY(this.y + y);
	}
	
	public void setX(float x){
		this.x = x;
		this.hitbox.x = x;
	}
	
	public void setY(float y){
		this.y = y;
		this.hitbox.y = y;
	}
	
	// To be further implemented in extending classes
	public int getWidth(){
		return 0;
	}
	
	public int getHeight(){
		return 0;
	}
	
	public void clamp(){
		if(x < 0){
			x = 0;
		}
		if(y < 0){
			y = 0;
		}
		if(x + getWidth() > Gdx.graphics.getWidth()){
			x = Gdx.graphics.getWidth() - getWidth();
		}
		if(y + getHeight() > Gdx.graphics.getHeight()){
			y = Gdx.graphics.getHeight() - getHeight();
		}
	}
	
}