
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
public class Errato extends JPanel{
       private Rectangle rectH;  
  private Image background;
  
   public Errato(){
        this.setSize(MusicYouLike.FRAME_SIZE);
        background = Resources.getImage("/immaginiGui/fine.png");
        this.addMouseListener(new Errato.GiocoListener());
        
       rectH= new Rectangle(260 , 420, (350-260), (500-420));
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
            if(rectH.contains(p)){
                MusicYouLike.errato.setVisible(false);
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
            if (rectH.contains(p)) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
  
  
}
