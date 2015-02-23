package com.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.physics.Hitbox;

public class Bullet{
	
	public float x, y, xv, yv;
	public Texture img_bullet;
	public Hitbox hitbox;
	
	public Bullet(float x, float y, float xv, float yv){
		this.x = x;
		this.y = y;
		this.xv = xv;
		this.yv = yv;
		hitbox = new Hitbox(x, y, 8, 8);
		img_bullet = new Texture("entities/items/bullet.png");
	}
	
	public void update(){
		x += xv;
		y += yv;
		this.hitbox.setCoords(x, y);
	}
	public void render(SpriteBatch batch){
		batch.draw(img_bullet, x, y);
	}
	
}