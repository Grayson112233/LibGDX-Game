package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animation{
	
	public Texture[] frames;
	public int[] frame_durations; // duration in cycles
	public int counter = 0;
	public int current_frame = 0;
	
	public Animation(int num_frames){
		this.frames = new Texture[num_frames];
		this.frame_durations = new int[num_frames];
	}
	
	public void addFrame(Texture frame, int duration){
		for(int i = 0; i < frames.length; i++){
			if(this.frames[i] == null){
				frames[i] = frame;
				frame_durations[i] = duration;
				break;
			}
		}
	}
	
	public void render(SpriteBatch batch, float x, float y){
		batch.draw(frames[current_frame], x, y);
		counter += 1;
		if(counter >= frame_durations[current_frame]){
			counter = 1;
			current_frame += 1;
		}
		if(current_frame >= frames.length){
			current_frame = 0;
		}
	}
	
}