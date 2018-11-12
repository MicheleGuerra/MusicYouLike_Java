package gui;

import musicyoulike.AlberoCanzoni;
import musicyoulike.Nodo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import utils.Audio;
import utils.Resources;

/**
 *
 * @author Marianna
 */
public class GamePanel extends JPanel {

    private Rectangle rectTrue;
    private Rectangle rectFalse;
    private Image background;
    private AlberoCanzoni albero;
    private String domande;
    private ArrayList<Boolean> risposte;
    private Nodo nodo;
    public static Audio audio;

    public GamePanel() throws IOException {
        this.setSize(MusicYouLike.FRAME_SIZE);
        background = Resources.getImage("/immaginiGui/gamePanel.png");

        this.addMouseListener(new GiocoListener());

        //domande= new ArrayList();
        rectTrue = new Rectangle(151, 420, (269 - 151), ( 530 - 420));
        rectFalse = new Rectangle(291, 415, (416 - 291), (526 -415));
        this.setVisible(false);
    }

    public void Set() throws IOException {
        albero = new AlberoCanzoni();
        this.nodo = albero.Ricerca(albero.getRadice());
    }

    private class GiocoListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            try {
                audio = new Audio();
                audio.PlayLifeMusic();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            Point t = mouseEvent.getPoint();
            
            if (rectTrue.contains(t)) {

                try {
                    if (nodo.HasFiglio() == true) {
                        nodo = albero.Ricerca(nodo.getFiglio_sx());
                    } else {
                        if(nodo.get_progressivo() == 1){
                            //MusicYouLike.audio.StopMusicMenu();
                            audio.PlayBackMusic();
                        }else if(nodo.get_progressivo() == 3){
                            //MusicYouLike.audio.StopMusicMenu();
                            audio.PlayItsMusic();
                        }else if(nodo.get_progressivo() == 5){
                            //MusicYouLike.audio.StopMusicMenu();
                            audio.PlaySweetMusic();
                        }else if(nodo.get_progressivo() == 7){
                            //MusicYouLike.audio.StopMusicMenu();
                            audio.PlayAlbaMusic();
                        }else if(nodo.get_progressivo() == 4){
                            //MusicYouLike.audio.StopMusicMenu();
                            audio.PlaycantStopMusic();
                        }else{
                        
                    }
                        MusicYouLike.gamePanel.setVisible(false);
                        MusicYouLike.corretto.setVisible(true);
                    }
                    repaint();
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rectFalse.contains(t)) {
                try {
                    if (nodo.HasFiglio() == true) {
                        nodo = albero.Ricerca(nodo.getFiglio_dx());
                    } else {
                        if (albero.getProfondita() == albero.getTaglio() + 1) {
                            nodo = albero.getPuntatore();
                            
                        }else{
                        nodo = albero.Ricerca(nodo);
                        MusicYouLike.gamePanel.setVisible(false);
                        MusicYouLike.errato.setVisible(true);
                        }     
                    }
                    repaint();
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, getParent());
        g.setColor(Color.BLACK);
        g.setFont(new Font("", Font.ROMAN_BASELINE, 18));
        g.drawString(albero.getDomande(), 122, 250);

    }

    public static void swapPanel(JPanel start, JPanel end) {
        start.setVisible(false);
        end.setVisible(true);
    }

}
