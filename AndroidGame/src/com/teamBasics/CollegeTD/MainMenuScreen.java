package com.teamBasics.CollegeTD;

import java.util.List;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Screen;
import com.teamBasics.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	public MainMenuScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

				// New Game Button
				if (inBounds(event, 54, 204, 225, 50)) {
					LevelSelectScreen.loadMapPath(1);
					game.setScreen(new GameScreen(game, 1));
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