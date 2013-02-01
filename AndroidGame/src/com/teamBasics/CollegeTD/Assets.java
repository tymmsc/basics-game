package com.teamBasics.CollegeTD;


import com.teamBasics.framework.Image;
import com.teamBasics.framework.Music;
import com.teamBasics.framework.Sound;

public class Assets {
   
    public static Image menu, splash, background; //character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
 
    public static Image splash0, splash1, splash2, splash3, splash4, splash5, splash6, splash7, splash8, splash9, splash10, splash11, splash12, splash13, splash14, splash15;
    
    // Walking dirt paths
    public static Image dirtBottom, dirtLeft, dirtTop, dirtRight, dirtCenter;
    public static Image dirtLBC, dirtLTC, dirtRBC, dirtRTC;
    
    //public static Image button;
    public static Sound click;
    public static Music theme;
   
    public static void load(SampleGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
   
}