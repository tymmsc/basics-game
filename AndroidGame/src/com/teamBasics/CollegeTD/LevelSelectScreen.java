package com.teamBasics.CollegeTD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;

public class LevelSelectScreen extends Screen {

	// Variable Setup
	Paint paintInit, paint, paint2;
	public static String mapPath;
	public int row1, row2;

	public LevelSelectScreen(Game game) {
		super(game);
		
		// Defining a paint object
		paintInit = new Paint();
		paintInit.setTextSize(30);
		paintInit.setTextAlign(Paint.Align.CENTER);
		paintInit.setAntiAlias(true);
		paintInit.setColor(Color.rgb(0, 145, 145));
		
		paint = new Paint();
		paint.setTextSize(25);
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

	public static String getMapPath() {
		return mapPath;
	}

	public static void setMapPath(String mapPath) {
		LevelSelectScreen.mapPath = mapPath;
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
				// Level 1 Select
				if (inBounds(event, 50-12, 200-60, 100, 100)) {
					if( SampleGame.lvl1 == false ){
						SampleGame.lvl1 = true;
						loadMapPath(1);
						game.setScreen(new GameScreen(game, 1));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 2 Select
				else if (inBounds(event, 175-12, 200-60, 100, 100)) {
					if( SampleGame.lvl2 == false ){
						SampleGame.lvl2 = true;
						loadMapPath(2);
						game.setScreen(new GameScreen(game, 2));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}				

				// Level 3 Select
				else if (inBounds(event, 300-12, 200-60, 100, 100)) {
					if( SampleGame.lvl3 == false ){
						SampleGame.lvl3 = true;
						loadMapPath(3);
						game.setScreen(new GameScreen(game, 3));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 4 Select
				else if (inBounds(event, 425-12, 200-60, 100, 100)) {
					if( SampleGame.lvl4 == false ){
						SampleGame.lvl4 = true;
						loadMapPath(4);
						game.setScreen(new GameScreen(game, 4));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}	
				
				// Level 5 Select
				else if (inBounds(event, 550-12, 200-60, 100, 100)) {
					if( SampleGame.lvl5 == false ){
						SampleGame.lvl5 = true;
						loadMapPath(5);
						game.setScreen(new GameScreen(game, 5));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 6 Select
				else if (inBounds(event, 675-12, 200-60, 100, 100)) {
					if( SampleGame.lvl6 == false ){
						SampleGame.lvl6 = true;
						loadMapPath(6);
						game.setScreen(new GameScreen(game, 6));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}	
				
				// Level 7 Select
				else if (inBounds(event, 50-12, 325-50, 100, 100)) {
					if( SampleGame.lvl7 == false ){
						SampleGame.lvl7 = true;
						loadMapPath(7);
						game.setScreen(new GameScreen(game, 7));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 8 Select
				else if (inBounds(event, 175-12, 325-50, 100, 100)) {
					if( SampleGame.lvl8 == false ){
						SampleGame.lvl8 = true;
						loadMapPath(8);
						game.setScreen(new GameScreen(game, 8));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 9 Select
				else if (inBounds(event, 300-12, 325-50, 100, 100)) {
					if( SampleGame.lvl9 == false ){
						SampleGame.lvl9 = true;
						loadMapPath(9);
						game.setScreen(new GameScreen(game, 9));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 10 Select
				else if (inBounds(event, 425-12, 325-50, 100, 100)) {
					if( SampleGame.lvl10 == false ){
						SampleGame.lvl10 = true;
						loadMapPath(10);
						game.setScreen(new GameScreen(game, 10));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}					
				
				// Level 11 Select
				else if (inBounds(event, 550-12, 325-50, 100, 100)) {
					if( SampleGame.lvl11 == false ){
						SampleGame.lvl11 = true;
						loadMapPath(11);
						game.setScreen(new GameScreen(game, 11));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				
				// Level 12 Select
				else if (inBounds(event, 675-12, 325-50, 100, 100)) {
					if( SampleGame.lvl12 == false ){
						SampleGame.lvl12 = true;
						loadMapPath(12);
						game.setScreen(new GameScreen(game, 12));
					}
					else{
						SampleGame.exitPrompt = true;
					}
				}
				} // End of If Prompt Check
			}
		}
	}

	public static void loadMapPath(int currentL){
		mapPath = convertStreamToString(SampleGame.getInputSP(currentL));
	}
	
	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append((line + "\n"));
			}
		} catch (IOException e) {
			Log.w("LOG", e.getMessage());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Log.w("LOG", e.getMessage());
			}
		}
		return sb.toString();
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
		row1 = 200-60;
		row2 = 325-50;
		g.drawImage(Assets.levelbackground, 0, 0);
		g.drawImage(Assets.footer, 0, 430);
		
		// Row 1
		// Level 1
		g.drawImage(Assets.levelSelect_box, 50-12, row1);
		g.drawImage(Assets.level1, 55-12, 220-60);
		
		// Level 2
		g.drawImage(Assets.levelSelect_box, 175-12, row1);
		g.drawImage(Assets.level2, 180-12, 220-60);
		
		// Level 3
		g.drawImage(Assets.levelSelect_box, 300-12, row1);
		g.drawImage(Assets.level3, 305-12, 220-60);
			
		// Level 4
		g.drawImage(Assets.levelSelect_box, 425-12, row1);
		g.drawImage(Assets.level4, 430-12, 220-60);
				
		// Level 5
		g.drawImage(Assets.levelSelect_box, 550-12, row1);
		g.drawImage(Assets.level5, 555-12, 220-60);
				
		// Level 6
		g.drawImage(Assets.levelSelect_box, 675-12, row1);
		g.drawImage(Assets.level6, 680-12, 220-60);

		// Row 2
		// Level 7
		g.drawImage(Assets.levelSelect_box, 50-12, row2);
		g.drawImage(Assets.level7, 55-12, 345-50);
		
		// Level 8
		g.drawImage(Assets.levelSelect_box, 175-12, row2);
		g.drawImage(Assets.level8, 180-12, 345-50);
		
		// Level 9
		g.drawImage(Assets.levelSelect_box, 300-12, row2);
		g.drawImage(Assets.level9, 305-12, 345-50);
		
		// Level 10
		g.drawImage(Assets.levelSelect_box, 425-12, row2);
		g.drawImage(Assets.level10, 430-12, 345-50);
		
		// Level 11
		g.drawImage(Assets.levelSelect_box, 550-12, row2);
		g.drawImage(Assets.level11, 555-12, 345-50);
			
		// Level 12
		g.drawImage(Assets.levelSelect_box, 675-12, row2);
		g.drawImage(Assets.level12, 680-12, 345-50);
		
		// Text
		g.drawString("Level 1", 100-12, 290-60, paint);
		g.drawString("Level 2", 225-12, 290-60, paint);
		g.drawString("Level 3", 350-12, 290-60, paint);
		g.drawString("Level 4", 475-12, 290-60, paint);
		g.drawString("Level 5", 600-12, 290-60, paint);
		g.drawString("Level 6", 725-12, 290-60, paint);
		
		g.drawString("Level 7", 100-12, 415-50, paint);
		g.drawString("Level 8", 225-12, 415-50, paint);
		g.drawString("Level 9", 350-12, 415-50, paint);
		g.drawString("Level 10", 475-12, 415-50, paint);
		g.drawString("Level 11", 600-12, 415-50, paint);
		g.drawString("Level 12", 725-12, 415-50, paint);
		
		if( SampleGame.exitPrompt == true ){
			g.drawImage(Assets.exitPrompt, 90, 155);
			g.drawARGB(50, 0, 0, 0);
			g.drawString("Cannot Access an Already Played Level!", 400, 200, paintInit);
			g.drawString("Please Select a Different Level to Play.", 400, 230, paintInit);
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