package com.teamBasics.CollegeTD;

import android.graphics.Rect;

import com.teamBasics.framework.Image;

public class PathTile {

	// Path tile positions
	private int tileX, tileY; //speedX;
	public int type2;
	
	// Image used for Path tiles
	public Image tileImage2;
	
	// Used for collision detection
	private Rect r;

	//private Robot robot = GameScreen.getRobot();
	//private Background bg = GameScreen.getBg1();

	public PathTile(int x, int y, int typeInt) {
		tileX = x * 40;
		tileY = y * 40;

		type2 = typeInt;

		r = new Rect();

		// Center Tile
		if (type2 == 5) {
			tileImage2 = Assets.dirtCenter;
			
		// Side Tiles
		} else if (type2 == 8) {
			tileImage2 = Assets.dirtTop;
		} else if (type2 == 4) {
			tileImage2 = Assets.dirtLeft;

		} else if (type2 == 6) {
			tileImage2 = Assets.dirtRight;

		} else if (type2 == 2) {
			tileImage2 = Assets.dirtBottom;
			
		// Corner Tiles
		} else if (type2 == 1) {
			tileImage2 = Assets.dirtLBC;
		} else if (type2 == 7) {
			tileImage2 = Assets.dirtLTC;
		} else if (type2 == 3) {
			tileImage2 = Assets.dirtRBC;
		} else if (type2 == 9) {
			tileImage2 = Assets.dirtRTC;
		} else {
			type2 = 0;
		}

	}

	public void update() {
		//tileX += speedX;
		
		// Set collision box
		r.set(tileX, tileY, tileX + 40, tileY + 40);

		//if (Rect.intersects(r, Robot.yellowRed) && type != 0) {
		//	checkVerticalCollision(Robot.rect, Robot.rect2);
		//	checkSideCollision(Robot.rect3, Robot.rect4, Robot.footleft,
		//			Robot.footright);
		//}

	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public Image getTileImage() {
		return tileImage2;
	}

	public void setTileImage(Image tileImage2) {
		this.tileImage2 = tileImage2;
	}

	/*
	public void checkVerticalCollision(Rect rtop, Rect rbot) {
		if (Rect.intersects(rtop, r)) {

		}

		if (Rect.intersects(rbot, r) && type == 8) {
			robot.setJumped(false);
			robot.setSpeedY(0);
			robot.setCenterY(tileY - 63);
		}
	}*/

	/*
	public void checkSideCollision(Rect rleft, Rect rright, Rect leftfoot,
			Rect rightfoot) {
		if (type != 5 && type != 2 && type != 0) {
			if (Rect.intersects(rleft, r)) {
				robot.setCenterX(tileX + 102);

				robot.setSpeedX(0);

			} else if (Rect.intersects(leftfoot, r)) {

				robot.setCenterX(tileX + 85);
				robot.setSpeedX(0);
			}

			if (Rect.intersects(rright, r)) {
				robot.setCenterX(tileX - 62);

				robot.setSpeedX(0);
			}

			else if (Rect.intersects(rightfoot, r)) {
				robot.setCenterX(tileX - 45);
				robot.setSpeedX(0);
			}
		}
	}*/

}