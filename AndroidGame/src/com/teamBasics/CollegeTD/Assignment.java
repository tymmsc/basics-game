package com.teamBasics.CollegeTD;

import java.util.ArrayList;

public class Assignment extends Enemy {
	public Assignment(int posX, int posY, ArrayList<PathTile> tilearrayPath) {
		super(posX, posY, tilearrayPath);
		setSpeed(5);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}
}
