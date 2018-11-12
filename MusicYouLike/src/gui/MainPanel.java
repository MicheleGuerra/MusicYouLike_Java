/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import utils.Resources;
import javax.swing.JPanel;
import utils.Audio;

/**
 *
 * @author Marianna
 */
public class MainPanel extends JPanel{
  private Rectangle rectGioca;  
  private Image background;
  public static Audio audio;
  
    
    public MainPanel(){
        this.setSize(MusicYouLike.FRAME_SIZE);
        background = Resources.getImage("/immaginiGui/primaPagina.png");
        this.addMouseListener(new GiocoListener());
        
       rectGioca= new Rectangle(260, 390, (340-260), (470-390));
       this.setVisible(false);
    }
    
  @Override
    protected void paintComponent(Graphics g){
        update(g);
    }
    
  @Override
    public void update (Graphics g){
        g.drawImage(background, 0, 0, getParent());
    }
    
    
    private class GiocoListener extends MouseAdapter{
        @Override
        public void mouseReleased (MouseEvent mouseEvent){
            try {
                audio = new Audio();
                audio.PlayGoombaMusic();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            Point p= mouseEvent.getPoint();
            if(rectGioca.contains(p)){
                MusicYouLike.mainPanel.setVisible(false);
                MusicYouLike.gamePanel.setVisible(true);
                try {
                    MusicYouLike.gamePanel.Set();
                } catch (IOException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
         @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            Point p = mouseEvent.getPoint();
            if (rectGioca.contains(p)) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
    
    
    
    
}
