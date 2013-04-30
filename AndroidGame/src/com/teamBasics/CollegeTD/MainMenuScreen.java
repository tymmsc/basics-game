package com.teamBasics.CollegeTD;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Screen;
import com.teamBasics.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	
	Paint paintInit; 
	
	public MainMenuScreen(Game game) {
		super(game);
		
		// Defining a paint object
		paintInit = new Paint();
		paintInit.setTextSize(30);
		paintInit.setTextAlign(Paint.Align.CENTER);
		paintInit.setAntiAlias(true);
		paintInit.setColor(Color.rgb(0, 145, 145));
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

				// Get rid of exitPrompt if currently showing
				if( SampleGame.exitPrompt == true ){
					if (inBounds(event, 0, 0, 800, 480)) {
						SampleGame.exitPrompt = false;
					}
				}
				else{
				// New Game Button
				if (inBounds(event, 54, 204, 225, 50)) {
					if( SampleGame.lvl1 == false ){
						SampleGame.lvl1 = true;
						LevelSelectScreen.loadMapPath(1);
						game.setScreen(new GameScreen(game, 1));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Resume Game Button
				else if (inBounds(event, 296, 204, 225, 50)) {
					//game.setScreen(new ResumeGameScreen(game));
					game.setScreen(new LevelSelectScreen(game));
				}				
				
				// High Scores Button
				else if (inBounds(event, 54, 286, 225, 50)) {
					game.setScreen(new HighScoreSelectScreen(game));
				}				
				
				// Options Button
				else if (inBounds(event, 296, 286, 225, 50)) {
					game.setScreen(new OptionScreen(game));
				}				
				
				// Credits Button
				else if (inBounds(event, 54, 368, 225, 50)) {
					game.setScreen(new CreditsScreen(game));
				}
				
				// Exit Game Button
				else if (inBounds(event, 296, 368, 225, 50)) {
					android.os.Process.killProcess(android.os.Process.myPid());
				}
				} // End of If Prompt Check
			}
		}
	}

	// Check if keypress is within certain boundaries
	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.mainmenu, 0, 0);
		
		if( SampleGame.exitPrompt == true ){
			g.drawImage(Assets.exitPrompt, 90, 155);
			g.drawARGB(50, 0, 0, 0);
			g.drawString("Cannot Access an Already Played Level!", 400, 200, paintInit);
			g.drawString("Please Go to Resume Game/Level Select.", 400, 230, paintInit);
		}
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {
		android.os.Process.killProcess(android.os.Process.myPid());

	}
}