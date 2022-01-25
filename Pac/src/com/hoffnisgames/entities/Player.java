package com.hoffnisgames.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hoffnisgames.main.Game;
import com.hoffnisgames.world.Camera;
import com.hoffnisgames.world.World;

public class Player extends Entity{

	public boolean rigth, left, up, down;
	public int dir =1;
	public BufferedImage sprite_left;
	public BufferedImage sprite_down;
	public BufferedImage sprite_up;
	
	
	
	public Player(int x, int y, int width, int heigth, double speed, BufferedImage sprite) {
		super(x, y, width, heigth, speed, sprite);
	
		sprite_left = Game.spritesheet.getSprite(48, 16, 16, 16);
		sprite_down = Game.spritesheet.getSprite(80, 0, 16, 16);
		sprite_up = Game.spritesheet.getSprite(64, 16, 16, 16);
	}
	public void tick() {
		
		
		
		
			

		
		if(rigth && World.isFree((int)(x+speed),this.getY())) {
	
		
			x+=speed;
			dir=1;
			
		}
		else if(left && World.isFree((int)(x-speed),this.getY())) {
	
	
			x-=speed;
			dir =2;
			}
		
		if(down && World.isFree(this.getX(),(int)(y+speed))) {
	
	
			y+=speed;
			dir = 3;
		}
		
		else if(up && World.isFree(this.getX(),(int)(y-speed))) {
		

		y-=speed;
		dir =4;
		}
		
		Comer();
		
	}
	
	public void Comer() {
		for(int i = 0; i < Game.entities.size(); i++ ) {
			Entity current = Game.entities.get(i);
			if(current instanceof Comida) {
				if(Entity.isCollinding(this, current)) {
					Game.entities.remove(i);
					return;
				}
			}
		}
	}
	public void render(Graphics g) {
		if(dir == 1) {
			super.render(g);
		}
		else if(dir == 2) {
			g.drawImage(sprite_left, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		else if(dir == 3) {
			g.drawImage(sprite_down, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		else if(dir == 4) {
			g.drawImage(sprite_up, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
	}
	
	
	
	
	
	
	
	


}
