package com.teamBasics.CollegeTD;

import java.util.ArrayList;

import android.graphics.Rect;

public class Enemy {
	//posX, posY=top left corner of enemy sprite
	protected int posX, posY, speed;  					// add power later on
	protected int movementX;
	protected int movementY;
	protected int size;
	
	public static Rect rect = new Rect(0, 0, 0, 0);
	public static Rect yellowRed = new Rect(0, 0, 0, 0);
	//private Robot robot = GameScreen.getRobot();		//later will need to get towers??
	public Rect r = new Rect(0, 0, 0, 0);				//collision box
	protected int health;
	protected boolean visible, kamakazi;			//kamakazi means enemy reached end of map
	private ArrayList<PathTile> tilearrayPath;
	
	
	public Enemy(int posX, int posY, ArrayList<PathTile> tilearrayPath) {
		setPosX(posX);
		setPosY(posY);
		setVisible(true);
		kamakazi = false;
		this.tilearrayPath = tilearrayPath;
	}
	
	// Behavioral Methods
	public void update() {
		int next_tileY, next_tileX;
		if(posY+(size/2) >= 360 || posX+(size/2) >= 680) {
			if(visible==true) {		//means its the first time through
				kamakazi = true;
			}
			visible = false;
			//die but don't add to user cash
		}
		else {
			if(movementY > 0) {
				next_tileY = posY+speed+size;	
				next_tileX = posX+(size/2);
			}
			else if(movementY < 0) {
				next_tileY = posY+speed-size;	
				next_tileX = posX+(size/2);
			}
			else if(movementX < 0 ){
				next_tileY = posY+(size/2);
				next_tileX = posX+speed-size;			
			}
			else {
				next_tileY = posY+(size/2);
				next_tileX = posX+speed+size;
			}
			
			if(next_tileX <680 && next_tileY < 360) {
				PathTile next = searchArray(next_tileX, next_tileY);
				if(next == null) {
					movementY=0;
					movementX=0;
				}
				else if(next != null && next.type2 != 's') {
					if(movementY != 0) {
						movementY=0;
						movementX=horizantal_Search();
					}
					else {
						movementY=vertical_Search();
						movementX=0;
					}
				}
			}
			posY+=movementY;
			posX+=movementX;
		}
	
		// set collision box
		//r.set(posX, posY, posX + 40, posY + 40);

		//if (Rect.intersects(r, Robot.yellowRed)) {
		//	checkCollision();
		//}

	}
	
	public PathTile searchArray(int next_tileX, int next_tileY) {
		PathTile within=null;
		for(int i=0; i<tilearrayPath.size(); i++) {
			PathTile tile = tilearrayPath.get(i);
			if(tile.getTileX() <= next_tileX && tile.getTileX()+20 >= next_tileX) {
				if(tile.getTileY() <= next_tileY && tile.getTileY()+20 >= next_tileY) {
					within = tile;
				}
			}
		}
		return within;
	}
	
	public int horizantal_Search() {
		int left_tiles = posX-20;
		int right_tiles = posX+20;
		while(left_tiles >=0 && right_tiles <=680) {
			PathTile left = searchArray(left_tiles, posY);
			PathTile right = searchArray(right_tiles, posY);
			if(left.type2 != 's') {
				return speed;
			}
			else if(right.type2 != 's') {
				return speed*(-1);
			}
			left_tiles -=20;
			right_tiles += 20;
		}
		return 0;
	}
	
	public int vertical_Search() {
		int above_tiles = posY-20;
		int below_tiles = posY+20;
		while(above_tiles >= 40 && below_tiles <=360) {
			PathTile above = searchArray(posX, above_tiles);
			PathTile below = searchArray(posX, below_tiles);
			if(above.type2 != 's') {
				return speed;
			}
			else if(below.type2 != 's') {
				return speed*(-1);
			}
			above_tiles -=20;
			below_tiles += 20;
		}
		return 0;
	}
	
/*
	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3)
				|| Rect.intersects(r, Robot.rect4)) {

		}
	}
*/

	public void die() {
		// Remove from screen
		// Increase User Cash Value
	}

	public void attack() {

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isKamakazi() {
		return kamakazi;
	}

	public void setKamakazi(boolean kamakazi) {
		this.kamakazi = kamakazi;
	}
	
}
