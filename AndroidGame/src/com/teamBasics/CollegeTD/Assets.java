package com.teamBasics.CollegeTD;
// Class where all game Image and Sound/Music objects are declared

import com.teamBasics.framework.Image;
import com.teamBasics.framework.Music;
import com.teamBasics.framework.Sound;

public class Assets {
   
    public static Image mainmenu, splash, gamescreen, menubackground, blank;
    
    // Background Images
    public static Image optionsbackground, highscoresbackground, resumebackground, creditsbackground, levelbackground;
    public static Image space, ltDirtCenter, ltDirtRight;
    public static Image map1, map2, map3, map4;
    
    // Level Select Sprites
    public static Image level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12, exitPrompt;
 
    // Splash Loading Images
    public static Image splash0, splash1, splash2, splash3, splash4, splash5, splash6, splash7, 
    					splash8, splash9, splash10, splash11, splash12, splash13, splash14, splash15;
    
    // Border Tiles
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight;

    // Path Tiles
    public static Image dirtBottom, dirtLeft, dirtTop, dirtRight, dirtCenter;
    public static Image dirtLBC, dirtLTC, dirtRBC, dirtRTC;
    public static Image stoneBottom, stoneLeft, stoneTop, stoneRight, stoneCenter;
    public static Image stoneLBC, stoneLTC, stoneRBC, stoneRTC;
    
    // Tower Sprites
    public static Image selectItem, description, option0, option1, option2;
    public static Image facebookTower, redditTower, netflixTower;
    public static Image pencilTower, mechanicalPencilTower, penTower;
    public static Image cokeTower, starbucksTower, redbullTower;
    public static Image towerBox, emptyTower;
    public static Image sleepUp, socialUp, academicUp, lowCost, rangeExtend, lowCooldown, sell, upgrade, downgrade;
    
    //Enemy Sprites
    public static Image assignment, teacher, georgiaBulldog, lsuTiger, tennesseeVols, maleTeacher;
    
    //Projectile Sprites
    public static Image pencilProjectile, pencilProjectile2, pencilProjectile3, pencilProjectile4, pencilProjectile5, pencilProjectile6;
    public static Image redditProjectile, redditProjectile2, redditProjectile3;
    public static Image starbucksProjectile, starbucksProjectile2, starbucksProjectile3, starbucksProjectile4, starbucksProjectile5, starbucksProjectile6;
    
    //Options Menu Sprites
    public static Image soundFX, soundFX_on, soundFX_off, levelSelect_box, footer, select;
    public static Image diff1, diff1S, diff2, diff2S, diff3, diff3S, diff4, diff4S;
    
    //public static Image button;
    public static Sound click;
    public static Sound laser, pencil, coffee, upgradeT;
    public static Music theme, even, odd;
   
    public static void load(SampleGame sampleGame) {
        // Method for creating a looping game theme @ 85% max vol.
    	even = sampleGame.getAudio().createMusic("MusicBackgrounds/Even.mp3");
    	even.setLooping(true);
        even.setVolume(0.85f);
        
    	odd = sampleGame.getAudio().createMusic("MusicBackgrounds/Odd.mp3");
    	odd.setLooping(true);
        odd.setVolume(0.85f);
        
        theme = sampleGame.getAudio().createMusic("MusicBackgrounds/Start.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
   
}