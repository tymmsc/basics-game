package com.teamBasics.CollegeTD;


import com.teamBasics.framework.Image;
import com.teamBasics.framework.Music;
import com.teamBasics.framework.Sound;

public class Assets {
   
    public static Image menu, splash, background; //character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
    
    // Walking dirt paths
    public static Image dirtBottom, dirtLeft, dirtTop, dirtRight, dirtCenter;
    public static Image dirtLBC, dirtLTC, dirtRBC, dirtRTC;
    
    public static Image button;
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