package com.teamBasics.CollegeTD;
/*
 * This class will contain groups of enemies which constitute one wave of
 * a level.
 */

import java.util.ArrayList;

import com.teamBasics.framework.Graphics;

import android.graphics.Rect;

public class EnemyWave {
	//enemies is an arrayList of Groups of enemies
	private ArrayList<ArrayList<Enemy>> enemies = new ArrayList<ArrayList<Enemy>>();
	
	//delay in terms of number of updates before starting to spawn this group
	private ArrayList<Integer> delay;	
	
	//delay in terms of number of updates between enemy spawns within a group
	private ArrayList<Integer> delay_within;	
	
	//counter for each group which will deal with the internal delays of the class
	//keeps a relative count dependent on time when last enemy was spawned
	private ArrayList<Integer> internal_counter;
	
	//counts how many updates there have been
	private int count;
	
	private boolean complete;
	
	//public Rect r = new Rect(0, 0, 0, 0);
	
	public EnemyWave() {
		complete = false;
		count = 0;
	}
	
	public void addEnemyGroup(ArrayList<Enemy> enemy_group, Integer delay, Integer delay_within ) {
		enemies.add(enemy_group);
		this.delay.add(delay);
		this.delay_within.add(delay_within);
		internal_counter.add(0);
	}
	
	// Behavioral Methods
	public void update() {
		int delay, delay_within, internal_count;
		ArrayList<Enemy> group;
		boolean reset_internal_count = false;
		boolean allDead = true;
		
		for(int i=0; i<enemies.size(); i++) {
			delay = (int) this.delay.get(i);
			if(delay <= count) {
				delay_within = this.delay_within.get(i);
				internal_count = this.internal_counter.get(i);
				group = enemies.get(i);
				for(int j=0; j<group.size(); j++) {
					if(group.get(j).isVisible()) {
						group.get(j).update();						
					}
					else if(internal_count >= delay_within) {
						group.get(j).update();
						internal_count = 0;
						reset_internal_count = true;
					}
					if(!(group.get(j).isDead())) {
						allDead=false;
					}
				}
				if(reset_internal_count == false) {
					internal_count++;					
				}
				internal_counter.set(i, internal_count);
			}
		}
		if(allDead) {
			complete = true;
		}
		count++;
		
		//if (Rect.intersects(r, Enemy.yellowRed)) {
		//	checkCollision();
		//}
	}
	
	public void draw(Graphics g) {
		for(int i=0; i<enemies.size(); i++) {
			ArrayList<Enemy> group = enemies.get(i);
			for(int j=0; j<group.size(); j++) {
				Enemy e = group.get(j);
				if(e.isVisible()) {
					g.drawImage(Assets.assignment, e.getPosX(), e.getPosY()); //Adrian	
				}
				else if(e.isKamakazi()) {
					//lives--;
					e.setKamakazi(false);
				}
			}
		}
		
	}

	public ArrayList<ArrayList<Enemy>> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<ArrayList<Enemy>> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Integer> getDelay() {
		return delay;
	}

	public void setDelay(ArrayList<Integer> delay) {
		this.delay = delay;
	}

	public ArrayList<Integer> getDelay_within() {
		return delay_within;
	}

	public void setDelay_within(ArrayList<Integer> delay_within) {
		this.delay_within = delay_within;
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
