 package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class StarbucksTower extends Tower {

	public StarbucksTower(int posX, int posY) {
		super(posX, posY);
		size = 40;
		level = 1;
		cooldown = 1000;
		damage = 20;
		range = 75;
		cost = 50;
		levelup_cost= 25;
		cash_back=(int) (cost*0.8);
	}
	
	public void draw(Graphics g) {
		int cooldownInit = 1000;
		int damageInit = 20;
		int rangeInit = 75; 

		if(level == 1) {
			g.drawImage(Assets.cokeTower, posX, posY);
			cooldown = cooldownInit/1; // probably bad form to put this here, but its easier than updating 3 times elsewhere
			damage = damageInit*1;	// cannot just change these values in the constructor because thats only for when the object is made
			range = rangeInit*1;
		} else if(level == 2) {
			g.drawImage(Assets.starbucksTower, posX, posY);
			cooldown = cooldownInit*2/3;
			damage = damageInit*3/2;
			range = rangeInit*3/2;
		} else {
			g.drawImage(Assets.redbullTower, posX, posY);
			cooldown = cooldownInit*2/5;
			damage = damageInit*5/2;
			range = rangeInit*5/2;
		}
	}

	@Override
	public StarbucksProjectile fire(Enemy e) {
		StarbucksProjectile projectile = new StarbucksProjectile(e, this, center.x, center.y);
		return projectile;
	}
	
	
}
