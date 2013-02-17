package com.teamBasics.CollegeTD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Graphics.ImageFormat;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;

public class GameScreen extends Screen {
	enum GameState {
		Ready, Running, Paused, GameOver
	}

	GameState state = GameState.Ready;

	// Variable Setup
	private String descriptionText = "";
	private String scoreText = "0";
	private String livesText;
	private String cashText = "$0";

	Paint paintInit, paintMenu, paintDescriptionText, paintHUBText;

	//Levels
	private Level CurrentLevel;
	private Level level1;
	
	public GameScreen(Game game) {
		super(game);

		// Initialize game objects here

		// anim = new Animation();
		// anim.addFrame(character, 1250);
		// anim.addFrame(character2, 50);

		// hanim = new Animation();
		// hanim.addFrame(heliboy, 100);
		// currentSprite = anim.getImage();

		level1 = new Level();
		CurrentLevel = level1;	
		
		// Defining a paint object
		// Start Text
		paintInit = new Paint();
		paintInit.setTextSize(30);
		paintInit.setTextAlign(Paint.Align.CENTER);
		paintInit.setAntiAlias(true);
		paintInit.setColor(Color.GRAY);

		// Back button (options menu)
		paintMenu = new Paint();
		paintMenu.setTextSize(100);
		paintMenu.setTextAlign(Paint.Align.CENTER);
		paintMenu.setAntiAlias(true);
		paintMenu.setColor(Color.LTGRAY);
		
		// Description Text
		paintDescriptionText = new Paint();
		paintDescriptionText.setTextSize(20);
		paintDescriptionText.setTextAlign(Paint.Align.LEFT);
		paintDescriptionText.setAntiAlias(true);
		paintDescriptionText.setColor(Color.CYAN);
		
		// HUB Text
		paintHUBText = new Paint();
		paintHUBText.setTextSize(20);
		paintHUBText.setTextAlign(Paint.Align.RIGHT);
		paintHUBText.setAntiAlias(true);
		paintHUBText.setColor(Color.CYAN);

	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		// We have four separate update methods in this example.
		// Depending on the state of the game, we call different update methods.
		// Refer to Unit 3's code. We did a similar thing without separating the
		// update methods.

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {

		// This example starts with a "Ready" screen.
		// When the user touches the screen, the game begins.
		// state now becomes GameState.Running.
		// Now the updateRunning() method will be called!

		if (touchEvents.size() > 0)
			state = GameState.Running;
	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
		Graphics sel = game.getGraphics();
		// This is identical to the update() method from our Unit 2/3 game.

		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			// Handles Touch PRESS
			if (event.type == TouchEvent.TOUCH_DOWN) {
						
				// Display Selected Item on touch_down(press)
				
				// Reddit Tower
				if(inBounds(event, 735, 49, 40, 40)){
					Assets.selectItem = Assets.redditTower;
					descriptionText = "This is the reddit tower!";
				}
				// Pencil Tower
				else if(inBounds(event, 735, 115, 40, 40)){
					Assets.selectItem = Assets.pencilTower;
					descriptionText = "This is the pencil tower!";
				}
				// Starbucks Tower
				else if(inBounds(event, 735, 181, 40, 40)){
					Assets.selectItem = Assets.starbucksTower;
					descriptionText = "This is the starbucks tower!";
				}
				
				// Sleep Upgrade
				else if(inBounds(event, 735, 245, 40, 40)){
					Assets.selectItem = Assets.sleepUp;
					descriptionText = "This is the sleep upgrade!";
				}
				// Social Upgrade
				else if(inBounds(event, 735, 309, 40, 40)){
					Assets.selectItem = Assets.socialUp;
					descriptionText = "This is the social upgrade!";
				}

			}

			// Handles touch RELEASE
			if (event.type == TouchEvent.TOUCH_UP) {

				if(inBounds(event, 5, 1, 34, 33)){
					pause();
				}
			}

		}

		// 2. Check miscellaneous events like death:

		if (CurrentLevel.getLivesLeft() == 0) {
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happens

		CurrentLevel.updateBorderTiles();
		CurrentLevel.updatePathTiles();
		CurrentLevel.update();
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();

		g.drawImage(Assets.gamescreen, 0, 0);
		// g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
		CurrentLevel.paintBorderTiles(g);
		CurrentLevel.paintPathTiles(g);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver) {
			drawGameOverUI();
		}
		
	}

	private void nullify() {

		// Set all variables to null. You will be recreating them in the
		// constructor.
		paintInit = null;
		level1 = null;
		CurrentLevel=null;

		// Call garbage collector to clean up memory.
		System.gc();
	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(80, 0, 0, 0);
		g.drawString("Tap to Start!", 400, 240, paintInit);

	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();
		
		// Tower sprites
		g.drawImage(Assets.redditTower, 735, 49);
		g.drawImage(Assets.pencilTower, 735, 115);
		g.drawImage(Assets.starbucksTower, 735, 181);
		
		// Upgrade sprites
		g.drawImage(Assets.sleepUp, 735, 245);
		g.drawImage(Assets.socialUp, 735, 309);
		
		g.drawImage(Assets.selectItem, 49, 423);
		g.drawString(descriptionText, 160, 439, paintDescriptionText);
		scoreText = "" + CurrentLevel.getScore();
		g.drawString(scoreText, 290, 26, paintHUBText);
		livesText = "" + CurrentLevel.getLivesLeft();
		g.drawString(livesText, 516, 26, paintHUBText);
		cashText = "$" + CurrentLevel.getCash(); 
		g.drawString(cashText, 695, 26, paintHUBText);
		
		CurrentLevel.draw(g);
	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();
		// Darken the entire screen so you can display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paintMenu);
		g.drawString("Menu", 400, 360, paintMenu);

	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("GAME OVER.", 400, 240, paintMenu);
		g.drawString("Try Again!", 400, 290, paintInit);

	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;

	}

	@Override
	public void resume() {
		if (state == GameState.Paused)
			state = GameState.Running;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {
		pause();
	}

	private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));
	}
}