package com.entities;

import com.physics.Hitbox;

public class Entity{
	
	public float x;
	public float y;
	
	public Hitbox hitbox;
	
	public Entity(){
		setCoords(x, y);
	}
	
	public Entity(float x, float y){
		setCoords(x, y);
	}
	
	public void setCoords(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void moveBy(float x, float y){
		this.x += x;
		this.y += y;
	}
}