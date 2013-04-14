package com.teamBasics.CollegeTD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.content.Context;


import com.teamBasics.framework.FileIO;
import com.teamBasics.framework.implementation.AndroidGame;

public class SaveState {
    
    // Create variables that will hold the values you want to save in your game.
    // Default values:
    
    public static boolean soundEnabled = true;
    public static int[] numScores= {0,0,0,0,0,0,0,0,0,0,0,0};
    public static String[][] highScoreNames = new String[12][10];// {"One","Two","three"};
    public static int[][] highScores = new int[12][10];// {100,89,4};
    public static int currentLevel = 0;
    public static int scoreTest=1000;
    public static AndroidGame game;

   
    public static void save(FileIO files) {
    /*	String FILENAME = "hello_file";
    	String string = "hello world!";
    	try{
    	FileOutputStream fos = game.openFileOutput(FILENAME, Context.MODE_PRIVATE);
    	fos.write(string.getBytes());
    	fos.close();
        BufferedWriter out = null;
    	}
    	catch(Exception e){
    		System.out.println("exception");
    	}*/
        BufferedWriter out = null;
        try {
            
            // Writes to memory
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile("testsavedata")));
            
            // Line by line ("\n" creates a new line), write the value of each variable to the file.
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");
            
            out.write(Integer.toString(currentLevel));
            out.write("\n");
            out.write(Integer.toString(scoreTest));
            out.write("\n");
            // Uses a for loop to save 5 numbers to the save file.
           
            for ( int l=0; l<12; l++){ //for each level
            	out.write(Integer.toString(numScores[l]));
            out.write("\n");
            int n = numScores[l];
            for (int i = 0; i < n; i++) {
                out.write((highScoreNames[l][i]));
                out.write("\n");
            }
            for (int i = 0; i < n; i++) {
                out.write((highScores[l][i]));
                out.write("\n");
            }
           // This section handles errors in file management!
            }
        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }
    
    public static void load(FileIO files) {
        BufferedReader in = null;
        try {
            // Reads file called Save Data
            in = new BufferedReader(new InputStreamReader(
                    files.readFile("testsavedata")));

            // Loads values from the file and replaces default values.
            soundEnabled = Boolean.parseBoolean(in.readLine());
            currentLevel = Integer.parseInt(in.readLine());
            scoreTest=Integer.parseInt(in.readLine());
      
           for(int l =0;l<12;l++){
            numScores[l]=Integer.parseInt(in.readLine());
            if (numScores[l]>10 || numScores[l]<0){ numScores[l]=0;}
            for (int i = 0; i < numScores[l]; i++) {
                highScoreNames[l][i] = (in.readLine());
            }

            for (int i = 0; i < numScores[l]; i++) {
                highScores[l][i] = (Integer.parseInt(in.readLine()));

            }

           }
        } catch (IOException e) {
            // Catches errors. Default values are used.
        } catch (NumberFormatException e) {
            // Catches errors. Default values are used.
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }
    
    
    // Use this method to add 5 numbers to the high score.
    public static void addScore(int l,String name, int score) {
        //find where this score belongs and add accordingly; increment the index.

    		if(numScores[l]==0){
    			highScoreNames[l][0]=name;
    			highScores[l][0]=score;
    		}
    		else{
    			//find where the score belongs. Say score is 10 and we have 100,29,11,5, 4 null null
    			int i =0; 
    			while(i<numScores[l] && score<highScores[l][i]){         
    				i=i+1;
    			}
    			if(i==10){
    				System.out.println("not a high score.");
    			}
    			else{
    			for(int q=8; q>=i; q--){
    				highScores[l][q+1]=highScores[l][q];
    				highScoreNames[l][q+1]=highScoreNames[l][q];
    			}
    			highScores[l][i]=score;
    			highScoreNames[l][i]=name;
    			}
    		}
    		if(numScores[l]!=10){
    			numScores[l]=numScores[l]+1;
    		}
    }
}
 

/** THIS IS THE NEW ONE



package com.teamBasics.CollegeTD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.content.Context;


import com.teamBasics.framework.FileIO;
import com.teamBasics.framework.implementation.AndroidGame;

public class SaveState {
    
    // Create variables that will hold the values you want to save in your game.
    // Default values:
    
    public static boolean soundEnabled = true;
    public static int numScores=0;
    public static String[] highScoreNames = new String[10];// {"One","Two","three"};
    public static int[] highScores = new int[10];// {100,89,4};
    public static int currentLevel = 0;
    public static AndroidGame game;

   
    public static void save(FileIO files) {
    /*	String FILENAME = "hello_file";
    	String string = "hello world!";
    	try{
    	FileOutputStream fos = game.openFileOutput(FILENAME, Context.MODE_PRIVATE);
    	fos.write(string.getBytes());
    	fos.close();
        BufferedWriter out = null;
    	}
    	catch(Exception e){
    		System.out.println("exception");
    	}*/ /**
        BufferedWriter out = null;
        try {
            
            // Writes to memory
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile("testsavedata")));
            
            // Line by line ("\n" creates a new line), write the value of each variable to the file.
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");
            
            out.write(Integer.toString(currentLevel));
            out.write("\n");
            //out.write(Integer.toString(scoreTest));
           // out.write("\n");
            // Uses a for loop to save 5 numbers to the save file.
            out.write(Integer.toString(numScores));
            out.write("\n");
            int n = numScores;
            for (int i = 0; i < n; i++) {
                out.write((highScoreNames[i]));
                out.write("\n");
            }
            for (int i = 0; i < n; i++) {
                out.write((highScores[i]));
                out.write("\n");
            }
           // This section handles errors in file management!
            
        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }
    
    public static void load(FileIO files) {
        BufferedReader in = null;
        try {
            // Reads file called Save Data
            in = new BufferedReader(new InputStreamReader(
                    files.readFile("testsavedata")));

            // Loads values from the file and replaces default values.
            soundEnabled = Boolean.parseBoolean(in.readLine());
            currentLevel = Integer.parseInt(in.readLine());
           //scoreTest=Integer.parseInt(in.readLine());
            // Uses for loop to load 5 numbers as high score.
            numScores=Integer.parseInt(in.readLine());
            for (int i = 0; i < numScores; i++) {
                highScoreNames[i] = (in.readLine());
            }
            for (int i = 0; i < numScores; i++) {
                highScores[i] = (Integer.parseInt(in.readLine()));
            }
            
        } catch (IOException e) {
            // Catches errors. Default values are used.
        } catch (NumberFormatException e) {
            // Catches errors. Default values are used.
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }
    
    
    // Use this method to add a score to the high score.
    public static void addScore(String name, int score) {
        //find where this score belongs and add accordingly; increment the index.

    		if(numScores==0){
    			highScoreNames[0]=name;
    			highScores[0]=score;
    		}
    		else{
    			//find where the score belongs. Say score is 10 and we have 100,29,11,5, 4 null null
    			int i =0; 
    			while(score<highScores[i] && i<numScores){         
    				i=i+1;
    			}
    			if(i==10){
    				System.out.println("not a high score.");
    			}
    			else{
    			for(int q=8; q>=i; q--){
    				highScores[q+1]=highScores[q];
    				highScoreNames[q+1]=highScoreNames[1];
    			}
    			highScores[i]=score;
    			highScoreNames[i]=name;
    			}
    		}
    		if(numScores!=10){
    			numScores=numScores+1;
    		}
    }
    
}
    			  **/