package com.teamBasics.CollegeTD;

import java.util.ArrayList;

public class Assignment extends Enemy {
	public Assignment(ArrayList<PathTile> tilearrayPath) {
		super(141, 41, tilearrayPath);
		setSpeed(3);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}
	
	public Assignment(int posX, int posY, ArrayList<PathTile> tilearrayPath) {
		super(posX, posY, tilearrayPath);
		setSpeed(3);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}
}
