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
						if(inBounds(event, 100+365, 200, 250, 25)){
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
						
						// Difficulty Select Option
						if(inBounds(event, 60, 200, 300, 30)){
							SampleGame.difficulty = 1;
						}
						else if(inBounds(event, 60, 230, 300, 30)){
							SampleGame.difficulty = 2;
						}
						else if(inBounds(event, 60, 260, 300, 30)){
							SampleGame.difficulty = 3;
						}
						else if(inBounds(event, 60, 290, 300, 30)){
							SampleGame.difficulty = 4;
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
		g.drawImage(Assets.soundFX, 100+365, 200);
		g.drawImage(Assets.footer, 0, 430);
		if( SampleGame.difficulty == 1 ){
			g.drawImage(Assets.diff1S, 60, 200);
			g.drawImage(Assets.select, 64, 203);
		}
		else{
			g.drawImage(Assets.diff1, 60, 200);
		}
		if( SampleGame.difficulty == 2 ){
			g.drawImage(Assets.diff2S, 60, 230);
			g.drawImage(Assets.select, 64, 232);
		}
		else{
			g.drawImage(Assets.diff2, 60, 230);
		}
		if( SampleGame.difficulty == 3 ){
			g.drawImage(Assets.diff3S, 60, 260);
			g.drawImage(Assets.select, 64, 263);
		}
		else{
			g.drawImage(Assets.diff3, 60, 260);
		}
		if( SampleGame.difficulty == 4 ){
			g.drawImage(Assets.diff4S, 60, 290);
			g.drawImage(Assets.select, 64, 292);
		}
		else{
			g.drawImage(Assets.diff4, 60, 290);
		}		
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