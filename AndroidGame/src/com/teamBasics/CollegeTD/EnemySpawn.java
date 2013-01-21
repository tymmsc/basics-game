package com.teamBasics.CollegeTD;

import android.graphics.Rect;

public class EnemySpawn {

	private int power, posX, posY, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	//private Robot robot = GameScreen.getRobot();

	public Rect r = new Rect(0, 0, 0, 0);
	public int health = 5;

	private int movementSpeed;

	// Behavioral Methods
	public void update() {
		r.set(posX, posY, posX + 40, posY + 40);

		if (Rect.intersects(r, Enemy.yellowRed)) {
			checkCollision();
		}

	}

	private void checkCollision() {
		if (Rect.intersects(r, Enemy.rect)) {

		}
	}

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

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}
