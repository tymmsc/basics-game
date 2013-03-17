package com.teamBasics.CollegeTD;

import java.util.ArrayList;
import com.teamBasics.framework.Graphics;


public class GeorgiaBulldogEnemy extends Enemy{
	public GeorgiaBulldogEnemy(ArrayList<PathTile> tilearrayPath) {
		super(141, 41, tilearrayPath);
		setSpeed(2);
		setHealth(5);
		movementY = speed;
		movementX = 0;
		size = 20;
	}
	
	public GeorgiaBulldogEnemy(int posX, int posY, ArrayList<PathTile> tilearrayPath) {
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
			g.drawImage(Assets.georgiaBulldog, x, y);		
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
