
package utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static jdk.nashorn.tools.ShellFunctions.input;


public class Audio {
    
    AudioInputStream menuMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("remix.wav")));
    //AudioInputStream gameMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/audio/super_mario_game.wav")));
    //AudioInputStream gameOverMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/audio/super_mario_game_over.wav")));
    AudioInputStream goombaMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("click.wav")));
    AudioInputStream lifeMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("click.wav")));
    AudioInputStream backMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("Back.wav")));
    AudioInputStream sweetMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("cantStop.wav")));
    AudioInputStream albaMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("Albachiara.wav")));
    AudioInputStream itsMyLifeMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("its_my_life.wav")));
    
    AudioInputStream cantStopMusic = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("sweet.wav")));

    Clip menu_clip;
    //Clip game_clip;
    //Clip game_over_clip;
    Clip goomba_clip;
    Clip life_clip;
    Clip back_clip;
    Clip sweet_clip;
    Clip alba_clip;
    Clip itsmy_clip;
    Clip cant_clip;

    public Audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        
        //this.menu_clip = AudioSystem.getClip();
        //menu_clip.open(menuMusic);
        
        //this.game_clip = AudioSystem.getClip();
        //game_clip.open(menuMusic);
        
        //this.game_over_clip = AudioSystem.getClip();
        //game_over_clip.open(menuMusic);
        
        this.goomba_clip = AudioSystem.getClip();
        goomba_clip.open(goombaMusic);
        
        this.cant_clip = AudioSystem.getClip();
        cant_clip.open(cantStopMusic);
        
        this.life_clip = AudioSystem.getClip();
        life_clip.open(lifeMusic);
        
        this.back_clip = AudioSystem.getClip();
        back_clip.open(backMusic);
        
        this.sweet_clip = AudioSystem.getClip();
        sweet_clip.open(sweetMusic);
        
        this.itsmy_clip = AudioSystem.getClip();
        itsmy_clip.open(itsMyLifeMusic);
        
        this.alba_clip = AudioSystem.getClip();
        alba_clip.open(albaMusic);
        
        
    }
    
    public void PlayMusicMenu(){
        this.menu_clip.setFramePosition(0);
        this.menu_clip.start();
    }
    
    public void StopMusicMenu(){
        this.menu_clip.stop();
        this.menu_clip.close();
    }
    
    public void PlaycantStopMusic(){
        this.cant_clip.setFramePosition(0);
        this.cant_clip.start();
    }
    
    public void StopCantStopMusic(){
        this.cant_clip.stop();
        this.cant_clip.close();
    }
    
    public void PlayBackMusic(){
        this.back_clip.setFramePosition(0);
        this.back_clip.start();
    }
    
    public void StopBackMusic(){
        this.back_clip.stop();
        this.back_clip.close();
    }
    
    public void PlaySweetMusic(){
        this.sweet_clip.setFramePosition(0);
        this.sweet_clip.start();
    }
    
    public void StopSweetMusic(){
        this.sweet_clip.stop();
        this.sweet_clip.close();
    }
    
    public void PlayItsMusic(){
        this.itsmy_clip.setFramePosition(0);
        this.itsmy_clip.start();
    }
    
    public void StopItsMusic(){
        this.itsmy_clip.stop();
        this.itsmy_clip.close();
    }
    
    public void PlayAlbaMusic(){
        this.alba_clip.setFramePosition(0);
        this.alba_clip.start();
    }
    
    public void StopAlbaMusic(){
        this.alba_clip.stop();
        this.alba_clip.close();
    }
    
    /*public void PlayMusicGame(){
        this.game_clip.setFramePosition(0);
        this.game_clip.start();
    }
    
    public void StopMusicGame(){
        this.game_clip.stop();
        this.game_clip.close();
    }
    
    public void PlayMusicGameOver(){
        this.game_over_clip.setFramePosition(0);
        this.game_over_clip.start();
    }
    
    public void StopMusicGameOver(){
        this.game_over_clip.stop();
        this.game_over_clip.close();
    }*/
    
    public void PlayGoombaMusic(){
        this.goomba_clip.setFramePosition(0);
        this.goomba_clip.start();
    }
    
    public void PlayLifeMusic(){
        this.life_clip.setFramePosition(0);
        this.life_clip.start();
    }
}
