package com.physics;

public class Hitbox{
	
	public float x, y;
	public int width, height;
	
	public Hitbox(float x, float y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean collidePoint(float x, float y){
		if(x > this.x && x < this.x + width){
			if(y > this.y && y < this.y + height){
				return true;
			}
		}
		return false;
	}
	
	public float getTopLeftX(){
		return x;
	}
	
	public float getTopLeftY(){
		return y + height;
	}
	
	public float getBottomLeftX(){
		return x; 
	}
	
	public float getBottomLeftY(){
		return y;
	}
	
	public float getTopRightX(){
		return x + width;
	}
	
	public float getTopRightY(){
		return y + height;
	}
	
	public float getBottomRightX(){
		return x + width;
	}
	
	public float getBottomRightY(){
		return y;
	}
	
}