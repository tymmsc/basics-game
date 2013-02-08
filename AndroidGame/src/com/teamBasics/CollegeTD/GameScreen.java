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

	private static Background bg1;
	private String descriptionText = "";
	private String scoreText = "0";
	private String livesText = "20";
	private String cashText = "$0";

	private ArrayList<BorderTile> tilearrayBorder = new ArrayList<BorderTile>();
	private ArrayList<PathTile> tilearrayPath = new ArrayList<PathTile>();

	int livesLeft = 20;
	Paint paintInit, paintMenu, paintDescriptionText, paintHUBText;

	public GameScreen(Game game) {
		super(game);

		// Initialize game objects here

		bg1 = new Background(0, 0);
		// hb = new Heliboy(340, 360);
		// character = Assets.character;

		// anim = new Animation();
		// anim.addFrame(character, 1250);
		// anim.addFrame(character2, 50);

		// hanim = new Animation();
		// hanim.addFrame(heliboy, 100);
		// currentSprite = anim.getImage();

		loadMapBorder();
		loadMapPath();

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

	// Load map border
	private void loadMapBorder() {
		ArrayList lines = new ArrayList();
		int width = 0;
		int height = 0;

		Scanner scanner = new Scanner(SampleGame.mapBorder);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			// no more lines to read
			if (line == null) {
				break;
			}

			if (!line.startsWith("!")) {
				lines.add(line);
				width = Math.max(width, line.length());
			}
		}
		height = lines.size();

		// j = y value
		for (int j = 0; j < height; j++) {
			String line = (String) lines.get(j);
			for (int i = 0; i < width; i++) {
				if (i < line.length()) {
					char ch = line.charAt(i);
					BorderTile t = new BorderTile(i, j, Character.getNumericValue(ch));
					tilearrayBorder.add(t);
				}
			}
		}
	}

	// Load walkway-path
	private void loadMapPath() {
		ArrayList lines = new ArrayList();
		int width = 0;
		int height = 0;

		Scanner scanner = new Scanner(SampleGame.mapPath);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			// no more lines to read
			if (line == null) {
				break;
			}

			if (!line.startsWith("!")) {
				lines.add(line);
				width = Math.max(width, line.length());
			}
		}
		height = lines.size();

		// j = y value
		for (int j = 0; j < height; j++) {
			String line = (String) lines.get(j);
			for (int i = 0; i < width; i++) {

				if (i < line.length()) {
					char ch = line.charAt(i);
					PathTile t = new PathTile(i, j, Character.getNumericValue(ch));
					tilearrayPath.add(t);
				}
			}
		}

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

		if (livesLeft == 0) {
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, robot.update();
		// robot.update();
		// if (robot.isJumped()) {
		// currentSprite = Assets.characterJump;
		// } else if (robot.isJumped() == false && robot.isDucked() == false) {
		// currentSprite = anim.getImage();
		// }

		// ArrayList projectiles = robot.getProjectiles();
		// for (int i = 0; i < projectiles.size(); i++) {
		// Projectile p = (Projectile) projectiles.get(i);
		// if (p.isVisible() == true) {
		// p.update();
		// } else {
		// projectiles.remove(i);
		// }
		// }

		updateBorderTiles();
		updatePathTiles();
		
		// hb.update();
		// hb2.update();
		// bg1.update();
		// bg2.update();
		// animate();

		// if (robot.getCenterY() > 500) {
		// state = GameState.GameOver;
		// }
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

	private void updateBorderTiles() {

		for (int i = 0; i < tilearrayBorder.size(); i++) {
			BorderTile t = (BorderTile) tilearrayBorder.get(i);
			t.update();
		}

	}
	
	private void updatePathTiles() {
		for (int i = 0; i < tilearrayPath.size(); i++) {
			PathTile t = (PathTile) tilearrayPath.get(i);
			t.update();
		}

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();

		g.drawImage(Assets.gamescreen, 0, 0);
		// g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
		paintBorderTiles(g);
		paintPathTiles(g);

		// ArrayList projectiles = robot.getProjectiles();
		// for (int i = 0; i < projectiles.size(); i++) {
		// Projectile p = (Projectile) projectiles.get(i);
		// g.drawRect(p.getX(), p.getY(), 10, 5, Color.YELLOW);
		// }
		// First draw the game elements.

		// g.drawImage(currentSprite, robot.getCenterX() - 61,
		// robot.getCenterY() - 63);
		// g.drawImage(hanim.getImage(), hb.getCenterX() - 48,
		// hb.getCenterY() - 48);
		// g.drawImage(hanim.getImage(), hb2.getCenterX() - 48,
		// hb2.getCenterY() - 48);

		// Example:
		// g.drawImage(Assets.background, 0, 0);
		// g.drawImage(Assets.character, characterX, characterY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();

	}

	private void paintBorderTiles(Graphics g) {
		for (int i = 0; i < tilearrayBorder.size(); i++) {
			BorderTile t = (BorderTile) tilearrayBorder.get(i);
			if (t.type != 0) {
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
			}
		}
	}

	private void paintPathTiles(Graphics g) {
		for (int i = 0; i < tilearrayPath.size(); i++) {
			PathTile t = (PathTile) tilearrayPath.get(i);
			if (t.type2 != 0) {
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
			}
		}
	}

	public void animate() {
		// anim.update(10);
		// hanim.update(50);
	}

	private void nullify() {

		// Set all variables to null. You will be recreating them in the
		// constructor.
		paintInit = null;
		bg1 = null;
		// robot = null;
		// hb = null;
		// currentSprite = null;
		// character = null;
		// heliboy = null;
		// anim = null;
		// hanim = null;

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
		
		// Buttons.jpg from top to bottom
		//(Image Image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight)
		//g.drawImage(Assets.button, 0, 285, 0, 0, 65, 65);
		//g.drawImage(Assets.button, 0, 350, 0, 65, 65, 65);
		//g.drawImage(Assets.button, 0, 415, 0, 130, 65, 65);
		//g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);
		
		// Tower sprites
		g.drawImage(Assets.redditTower, 735, 49);
		g.drawImage(Assets.pencilTower, 735, 115);
		g.drawImage(Assets.starbucksTower, 735, 181);
		
		// Upgrade sprites
		g.drawImage(Assets.sleepUp, 735, 245);
		g.drawImage(Assets.socialUp, 735, 309);
		
		g.drawImage(Assets.selectItem, 49, 423);
		g.drawString(descriptionText, 160, 439, paintDescriptionText);
		g.drawString(scoreText, 290, 26, paintHUBText);
		g.drawString(livesText, 516, 26, paintHUBText);
		g.drawString(cashText, 695, 26, paintHUBText);
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

	public static Background getBg1() {
		// TODO Auto-generated method stub
		return bg1;
	}

}