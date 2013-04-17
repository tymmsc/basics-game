//This class will contain a number of enemy waves and a particular map

package com.teamBasics.CollegeTD;

import java.util.ArrayList;
import java.util.Scanner;

import com.teamBasics.framework.Graphics;
import com.teamBasics.CollegeTD.SampleGame;

public class Level {
	//GamePlay Level Info
	private ArrayList<EnemyWave> waves = new ArrayList<EnemyWave>();;
	//private ArrayList<BorderTile> tilearrayBorder = new ArrayList<BorderTile>();
	private ArrayList<PathTile> tilearrayPath = new ArrayList<PathTile>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<PathTile> startTiles = new ArrayList<PathTile>(); 
	ArrayList<PathTile> endTiles = new ArrayList<PathTile>();
	
	//User Info
	private int livesLeft = 40;
	private int cash = 200;
	private int score = 0;
	
	//Will later be used to tell which map to load
	private int level_number;
	private boolean levelComplete;
	
	//Later in the constructor this class can just be given the level number
	//That way each level can have a different map
	public Level(int level_number) {		
		//loadMapBorder();
		loadMapPath();
		startTiles = startPoints();
		//System.out.println("Start tile is: " + startTiles.get(0).getType2());
		//System.out.println("Start tile is: " + startTiles.get(2).getType2());
		endTiles = endPoints();
		loadLevel(level_number);
		setLevel_number(level_number);
		levelComplete = false;
	}
	
	//Adds a wave to the level
	public void addWave(EnemyWave wave) {
		waves.add(wave);
	}
	
