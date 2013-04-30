package com.teamBasics.CollegeTD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.util.Log;

import com.teamBasics.CollegeTD.R;
import com.teamBasics.CollegeTD.GameScreen;
import com.teamBasics.framework.Screen;
import com.teamBasics.framework.implementation.AndroidGame;
import com.teamBasics.CollegeTD.SaveState;

public class SampleGame extends AndroidGame {

	public static ArrayList<InputStream> inputSP; 
	boolean firstTimeCreate = true;
	public static boolean sound;
	public static int difficulty;
	public static int D, D1, D2, D3, D4;
	public static boolean lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10, lvl11, lvl12, exitPrompt;
	public static boolean FF;
	public static int FFinit, FF0, FF1;

	@Override
	public Screen getInitScreen() {

		if (firstTimeCreate) {
			Assets.load(this);
			SaveState.load(getFileIO());
			//currentLevel=SaveState.currentLevel;
			firstTimeCreate = false;
		}

		inputSP = new ArrayList<InputStream>(12);		
		
		// Adding Path Map Tile Conversions
		inputSP.add(0, getResources().openRawResource(R.raw.pathmap1));
		inputSP.add(1, getResources().openRawResource(R.raw.pathmap2));
		inputSP.add(2, getResources().openRawResource(R.raw.pathmap3));
		inputSP.add(3, getResources().openRawResource(R.raw.pathmap4));
		inputSP.add(4, getResources().openRawResource(R.raw.pathmap5));
		inputSP.add(5, getResources().openRawResource(R.raw.pathmap6));
		inputSP.add(6, getResources().openRawResource(R.raw.pathmap7));
		inputSP.add(7, getResources().openRawResource(R.raw.pathmap8));
		inputSP.add(8, getResources().openRawResource(R.raw.pathmap9));
		inputSP.add(9, getResources().openRawResource(R.raw.pathmap10));
		inputSP.add(10, getResources().openRawResource(R.raw.pathmap11));
		inputSP.add(11, getResources().openRawResource(R.raw.pathmap12));
		
		Assets.theme.play();
		sound = true;
		difficulty = 1;
		FF = false;
		
		// Difficulty Variable
		D1 = 1;
		D2 = 1;
		D3 = 2;
		D4 = 2;
		D = D1;
		
		// Fast-forward speed
		FF0 = 1;
		FF1 = 2;
		FFinit = FF0;
		
		lvl1 = false;
		lvl2 = false;
		lvl3 = false;
		lvl4 = false;
		lvl5 = false;
		lvl6 = false;
		lvl7 = false;
		lvl8 = false;
		lvl9 = false;
		lvl10 = false;
		lvl11 = false;
		lvl12 = false;
		exitPrompt = false;
		
		return new SplashLoadingScreen(this);
	}

	public static InputStream getInputSP(int level) {
		return inputSP.get(level-1);
	}
		
	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}

	@Override
	public void onResume() {
		super.onResume();
		//Assets.theme.play();
	}

	@Override
	public void onPause() {
		super.onPause();
		Assets.theme.pause();
	}
	
}
