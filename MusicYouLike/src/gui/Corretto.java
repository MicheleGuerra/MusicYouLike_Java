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
import javax.swing.JPanel;
import utils.Resources;

/**
 *
 * @author Marianna
 */
public class Corretto extends JPanel{
    private Rectangle rectHome;  
  private Image background;
  
  
   public Corretto(){
        this.setSize(MusicYouLike.FRAME_SIZE);
        background = Resources.getImage("/immaginiGui/true.png");
        this.addMouseListener(new Corretto.GiocoListener());
        
       rectHome= new Rectangle(300 , 480, (400-300), (560-480));
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
            Point p= mouseEvent.getPoint();
            if(rectHome.contains(p)){
                MusicYouLike.corretto.setVisible(false);
                GamePanel.audio.StopBackMusic();
                GamePanel.audio.StopCantStopMusic();
                GamePanel.audio.StopItsMusic();
                GamePanel.audio.StopSweetMusic();
                MusicYouLike.mainPanel.setVisible(true);
                
            }
            
        }
         @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            Point p = mouseEvent.getPoint();
            if (rectHome.contains(p)) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
  
}
