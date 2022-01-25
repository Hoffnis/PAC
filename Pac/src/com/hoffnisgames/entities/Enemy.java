package com.hoffnisgames.entities;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.hoffnisgames.main.Game;
import com.hoffnisgames.world.AS;
import com.hoffnisgames.world.Camera;
import com.hoffnisgames.world.Vector2i;

public class Enemy extends Entity {

public boolean ghost = false;
public int gf;
public int nx = Entity.rand.nextInt(60*6 - 50*3) +50*3;
	public Enemy(int x, int y, int width, int heigth, int speed, BufferedImage sprite) {
		super(x, y, width, heigth, speed, sprite);
		

		
		
		
		
		
		
	}
	
	public void tick() {
		
		/*if(this.calculateDistance(this.getX(), this.getY(), Game.player.getX(), Game.player.getY()) < 110) {
		if(isColiddingWithPlayer() == false) {
		if((int)x < Game.player.getX() && World.isFree((int)(x+speed), this.getY())
				&& !isColidding((int)(x+speed), this.getY())) {
			
			x+=speed;
			
		}
		else if((int)x > Game.player.getX() && World.isFree((int)(x-speed), this.getY())
				&& !isColidding((int)(x-speed), this.getY())) {
			
			x-=speed;
		}
		if((int)y < Game.player.getY() && World.isFree(this.getX(), (int)(y+speed))
				&& !isColidding(this.getX(), (int)(y+speed))) {
			y+=speed;
			
		}
		else if((int)y > Game.player.getY() && World.isFree(this.getX(), (int)(y-speed))
				&& !isColidding(this.getX(), (int)(y-speed))) {
			y-=speed;
			
		} 
		}
else {
		
			
			if(Game.rand.nextInt(100) < 10) {
				Game.player.life -= Game.rand.nextInt(3);
				Game.player.isDamage = true;
			}
		}
		}else {
			
		}*/
		
	if(ghost == false) {
			if(path == null || path.size() == 0) {
				Vector2i start = new Vector2i((int)(x/16),(int)(y/16));
				Vector2i end = new Vector2i((int)(Game.player.x/16),(int)(Game.player.y/16));
				path = AS.findPath(Game.world, start, end);
			
			}
				
			
			if(new Random().nextInt(100) < 60)
			followPath(path);
	}
			gf++;
			if(gf == nx) {
				gf = 0;
				if(ghost == false) {
					ghost = true;
				} else
					ghost = false;
			}
			
		}
		
	
	public void destroySelf() {
		Game.entities.remove(this);
	
	}
	
	
	
		
	
	
	

	
	public void render(Graphics g) {
		if(ghost == false) {
			super.render(g);
		}
		else
			g.drawImage(Entity.EN, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}

}
