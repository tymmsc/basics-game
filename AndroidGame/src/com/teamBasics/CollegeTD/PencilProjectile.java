package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class PencilProjectile extends Projectile {

	public PencilProjectile(Enemy target, PencilTower tower, int startX, int startY) {
		super(target, tower, startX, startY);
		size = 5;
		speed = 5;
		maxRange = 275;
		Assets.pencil.play(.5f);
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
		if((target.getPosX())>x && (target.getPosY()>y))
			g.drawImage(Assets.pencilProjectile3,x,y);
		else if((target.getPosX())>x && (target.getPosY()<y))
			g.drawImage(Assets.pencilProjectile2,x,y);
		else if((target.getPosX())<x && (target.getPosY()>y))
			g.drawImage(Assets.pencilProjectile4,x,y);
		else if((target.getPosX())==x && (target.getPosY()>y))
			g.drawImage(Assets.pencilProjectile5, x, y);
		else if((target.getPosX())==x && (target.getPosY()<y))
			g.drawImage(Assets.pencilProjectile6, x, y);
		else
			g.drawImage(Assets.pencilProjectile, x, y);
	}
	
}
