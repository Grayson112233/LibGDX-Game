package com.entities;

import com.physics.Hitbox;

public class Entity{
	
	private float x;
	private float y;
	
	protected Hitbox hitbox;
	
	public Entity(){
		x = 0;
		y = 0;
	}
	
	public Entity(float x, float y){
		setX(x);
		setY(y);
	}
	
	public void setCoords(float x, float y){
		setX(x);
		setY(y);
	}
	
	public void moveBy(float x, float y){
		setX(this.getX() + x);
		setY(this.getY() + y);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
}