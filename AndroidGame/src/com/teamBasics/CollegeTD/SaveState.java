package com.teamBasics.CollegeTD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.teamBasics.framework.FileIO;

public class SaveState {
    
    // Create variables that will hold the values you want to save in your game.
    // Default values:
    
    public static boolean soundEnabled = true;
    public static int[] highscores = new int[] { 1951, 800, 120, 75, 3};
    public static int currentLevel = 0;


   
    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            
            // Writes a file called .savedata to the SD Card
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".savedata")));
            
            // Line by line ("\n" creates a new line), write the value of each variable to the file.
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");
            
            out.write(Integer.toString(currentLevel));
            out.write("\n");
       
            // Uses a for loop to save 5 numbers to the save file.
            for (int i = 0; i < 5; i++) {
                out.write(Integer.toString(highscores[i]));
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
                    files.readFile(".savedata")));

            // Loads values from the file and replaces default values.
            soundEnabled = Boolean.parseBoolean(in.readLine());
            currentLevel = Integer.parseInt(in.readLine());

            // Uses for loop to load 5 numbers as high score.
            for (int i = 0; i < 5; i++) {
                highscores[i] = Integer.parseInt(in.readLine());
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
    public static void addScore(int score) {
        for (int i = 0; i < 5; i++) {
            if (highscores[i] < score) {
                for (int j = 4; j > i; j--)
                    highscores[j] = highscores[j - 1];
                highscores[i] = score;
                break;
            }
        }
    }
}
 