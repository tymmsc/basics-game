package com.teamBasics.CollegeTD;

import android.graphics.Rect;

public class Enemy {

	private int posX, posY, speed;  					// add power later on
	public static Rect rect = new Rect(0, 0, 0, 0);
	public static Rect yellowRed = new Rect(0, 0, 0, 0);
	//private Robot robot = GameScreen.getRobot();

	public Rect r = new Rect(0, 0, 0, 0);
	public int health = 5;

	private int movementSpeed;

	// Behavioral Methods
	public void update() {
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

}
