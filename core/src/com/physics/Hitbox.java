package com.physics;

public class Hitbox{
	
	private float x, y;
	private int width, height;
	
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
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
}