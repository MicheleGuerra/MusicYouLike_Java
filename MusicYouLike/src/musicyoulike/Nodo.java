package musicyoulike;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Nodo {

    private Nodo figlio_sx;
    private Nodo figlio_dx;
    String valore;
    int n_materie;
    int progressivo;
    private ArrayList<Nodo> foglie;

    public Nodo(Nodo pfiglio_sx, Nodo pfiglio_dx, String pvalore, int materie, int progres) {
        this.figlio_dx = pfiglio_dx;
        this.figlio_sx = pfiglio_sx;
        this.valore = pvalore;
        this.progressivo = progres;
        foglie = new ArrayList();
        this.n_materie = materie;

    }

    public void Ordina() {
    Comparator<Nodo> comparator_materie;
        comparator_materie = new Comparator<Nodo>() {
            public int compare(Nodo obj1,Nodo obj2) {
                return obj1.getN_materie()-obj2.getN_materie();
            }
        };
        Collections.sort(foglie, comparator_materie);
    }

    public Nodo Stima(){
        this.Ordina();
        return foglie.get(foglie.size()-1);
    }
    public int getN_materie() {
        return n_materie;
    }
    
    public int get_progressivo() {
        return progressivo;
    }

    public ArrayList<Nodo> getFoglie() {
        return foglie;
    }

    public Nodo getFiglio_sx() {
        return figlio_sx;
    }

    public Nodo getFiglio_dx() {
        return figlio_dx;
    }

    public String getValore() {
        return valore;
    }

    public boolean HasFiglio() {
        if (this.figlio_dx == null && this.figlio_sx == null) {
            return false;
        } else {
            return true;
        }

    }

}
