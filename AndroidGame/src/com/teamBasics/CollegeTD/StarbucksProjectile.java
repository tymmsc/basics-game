package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

public class StarbucksProjectile extends Projectile {

	public StarbucksProjectile(Enemy target, StarbucksTower tower, int startX, int startY) {
		super(target, tower, startX, startY);
		size = 5;
		speed = 10;
		maxRange = 275;
		Assets.coffee.play(.8f);
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
			g.drawImage(Assets.starbucksProjectile,x,y);
		else if((target.getPosX())<x && (target.getPosY()>y))
			g.drawImage(Assets.starbucksProjectile2,x,y);
		else if((target.getPosX())<x && (target.getPosY()<y))
			g.drawImage(Assets.starbucksProjectile3,x,y);
		else if((target.getPosX())>x && (target.getPosY()>y))
			g.drawImage(Assets.starbucksProjectile4,x,y);
		else if((target.getPosX())==x && (target.getPosY()<y))
			g.drawImage(Assets.starbucksProjectile5,x,y);
		else if((target.getPosX())==x && (target.getPosY()>y))
			g.drawImage(Assets.starbucksProjectile6,x,y);

	}
	
}
