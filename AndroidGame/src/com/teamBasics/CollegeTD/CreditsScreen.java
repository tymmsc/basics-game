package com.teamBasics.CollegeTD;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;

public class CreditsScreen extends Screen {

	// Variable Setup
	Paint paint, paint2;

	public CreditsScreen(Game game) {
		super(game);

		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.GRAY);

		// Back button (options menu)
		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.LTGRAY);

	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.creditsbackground, 0, 0);
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void backButton() {
		game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

}