	//Update to next level.
	public void loadLevel(int level_number){
		/*
		if( level_number == 1 ){
			EnemyWave wave1 = new EnemyWave();
			EnemyGroup group1 = new EnemyGroup(400, 12);
			EnemyGroup group2 = new EnemyGroup(800, 25);
			EnemyGroup group3 = new EnemyGroup(1200, 25);

			// Add enemies to group
			for(int i=0; i<10; i++) {
				AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
				group1.addEnemy(a);
			}
			for(int i=0; i<10; i++) {
				TeacherEnemy t = new TeacherEnemy(tilearrayPath);
				group2.addEnemy(t);
			}
			for(int i=0; i<10; i++) {
				GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
				group3.addEnemy(g);
			}
		
			// Add groups to wave
			if(group1 != null && group2 != null && group3 != null) {
				wave1.addEnemyGroup(group1);
				wave1.addEnemyGroup(group2);
				wave1.addEnemyGroup(group3);
				waves.add(wave1);
			}
		} // End Level_1

		
		if( level_number == 2 ){
			EnemyWave wave1 = new EnemyWave();
			EnemyGroup group1 = new EnemyGroup(400, 12);
			EnemyGroup group2 = new EnemyGroup(800, 25);
			EnemyGroup group3 = new EnemyGroup(1200, 25);

			// Add enemies to group
			for(int i=0; i<10; i++) {
				AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
				group1.addEnemy(a);
			}
			for(int i=0; i<10; i++) {
				TeacherEnemy t = new TeacherEnemy(tilearrayPath);
				group2.addEnemy(t);
			}
			for(int i=0; i<10; i++) {
				GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
				group3.addEnemy(g);
			}
		
			// Add groups to wave
			if(group1 != null && group2 != null && group3 != null) {
				wave1.addEnemyGroup(group1);
				wave1.addEnemyGroup(group2);
				wave1.addEnemyGroup(group3);
				waves.add(wave1);
			}
		} // End Level_2

		*/
		
		
		if( level_number == 1 || level_number >= 3){
			EnemyWave wave1 = new EnemyWave();
			EnemyGroup group1 = new EnemyGroup(700, 10);
			EnemyGroup group2 = new EnemyGroup(1100, 10);
			EnemyGroup group3 = new EnemyGroup(1700, 5);
			EnemyGroup group4 = new EnemyGroup(1750, 5);
			EnemyGroup group5 = new EnemyGroup(2500, 10);
			EnemyGroup group6 = new EnemyGroup(2550, 10);
			EnemyGroup group7 = new EnemyGroup(2600, 10);
			// Break for new groups
			EnemyGroup group8 = new EnemyGroup(3200, 10);
			EnemyGroup group9 = new EnemyGroup(3300, 10);
			EnemyGroup group10 = new EnemyGroup(4000, 10);
			EnemyGroup group11 = new EnemyGroup(4100, 10);
			EnemyGroup group12 = new EnemyGroup(4700, 10);
			EnemyGroup group13 = new EnemyGroup(4800, 10);
			EnemyGroup group14 = new EnemyGroup(5500, 10);
			EnemyGroup group15 = new EnemyGroup(5550, 10);
			EnemyGroup group16 = new EnemyGroup(6400, 5);
			EnemyGroup group17 = new EnemyGroup(6500, 5);
			EnemyGroup group18 = new EnemyGroup(6600, 5);
			EnemyGroup group19 = new EnemyGroup(7500, 10);
			EnemyGroup group20 = new EnemyGroup(7600, 10);
			EnemyGroup group21 = new EnemyGroup(7700, 10);
			EnemyGroup group22 = new EnemyGroup(8600, 5);
			EnemyGroup group23 = new EnemyGroup(8750, 5);
			EnemyGroup group24 = new EnemyGroup(8900, 5);
			EnemyGroup group25 = new EnemyGroup(9800, 5);
			EnemyGroup group26 = new EnemyGroup(9900, 5);
			EnemyGroup group27 = new EnemyGroup(10000, 5);
			EnemyGroup group28 = new EnemyGroup(10900, 5);
			EnemyGroup group29 = new EnemyGroup(11000, 5);
			EnemyGroup group30 = new EnemyGroup(11100, 5);
			EnemyGroup group31 = new EnemyGroup(11200, 5);
			EnemyGroup boss = new EnemyGroup(12500, 10);
			
			startTiles = startPoints();
			endTiles = endPoints();
			if(startTiles.size() >= 4) {
				// Add enemies to group
				for(int i=0; i<5; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group1.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group2.addEnemy(t);
				}
				for(int i=0; i<5; i++) {
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group3.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group4.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group5.addEnemy(a);
				}
				for(int i=0; i< 5; i++){
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group6.addEnemy(g);
				}

				for(int i=0; i<5; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group7.addEnemy(t);
				}
				//start new groups
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group8.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group9.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group10.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group11.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group12.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group13.addEnemy(g);
				}

				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group14.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group15.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group16.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group17.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group18.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group19.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group20.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group21.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group22.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group23.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group24.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group25.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group26.addEnemy(a);
				}
				for(int i=0; i< 15; i++){
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group27.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group28.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group29.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(2), endTiles);
					group30.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group31.addEnemy(g);
				}
				for (int i=0; i<1; i++){
					TennesseeEnemy t = new TennesseeEnemy(tilearrayPath, startTiles.get(0), endTiles);
					t.setHealth(350);
					boss.addEnemy(t);
				}
			}
			else {
				// Add enemies to group
				for(int i=0; i<5; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group1.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group2.addEnemy(t);
				}
				for(int i=0; i<5; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group3.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group4.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group5.addEnemy(a);
				}
				for(int i=0; i< 5; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group6.addEnemy(g);
				}

				for(int i=0; i<5; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group7.addEnemy(t);
				}
				//start new groups
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group8.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group9.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group10.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group11.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group12.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group13.addEnemy(g);
				}

				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group14.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group15.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group16.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group17.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group18.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group19.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group20.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group21.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group22.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group23.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group24.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group25.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group26.addEnemy(a);
				}
				for(int i=0; i< 15; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group27.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group28.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group29.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group30.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath, startTiles.get(0), endTiles);
					group31.addEnemy(g);
				}
				for (int i=0; i<1; i++){
					TennesseeEnemy t = new TennesseeEnemy(tilearrayPath, startTiles.get(0), endTiles);
					t.setHealth(400);
					boss.addEnemy(t);
				}
			}
			// Add groups to wave
			if(group1 != null && group2 != null && group3 != null && group4 != null && group5 != null) {
				wave1.addEnemyGroup(group1);
				wave1.addEnemyGroup(group2);
				wave1.addEnemyGroup(group3);
				wave1.addEnemyGroup(group4);
				wave1.addEnemyGroup(group5);
				wave1.addEnemyGroup(group6);
				wave1.addEnemyGroup(group7);
				wave1.addEnemyGroup(group8);
				wave1.addEnemyGroup(group9);
				wave1.addEnemyGroup(group10);
				wave1.addEnemyGroup(group11);
				wave1.addEnemyGroup(group12);
				wave1.addEnemyGroup(group13);
				wave1.addEnemyGroup(group14);
				wave1.addEnemyGroup(group15);
				wave1.addEnemyGroup(group16);
				wave1.addEnemyGroup(group17);
				wave1.addEnemyGroup(group18);
				wave1.addEnemyGroup(group19);
				wave1.addEnemyGroup(group20);
				wave1.addEnemyGroup(group21);
				wave1.addEnemyGroup(group22);
				wave1.addEnemyGroup(group23);
				wave1.addEnemyGroup(group24);
				wave1.addEnemyGroup(group25);
				wave1.addEnemyGroup(group26);
				wave1.addEnemyGroup(group27);
				wave1.addEnemyGroup(group28);
				wave1.addEnemyGroup(group29);
				wave1.addEnemyGroup(group30);
				wave1.addEnemyGroup(group31);
				wave1.addEnemyGroup(boss);
				waves.add(wave1);
			}
			
		} // End Level_1 // End Level_1

		
		if( level_number == 2 ){
			EnemyWave wave1 = new EnemyWave();
			EnemyGroup group1 = new EnemyGroup(700, 10);
			EnemyGroup group2 = new EnemyGroup(1100, 10);
			EnemyGroup group3 = new EnemyGroup(1700, 5);
			EnemyGroup group4 = new EnemyGroup(1750, 5);
			EnemyGroup group5 = new EnemyGroup(2500, 10);
			EnemyGroup group6 = new EnemyGroup(2550, 10);
			EnemyGroup group7 = new EnemyGroup(2600, 10);
			// Break for new groups
			EnemyGroup group8 = new EnemyGroup(3200, 10);
			EnemyGroup group9 = new EnemyGroup(3300, 10);
			EnemyGroup group10 = new EnemyGroup(4000, 10);
			EnemyGroup group11 = new EnemyGroup(4100, 10);
			EnemyGroup group12 = new EnemyGroup(4700, 10);
			EnemyGroup group13 = new EnemyGroup(4800, 10);
			EnemyGroup group14 = new EnemyGroup(5500, 10);
			EnemyGroup group15 = new EnemyGroup(5550, 10);
			EnemyGroup group16 = new EnemyGroup(6400, 5);
			EnemyGroup group17 = new EnemyGroup(6500, 5);
			EnemyGroup group18 = new EnemyGroup(6600, 5);
			EnemyGroup group19 = new EnemyGroup(7500, 10);
			EnemyGroup group20 = new EnemyGroup(7600, 10);
			EnemyGroup group21 = new EnemyGroup(7700, 10);
			EnemyGroup group22 = new EnemyGroup(8600, 5);
			EnemyGroup group23 = new EnemyGroup(8750, 5);
			EnemyGroup group24 = new EnemyGroup(8900, 5);
			EnemyGroup group25 = new EnemyGroup(9800, 5);
			EnemyGroup group26 = new EnemyGroup(9900, 5);
			EnemyGroup group27 = new EnemyGroup(10000, 5);
			EnemyGroup group28 = new EnemyGroup(10900, 5);
			EnemyGroup group29 = new EnemyGroup(11000, 5);
			EnemyGroup group30 = new EnemyGroup(11100, 5);
			EnemyGroup group31 = new EnemyGroup(11200, 5);
			EnemyGroup boss = new EnemyGroup(12500, 10); 

			// Add enemies to group
				for(int i=0; i<5; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group1.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group2.addEnemy(t);
				}
				for(int i=0; i<5; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath);
					group3.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group4.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group5.addEnemy(a);
				}
				for(int i=0; i< 5; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
					group6.addEnemy(g);
				}

				for(int i=0; i<5; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group7.addEnemy(t);
				}
				//start new groups
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group8.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group9.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath);
					group10.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group11.addEnemy(t);
				}
				for(int i=0; i< 10; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group12.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
					group13.addEnemy(g);
				}

				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group14.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group15.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group16.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath);
					group17.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group18.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group19.addEnemy(a);
				}
				for(int i=0; i< 10; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
					group20.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group21.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group22.addEnemy(a);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group23.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath);
					group24.addEnemy(g);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group25.addEnemy(t);
				}
				for(int i=0; i< 15; i++){
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group26.addEnemy(a);
				}
				for(int i=0; i< 15; i++){
					GeorgiaBulldogEnemy g = new GeorgiaBulldogEnemy(tilearrayPath);
					group27.addEnemy(g);
				}
				for(int i=0; i<10; i++) {
					TeacherEnemy t = new TeacherEnemy(tilearrayPath);
					group28.addEnemy(t);
				}
				for(int i=0; i<15; i++) {
					AssignmentEnemy a = new AssignmentEnemy(tilearrayPath);
					group29.addEnemy(a);
				}
				for(int i=0; i<15; i++) {
					MaleTeacherEnemy t = new MaleTeacherEnemy(tilearrayPath);
					group30.addEnemy(t);
				}
				for(int i=0; i<10; i++) {
					LsuEnemy g = new LsuEnemy(tilearrayPath);
					group31.addEnemy(g);
				}
				for (int i=0; i<1; i++){
					TennesseeEnemy t = new TennesseeEnemy(tilearrayPath);
					t.setHealth(450);
					boss.addEnemy(t);
				}
		
			// Add groups to wave
			if(group1 != null && group2 != null && group3 != null) {
				wave1.addEnemyGroup(group1);
				wave1.addEnemyGroup(group2);
				wave1.addEnemyGroup(group3);
				wave1.addEnemyGroup(group4);
				wave1.addEnemyGroup(group5);
				wave1.addEnemyGroup(group6);
				wave1.addEnemyGroup(group7);
				wave1.addEnemyGroup(group8);
				wave1.addEnemyGroup(group9);
				wave1.addEnemyGroup(group10);
				wave1.addEnemyGroup(group11);
				wave1.addEnemyGroup(group12);
				wave1.addEnemyGroup(group13);
				wave1.addEnemyGroup(group14);
				wave1.addEnemyGroup(group15);
				wave1.addEnemyGroup(group16);
				wave1.addEnemyGroup(group17);
				wave1.addEnemyGroup(group18);
				wave1.addEnemyGroup(group19);
				wave1.addEnemyGroup(group20);
				wave1.addEnemyGroup(group21);
				wave1.addEnemyGroup(group22);
				wave1.addEnemyGroup(group23);
				wave1.addEnemyGroup(group24);
				wave1.addEnemyGroup(group25);
				wave1.addEnemyGroup(group26);
				wave1.addEnemyGroup(group27);
				wave1.addEnemyGroup(group28);
				wave1.addEnemyGroup(group29);
				wave1.addEnemyGroup(group30);
				wave1.addEnemyGroup(group31);
				wave1.addEnemyGroup(boss);
				waves.add(wave1);
			}
		} // End Level_2
		
	}
	
	//Update 1 wave of the level at a time. Update the first wave you
	//come to that is not complete.
	public void update() {
		//update enemies
		EnemyWave waveToUpdate = null;
		for(int i=0; i<waves.size(); i++) {
			// Enemy waves not complete
			if(!(waves.get(i).isComplete())) {
				waveToUpdate = waves.get(i);
				//break;
			}
			// Enemy waves complete
			else if( i == waves.size()-1 ){
				//LevelLoading.setCurrentLevel(level_number+1);
				//LevelLoading.loadMapPath(level_number+1);
				setLevelComplete(true);
			}
		}
		//update towers
		for(int i=0; i<towers.size(); i++) {
			Projectile projectile = towers.get(i).update(waveToUpdate);
			if(projectile != null) {
				projectiles.add(projectile);
			}
		}
		//update projectiles
		for(int i=0; i<projectiles.size(); i++) {
			if(!(projectiles.get(i).isVisible())) {
				projectiles.remove(i);
			}
			else {
				projectiles.get(i).update();
			}
		}
		if(waveToUpdate != null) {
			waveToUpdate.update();
		}
		else {
			//give user some kind of screen that they won the level
		}
	}
	
	public void draw(Graphics g) {
		//drawing of map happens in gameScreen class
		int lives_lost = 0;
		//draw enemies
		for(int i=0; i<waves.size(); i++) {
			lives_lost += waves.get(i).draw(g);
		}
		//set up for when towers get animations
		for(int i=0; i<towers.size(); i++) {
			towers.get(i).draw(g);
		}
		//draw projectiles
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		livesLeft -= lives_lost*1;
		if(livesLeft < 0 ) {
			livesLeft = 0;
		}
	}
	
	//searches the path to find all the possible start points
		public ArrayList<PathTile> startPoints() {
			ArrayList<PathTile> start = new ArrayList<PathTile>();
			for(int i=0; i<tilearrayPath.size(); i++) {
				PathTile tile = tilearrayPath.get(i);
				if(tile.getType2() == 'b' || tile.getType2() == 'B' || tile.getType2() == 'g' || tile.getType2() == 'G') {
					start.add(tile);
				}
			}
			return start;
		}
		
		//search the path to find all the possible end points
		public ArrayList<PathTile> endPoints() {
			ArrayList<PathTile> end = new ArrayList<PathTile>();
			for(int i=0; i<tilearrayPath.size(); i++) {
				PathTile tile = tilearrayPath.get(i);
				if(tile.getType2() == 'e' || tile.getType2() == 'E' || tile.getType2() == 'f' || tile.getType2() == 'F') {
					end.add(tile);
				}
			}
			return end;
		}
	
	//Updates the cash when an update is called in GameScreen
		int num=0;
		public void checkCash(){
			ArrayList<Enemy> enemies;
			ArrayList<Enemy> allenemies;
			int size=0;
			for(int i=0; i<waves.size(); i++) {
				enemies = waves.get(i).killedEnemies();
				allenemies = waves.get(i).allEnemies();
				//cash=waves.size();
				size=waves.get(i).killedEnemies().size();
				if(num!=size){
					num=size; 
					cash+=5;
					score+=20;
				}
			}
		}
	
	public boolean isKama(ArrayList<Enemy> totalenemies){
		for(int j=0; j<totalenemies.size();j++){
			if(totalenemies.get(j).isKamakazi()){
				return true;
			}
		}
		return false;
	}

	//Will be used later on to load the map for each level
	// Load map border
	/*public void loadMapBorder() {
		ArrayList<String> lines = new ArrayList<String>();
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
	}*/


	// Load walkway-path
	public void loadMapPath() {
		ArrayList<String> lines = new ArrayList<String>();
		int width = 0;
		int height = 0;

		//SampleGame.setCurrentLevel(level_number);
		//SampleGame.loadMapPath(level_number);
		Scanner scanner = new Scanner(LevelSelectScreen.getMapPath());
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
					PathTile t = new PathTile(i, j, ch);
					tilearrayPath.add(t);
				}
			}
		}

	}
	
	
	/*public void paintBorderTiles(Graphics g) {
		for (int i = 0; i < tilearrayBorder.size(); i++) {
			BorderTile t = (BorderTile) tilearrayBorder.get(i);
			if (t.type != 0) {
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
			}
		}
	}*/

	public void paintPathTiles(Graphics g) {
		for (int i = 0; i < tilearrayPath.size(); i++) {
			PathTile t = (PathTile) tilearrayPath.get(i);
			if (t.type2 != 'v') {
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
			}
		}
	}


	/*public void updateBorderTiles() {

		for (int i = 0; i < tilearrayBorder.size(); i++) {
			BorderTile t = (BorderTile) tilearrayBorder.get(i);
			t.update();
		}

	}*/
	
	public void updatePathTiles() {
		for (int i = 0; i < tilearrayPath.size(); i++) {
			PathTile t = (PathTile) tilearrayPath.get(i);
			t.update();
		}

	}

	public ArrayList<EnemyWave> getLevel() {
		return waves;
	}

	public void setLevel(ArrayList<EnemyWave> level) {
		this.waves = level;
	}

	/*public ArrayList<BorderTile> getTilearrayBorder() {
		return tilearrayBorder;
	}

	public void setTilearrayBorder(ArrayList<BorderTile> tilearrayBorder) {
		this.tilearrayBorder = tilearrayBorder;
	}*/

	public ArrayList<PathTile> getTilearrayPath() {
		return tilearrayPath;
	}

	public void setTilearrayPath(ArrayList<PathTile> tilearrayPath) {
		this.tilearrayPath = tilearrayPath;
	}

	public int getLivesLeft() {
		return livesLeft;
	}

	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}
	
	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}
	
	public void addTower(Tower addTower) {
		this.towers.add(addTower);
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel_number() {
		return level_number;
	}

	public void setLevel_number(int level_number) {
		this.level_number = level_number;
	}

	public boolean isLevelComplete() {
		return levelComplete;
	}

	public void setLevelComplete(boolean levelComplete) {
		this.levelComplete = levelComplete;
	}
	
}
