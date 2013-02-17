package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class PencilProjectile extends Projectile {

	public PencilProjectile(Enemy target, PencilTower tower, int startX, int startY) {
		super(target, tower, startX, startY);
		size = 5;
		speed = 5;
		maxRange = 275;
	}

	@Override
	public void update() {
		if(visible){
		super.move();
		super.checkCollision();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Assets.pencilProjectile, x, y);
	}
	
}
