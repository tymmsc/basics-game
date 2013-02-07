package com.teamBasics.CollegeTD;

import java.util.ArrayList;

import com.teamBasics.CollegeTD.Projectile;

import android.graphics.Rect;

public class Tower {

	private int posX, posY;  			// x and y position of tower
	private int fire_rate, damage;
	private int range;					//range of tower would be relative to the tiles surrounding it.
										//Could have tower with range covering all these squares, just 4 of the squares, etc.
	private int level;					//Keep track of how much tower has been upgraded. Will augment towers initial stats
										//Also will change the sprite of the tower
	private int cost, levelup_cost;		//cost of tower and cost to level up tower
	private int cash_back;				//how much tower is worth to sell (also augmented by level)
	private boolean readyToFire = true;

	//In each Tower subclass there can be boolean special abilities of the towers that are unlocked by reaching certain level
	//Or could add them all here and it might make management of towers easier???
	//private boolean splash, slow, poison;
	
	//public static Rect rect = new Rect(0, 0, 0, 0);		
	public static Rect yellowRed = new Rect(0, 0, 0, 0);
	//public Rect r = new Rect(0, 0, 0, 0);\
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public void upgrade() {
		level++;
	}
	
	public void update() {
		//???
	}
	
	public void print_stats() {
		//???
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
	
	//Example of Attribute being augmented by level??
	public int getFire_rate() {
		return fire_rate + ((int) 0.5*level);
	}
	
	public void setFire_rate(int fire_rate) {
		this.fire_rate = fire_rate;
	}
	
	public int getDamage() { //this number should be augmented by level
		return damage + ((int) 0.5*level);
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
	
	public int getCash_back() {
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
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
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
