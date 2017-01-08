package model.engine;

import kuusisto.tinysound.TinySound;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michal on 08.01.17.
 */
public class MySound {
    Map<String, kuusisto.tinysound.Music> musicStringMap;
    Map<String, kuusisto.tinysound.Sound> soundStringMap;
    public MySound(){
        soundStringMap = new HashMap<>();
        musicStringMap = new HashMap<>();
    }

    public void addSound(File f, String name){
        kuusisto.tinysound.Sound tmp = TinySound.loadSound(f);
        soundStringMap.put(name, tmp);
    }
    public void addMusic(File f, String name){
        kuusisto.tinysound.Music tmp = TinySound.loadMusic(f);
        musicStringMap.put(name, tmp);
    }
    public void playMusic(String name) throws CouldNotFindSound {
        try{
            musicStringMap.get(name).play(true);
        } catch (NullPointerException e){
            throw new CouldNotFindSound();
        }
    }
    public void playSound(String name) throws CouldNotFindSound {
        try{
            soundStringMap.get(name).play();
        } catch (NullPointerException e){
            throw new CouldNotFindSound();
        }
    }
    public void playSound(String name, double lvl) throws CouldNotFindSound {
        try {
            soundStringMap.get(name).play(lvl);
        } catch (NullPointerException e){
            throw new CouldNotFindSound();
        }
    }
    public void playMusic(String name, double lvl) throws CouldNotFindSound {
        try {
            musicStringMap.get(name).play(true, lvl);
        } catch (NullPointerException e){
            throw new CouldNotFindSound();
        }
    }
    public void init(){
        //initialize TinySound
        TinySound.init();
    }
    public void shutDown(){
        TinySound.shutdown();
    }
}
