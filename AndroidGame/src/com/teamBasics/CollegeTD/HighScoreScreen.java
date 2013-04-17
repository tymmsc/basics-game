package com.teamBasics.CollegeTD;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Image;
import com.teamBasics.framework.Input.TouchEvent;
import com.teamBasics.framework.Screen;
import com.teamBasics.CollegeTD.SaveState;

public class HighScoreScreen extends Screen {

	// Variable Setup
	Paint paint, paint2;
	int level;

	public HighScoreScreen(Game game, int l) {
		super(game);
		level=l;
		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.GRAY);
/*		SaveState.addScore(level,"Bob"+level, 10);
		SaveState.addScore(level,"Alice"+level, 20);
		SaveState.addScore(level,"Steve"+level, 5);
		SaveState.addScore(level,"Bob"+level, 10);
		SaveState.addScore(level,"Bob"+level, 10);
		SaveState.addScore(level,"Alice"+level, 20);
		SaveState.addScore(level,"Steve"+level, 5);
		SaveState.addScore(level,"Bob"+level, 10);
		SaveState.addScore(level,"Steve"+level, 5);
		SaveState.addScore(level,"Bob"+level, 10);
		SaveState.addScore(level,"Worst"+level,1);
		SaveState.addScore(level,"Best"+level,100000); */
		
		
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
		g.drawImage(Assets.highscoresbackground, 0, 0);
		int numScores=SaveState.numScores[level];
		for(int i=0;i<numScores;i++){
			String s = SaveState.highScoreNames[level][i]+": "+SaveState.highScores[level][i];
			g.drawString(s, 400, 160+30*i, paint);
		}
		/*g.drawString("User2: 2000000", 400, 160, paint);
		g.drawString("User1: 1000000", 400, 190, paint);
		g.drawString("User2: 2000000", 400, 220, paint);
		g.drawString("User2: 2000000", 400, 250, paint);
		g.drawString("User1: 1000000", 400, 280, paint);
		g.drawString("User2: 2000000", 400, 310, paint);
		g.drawString("User2: 2000000", 400, 340, paint);
		g.drawString("User1: 1000000", 400, 370, paint);
		g.drawString("User2: 2000000", 400, 400, paint);
		g.drawString("User2: 2000000", 400, 430, paint);*/
	
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void backButton() {
		game.setScreen(new HighScoreSelectScreen(game));
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
