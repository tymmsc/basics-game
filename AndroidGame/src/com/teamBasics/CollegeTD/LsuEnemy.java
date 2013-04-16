package com.teamBasics.CollegeTD;

import java.util.ArrayList;
import com.teamBasics.framework.Graphics;


public class LsuEnemy extends Enemy{
	public LsuEnemy(ArrayList<PathTile> tilearrayPath, PathTile start, ArrayList<PathTile> endPoints) {
		super(tilearrayPath, start, endPoints);
		setSpeed(2);
		setHealth(5);
		if(start.getType2() == 'b') {
			movementY = speed;
			movementX = 0;	
		}
		else if(start.getType2() == 'B') {
			movementY = -1 * speed;
			movementX = 0;
		}
		else if(start.getType2() == 'g') {
			movementY = 0;
			movementX = speed;
		}
		else {
			movementY = 0;
			movementX = -1*speed;
		}
		size = 18;
	}
	
	public LsuEnemy(ArrayList<PathTile> tilearrayPath) {
		super(141, 41, tilearrayPath);
		setSpeed(2);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}
	
	public LsuEnemy(int posX, int posY, ArrayList<PathTile> tilearrayPath) {
		super(posX, posY, tilearrayPath);
		setSpeed(3);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}

	@Override
	public void draw(Graphics g) {
		if(visible) {
			g.drawImage(Assets.lsuTiger, x, y);		
		}
	}

	//Check to see if any projectiles hit it???
	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		super.pathMove();
		checkCollision();
	}

}
