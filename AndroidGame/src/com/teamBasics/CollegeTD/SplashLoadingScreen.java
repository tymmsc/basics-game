package com.teamBasics.CollegeTD;

import com.teamBasics.framework.Game;
import com.teamBasics.framework.Graphics;
import com.teamBasics.framework.Screen;
import com.teamBasics.framework.Graphics.ImageFormat;

public class SplashLoadingScreen extends Screen {
	public SplashLoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.splash0 = g.newImage("splash4_0.png", ImageFormat.RGB565);
		Assets.splash1 = g.newImage("splash4_1.png", ImageFormat.RGB565);
		Assets.splash2 = g.newImage("splash4_2.png", ImageFormat.RGB565);
		Assets.splash3 = g.newImage("splash4_3.png", ImageFormat.RGB565);
		Assets.splash4 = g.newImage("splash4_4.png", ImageFormat.RGB565);
		Assets.splash5 = g.newImage("splash4_5.png", ImageFormat.RGB565);
		Assets.splash6 = g.newImage("splash4_6.png", ImageFormat.RGB565);
		Assets.splash7 = g.newImage("splash4_7.png", ImageFormat.RGB565);
		Assets.splash8 = g.newImage("splash4_8.png", ImageFormat.RGB565);
		Assets.splash9 = g.newImage("splash4_9.png", ImageFormat.RGB565);
		Assets.splash10 = g.newImage("splash4_10.png", ImageFormat.RGB565);
		Assets.splash11 = g.newImage("splash4_11.png", ImageFormat.RGB565);
		Assets.splash12 = g.newImage("splash4_12.png", ImageFormat.RGB565);
		Assets.splash13 = g.newImage("splash4_13.png", ImageFormat.RGB565);
		Assets.splash14 = g.newImage("splash4_14.png", ImageFormat.RGB565);
		Assets.splash15 = g.newImage("splash4_15.png", ImageFormat.RGB565);

		game.setScreen(new LoadingScreen(game));

	}

	@Override
	public void paint(float deltaTime) {

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

	}
}