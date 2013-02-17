package com.teamBasics.CollegeTD;

import android.graphics.Rect;

import com.teamBasics.framework.Image;

public class Tile {

	// Path tile positions
	private int tileX, tileY;
	public int type;
	
	// Image used for Path tiles
	public Image tileImage;

	//Used for collision detection
	private Rect r;

	public Tile(int x, int y, int typeInt) {
		tileX = x * 40;
		tileY = y * 40;

		type = typeInt;
		r = new Rect();

	}

	
	public void update() {
		//speedX = bg.getSpeedX() * 5;
		//tileX += speedX;
		
		// Set collision box
		r.set(tileX, tileY, tileX + 40, tileY + 40);

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
		return tileImage;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

}