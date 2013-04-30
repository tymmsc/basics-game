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
