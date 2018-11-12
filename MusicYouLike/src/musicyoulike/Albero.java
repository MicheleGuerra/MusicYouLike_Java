package musicyoulike;

import gui.GamePanel;
import static gui.MusicYouLike.gamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

public class Albero {

    private Nodo radice;
    private String domanda;
    private int profondita;
    private int taglio;
private Nodo puntatore;
    public Albero() {
        profondita = 0;
        puntatore=radice;
        
    }


    public void setTaglio(int taglio) {
        this.taglio = taglio;
    }

    public void setRadice(Nodo radice) {
        this.radice = radice;
    }

    public Nodo getRadice() {
        return radice;
    }

    /*public void Ricerca(Albero palbero, Nodo pnodo) throws IOException {
        Albero albero;
        albero = palbero;
        Nodo nodo, figlio;
        nodo = pnodo;
        if (nodo.HasFiglio() == true) {
            String n_domanda = nodo.getValore();
            this.domande.add(n_domanda);
            String ris = Leggi();
            if (ris.equals("si")) {
                figlio = nodo.getFiglio_sx();
                this.Ricerca(albero, figlio);
            } 
            if(ris.equals("no")){
                figlio = nodo.getFiglio_dx();
                this.Ricerca(albero, figlio);
            }

        } else {
            String n_domanda = nodo.getValore();
            this.domande.add(n_domanda);
        }

    }*/
    public Nodo Ricerca(Nodo pnodo) throws IOException {

        Nodo nodo;
        nodo = pnodo;
            if (profondita == taglio) {
                puntatore= nodo;
                nodo = nodo.Stima();
            }
            
            String n_domanda = nodo.getValore();
            this.domanda = n_domanda;
            
        profondita++;
        return nodo;
    }

    public int getTaglio() {
        return taglio;
    }

    public Nodo getPuntatore() {
        return puntatore;
    }

    public int getProfondita() {
        return profondita;
    }

    public String Stampa(String a) {

        return a;
    }

    /*public String Leggi() throws IOException {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }*/
    public String getDomande() {
        return domanda;
    }

}
