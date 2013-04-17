package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class PencilTower extends Tower {

	public PencilTower(int posX, int posY) {
		super(posX, posY);
		size = 40;
		level = 1;
		cooldown = 1000;
		damage = 10;
		range = 75;
		cost = 50;
		levelup_cost= 125;
		cash_back=(int) (cost*0.8);
	}
	
	public void draw(Graphics g) {
		int cooldownInit = 1000;
		int damageInit = 10;
		int rangeInit = 75; 

		if(level == 1) {
			g.drawImage(Assets.pencilTower, posX, posY);
			cooldown = cooldownInit/1; // probably bad form to put this here, but its easier than updating 3 times elsewhere
			damage = damageInit*1;	// cannot just change these values in the constructor because thats only for when the object is made
			range = rangeInit*1;
		} else if(level == 2) {
			g.drawImage(Assets.mechanicalPencilTower, posX, posY);
			cooldown = cooldownInit*2/3;
			damage = damageInit*6/5;
			range = rangeInit*6/5;
		} else {
			g.drawImage(Assets.penTower, posX, posY);
			cooldown = cooldownInit*2/5;
			damage = damageInit*7/5;
			range = rangeInit*7/5;
		}
		
		if(powerUpTime == 1) { // sleep
			damage = damageInit*4/3;
		} else if(powerUpTime == 2) { // achedemic
			cooldown = cooldownInit*4/5;
		} else if(powerUpTime == 3) { // social
			range = rangeInit*4/3;
		}
	}

	@Override
	public PencilProjectile fire(Enemy e) {
		PencilProjectile projectile = new PencilProjectile(e, this, center.x, center.y);
		return projectile;
	}
	
	
}
