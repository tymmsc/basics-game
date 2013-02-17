package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Graphics;

import android.graphics.Rect;

//Will become an abstract class
public abstract class Projectile {
	Enemy target;
	protected int x, y;
	protected double speed;
	protected boolean visible;
	protected int size;
	protected Tower tower;
	public Rect r;

	public Projectile(Enemy target, Tower tower, int startX, int startY) {
		this.target = target;
		x = startX;
		y = startY;
		visible = true;
		r = new Rect(0, 0, 0, 0);
	}

	public void move() {
		int posX = target.getPosX();
		int posY = target.getPosY();
		int deltaX = x - posX;
		int deltaY = y - posY;
		double distance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
		int moveX = (int) ((speed*deltaX)/distance);
		int moveY = (int) ((speed*deltaY)/distance);
		x +=moveX;
		y +=moveY;
		r.set(x, y, x+size, y+size);
	}
	
	public abstract void update();
	public abstract void draw(Graphics g);
	
	//Might want to move into individual projectile classes later
	public void checkCollision() {
		if (Rect.intersects(r, target.r)) {
			visible = false;
			int health_remaining = target.getHealth();
			if(health_remaining > 0) {
				health_remaining -= tower.getDamage();
			}
			if(health_remaining <= 0) {
				target.die();
			}
			else {
				target.setHealth(health_remaining);
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(double speed) {
		this.speed = speed;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}