package com.teamBasics.CollegeTD;
/*
 * This class will contain groups of enemies which constitute one wave of
 * a level.
 */

import java.util.ArrayList;

import com.teamBasics.framework.Graphics;

import android.graphics.Rect;

public class EnemyWave {
	//wave is an arrayList of all the groups of enemies that make up this wave
	private ArrayList<EnemyGroup> wave;
	
	//counts how many updates there have been
	private int count;
	
	//Tells if all the enemies in this wave are dead or not
	private boolean complete;
	
	public EnemyWave() {
		complete = false;
		count = 0;
		wave = new ArrayList<EnemyGroup>();
	}
	
	public void addEnemyGroup(EnemyGroup enemy_group) {
		wave.add(enemy_group);
	}
	
	// Behavioral Methods
	public void update() {
		for(int i=0; i<wave.size(); i++) {
			wave.get(i).update(count);
			if(!(wave.get(i).isAllDead())) {
				complete = false;
			}
		}
		count++;
	}
	
	public int draw(Graphics g) {
		int lives_lost = 0;
		for(int i=0; i<wave.size(); i++) {
			lives_lost += wave.get(i).draw(g);
		}
		return lives_lost;
		
	}
	
	public ArrayList<EnemyGroup> getWave() {
		return wave;
	}

	public void setWave(ArrayList<EnemyGroup> wave) {
		this.wave = wave;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	

}
