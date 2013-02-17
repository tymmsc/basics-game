package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class PencilTower extends Tower {

	public PencilTower(int posX, int posY) {
		super(posX, posY);
		size = 40;
		cooldown = 1000;
		damage = 20;
		range = 75;
		level = 1;
		cost = 50;
		levelup_cost= 25;
		cash_back=(int) (cost*0.8);
	}
	
	public void draw(Graphics g) {
		g.drawImage(Assets.pencilTower, posX, posY);
	}

	@Override
	public PencilProjectile fire(Enemy e) {
		PencilProjectile projectile = new PencilProjectile(e, this, center.x, center.y);
		return projectile;
	}
	
	
}
