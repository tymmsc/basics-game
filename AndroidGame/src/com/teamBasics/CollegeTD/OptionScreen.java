package com.teamBasics.CollegeTD;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Graphics.ImageFormat;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;

public class OptionScreen extends Screen {

	// Variable Setup
	Paint paint, paint2;

	public OptionScreen(Game game) {
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

		if( SampleGame.sound == true ){
			Assets.soundFX = Assets.soundFX_on;
		} else {
			Assets.soundFX = Assets.soundFX_off;
		}
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		
		// 1. All touch input is handled here:
				int len = touchEvents.size();
				for (int i = 0; i < len; i++) {
					TouchEvent event = touchEvents.get(i);
					// Handles Touch PRESS
					if (event.type == TouchEvent.TOUCH_UP) {
								
						// Display Selected Item on touch_up(release)
						// SoundFX button
						if(inBounds(event, 100, 200, 250, 25)){
							if(Assets.soundFX == Assets.soundFX_off){
								Assets.soundFX = Assets.soundFX_on;
								Assets.theme.play();
								SampleGame.sound = true;
							}
							else{
								Assets.soundFX = Assets.soundFX_off;
								Assets.theme.pause();
								SampleGame.sound = false;
							}
						}			
					}
				}
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
		g.drawImage(Assets.optionsbackground, 0, 0);
		g.drawImage(Assets.soundFX, 100, 200);
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