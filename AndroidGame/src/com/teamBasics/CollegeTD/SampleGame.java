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

	public static String mapBorder, mapPath;
	public ArrayList<InputStream> inputSB, inputSP; 
	boolean firstTimeCreate = true;
	private int currentLevel;
	

	@Override
	public Screen getInitScreen() {

		if (firstTimeCreate) {
			Assets.load(this);
			SaveState.load(getFileIO());
			firstTimeCreate = false;
		}

		inputSB = new ArrayList<InputStream>(20);
		inputSP = new ArrayList<InputStream>(20);
		
		// Need to set new level number when user has defeated all enemies on selected map.
		currentLevel = 2; 
				//GameScreen.getCurrentLevel().getLevel_number();

		// Adding Border Map Tile Conversions
		inputSB.add(0, getResources().openRawResource(R.raw.bordermap1));
		inputSB.add(1, getResources().openRawResource(R.raw.bordermap2));
		
		// Adding Path Map Tile Conversions
		inputSP.add(0, getResources().openRawResource(R.raw.pathmap1));
		inputSP.add(1, getResources().openRawResource(R.raw.pathmap2));
		
		// Border and Path Tile Selection based on Level
		mapBorder = convertStreamToString(inputSB.get(currentLevel-1));
		mapPath = convertStreamToString(inputSP.get(currentLevel-1));		

		return new SplashLoadingScreen(this);
	}

	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
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

	@Override
	public void onResume() {
		super.onResume();
		Assets.theme.play();
	}

	@Override
	public void onPause() {
		super.onPause();
		Assets.theme.pause();
	}
	
}