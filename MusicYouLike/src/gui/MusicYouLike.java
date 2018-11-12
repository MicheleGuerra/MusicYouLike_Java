
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resources;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Audio;

public class MusicYouLike extends JFrame{
public static final int FRAME_WIDTH=900;
public static final int FRAME_HEIGT=600;   
public static final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH,FRAME_HEIGT);

public static MainPanel mainPanel;
public static GamePanel gamePanel;
public static Corretto corretto;
public static Errato errato;
public static Audio audio;

//private final Image icon;

public MusicYouLike() throws IOException{
     this.setSize(FRAME_SIZE);
     this.setTitle("Music You Like");
     this.setResizable(false);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     this.setLocationRelativeTo(null);
    // icon=Resources.getImage("");
     
    mainPanel =new MainPanel();
    gamePanel= new GamePanel();
    corretto= new Corretto();
    errato= new Errato();
    
    mainPanel.setVisible(true);
    gamePanel.setVisible(false);
    errato.setVisible(false);
    
    this.getContentPane().add(mainPanel);
    this.getContentPane().add(gamePanel);
    this.getContentPane().add(corretto);
    this.getContentPane().add(errato);
    
}

   public static void main(String[] args) throws IOException {
       MusicYouLike indovinaProf= new MusicYouLike();
       indovinaProf.setVisible(true);
    
       
     
    }
   
   public static void swapPanel(JPanel start, JPanel end){
       start.setVisible(false);
       end.setVisible(true);
   }

    
}

