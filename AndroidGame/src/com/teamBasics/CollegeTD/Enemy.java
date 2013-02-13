package com.teamBasics.CollegeTD;

import android.graphics.Rect;

public class Enemy {

	private int posX, posY, speed;  					// add power later on
	public static Rect rect = new Rect(0, 0, 0, 0);
	public static Rect yellowRed = new Rect(0, 0, 0, 0);
	//private Robot robot = GameScreen.getRobot();		//later will need to get towers??

	public Rect r = new Rect(0, 0, 0, 0);				//collision box
	public int health = 5;

	
	
	// Behavioral Methods
	public void update() {
		posY += speed;
		//follow();
		//centerX += speedX;
		// set collision box
		r.set(posX, posY, posX + 40, posY + 40);

		//if (Rect.intersects(r, Robot.yellowRed)) {
		//	checkCollision();
		//}

	}
/*
	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3)
				|| Rect.intersects(r, Robot.rect4)) {

		}
	}
*/
	/*public void follow() {

		if (centerX < -95 || centerX > 810) {
			movementSpeed = 0;
		}

		else if (Math.abs(robot.getCenterX() - centerX) < 5) {
			movementSpeed = 0;
		}

		else {

			if (robot.getCenterX() >= centerX) {
				movementSpeed = 1;
			} else {
				movementSpeed = -1;
			}
		}

	}*/

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

}
