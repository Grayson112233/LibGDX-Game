package com.entities;

import com.badlogic.gdx.graphics.Texture;
import com.physics.Hitbox;

public class Player extends Entity{
	
	private Texture[] a_idle;
	private Texture[] a_walk;
	
	public Player(float x, float y){
		super(x, y);
		a_idle = new Texture[]{ new Texture("entities/player/stand1.png")};
								
		a_walk = new Texture[]{ new Texture("entities/player/walk1.png"), 
								new Texture("entities/player/walk2.png")};
		hitbox = new Hitbox();
	}
}