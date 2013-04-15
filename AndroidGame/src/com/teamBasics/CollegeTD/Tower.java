package com.teamBasics.CollegeTD;

import java.util.ArrayList;

import com.teamBasics.CollegeTD.Projectile;
import com.teamBasics.framework.Graphics;

import android.graphics.Point;
import android.graphics.Rect;

public abstract class Tower {

	protected int posX, posY, posX_right, posY_bottom;  // x and y position of tower
	protected Point center;		//
	protected int cooldown, damage;				//cooldown should be in milliseconds
	protected int range;						//Radius of tower
	protected int level;						//Keep track of how much tower has been upgraded. Will augment towers initial stats
	protected int powerUpTime;									//Also will change the sprite of the tower
	protected int size;						//Tells you the dimensions of the tower. Ex: size=20 means tower is 20 x 20 pixels
	
	protected int cost, levelup_cost;		//cost of tower and cost to level up tower
	protected int cash_back;				//how much tower is worth to sell (also augmented by level)
	protected boolean readyToFire;
	
	protected long TimeFired;
	//In each Tower subclass there can be boolean special abilities of the towers that are unlocked by reaching certain level
	//Or could add them all here and it might make management of towers easier???
	//private boolean splash, slow, poison;
	
	public Tower(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		posX_right = posX+40;
		posY_bottom = posY+40;
		center = new Point(posX+(size/2),  posY+(size/2));
		readyToFire = true;
		TimeFired = 0;
	}
	
	public void upgrade() {
		level++;
		Assets.upgradeT.play(.5f);
	}
	
	public Projectile update(EnemyWave wave) {
		Projectile projectile = null;
		if(TimeFired <= System.currentTimeMillis()-cooldown) {
			readyToFire = true;
		}
		if(readyToFire) {
			ArrayList<Enemy> activeEnemies = wave.activeEnemies();
			for(int i=0; i<activeEnemies.size(); i++) {
				if(withinRange(activeEnemies.get(i)) && readyToFire) {
					projectile = fire(activeEnemies.get(i));
					TimeFired = System.currentTimeMillis();
					readyToFire = false;
				}
			}
		}
		return projectile;
	}

	//Sees if the enemy passed you are checking to see if it is within range
	private boolean withinRange(Enemy e) {
		Rect r = e.r; //Get the collision box from the 
		Point rectCenter = new Point((int) r.exactCenterX(), (int) r.exactCenterY());
		if (Math.abs(center.x - rectCenter.x) <= (e.getSize()/2 + range))  {
			if (Math.abs(center.y - rectCenter.y) <= (e.getSize()/2 + range))  {
				return true;
			}
		}
		return false;	
	}

	public abstract Projectile fire(Enemy e);
	
	public void print_stats() {
		//???
	}
	
	public abstract void draw(Graphics g);
	
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
	public int getPosX_right() {
		return posX_right;
	}
	
	public void setPosX_right(int posX_right) {
		this.posX_right = posX_right;
	}
	
	public int getPosY_bottom() {
		return posY_bottom;
	}
	
	public void setPosY_bottom(int posY_bottom) {
		this.posY = posY_bottom;
	}
	//Example of Attribute being augmented by level??
	public int getCooldown() {
		return cooldown + ((int) 0.5*level);
	}
	
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public int getDamage() { //this number should be augmented by level
		return damage; //+ ((int) 0.5*level);
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPowerUpTime() {
		return powerUpTime;
	}
	
	public void setPowerUpTime(int powerUpTime) {
		this.powerUpTime = powerUpTime;
	}
	
	public int getCash_back() {
		//Assets.sellT.play(.5f);
		return cash_back;
	}
	
	public void setCash_back(int cash_back) {
		this.cash_back = cash_back;
	}
	
	public boolean isReadyToFire() {
		return readyToFire;
	}
	
	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getLevelup_cost() {
		return levelup_cost;
	}

	public void setLevelup_cost(int levelup_cost) {
		this.levelup_cost = levelup_cost;
	}
}
