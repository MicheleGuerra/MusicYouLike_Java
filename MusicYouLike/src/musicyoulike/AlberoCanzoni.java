package musicyoulike;

import java.util.ArrayList;

public class AlberoCanzoni extends Albero  {

    private Nodo straniero;
    private Nodo moderno;
    private Nodo rock;
    private Nodo pop;
    private Nodo pugliese;
    private Nodo fantastica;
    private Nodo americano;
    private Nodo recente;
    private Nodo dolce;
    private Nodo ottanta;
    private Nodo gruppo;
    private Nodo acdc;
    private Nodo dance;
    private Nodo triste;
    
    private Nodo albachiara;
    private Nodo black_or_white;
    private Nodo piazza_grande;
    private Nodo perfect;
    private Nodo its_my_life;
    private Nodo vieni_a_ballare_in_puglia;
    private Nodo let_her_go;
    private Nodo you_are_beautiful;
    private Nodo i_gotta_feeling;
    private Nodo l_amour_toujours;
    private Nodo back_in_black;
    private Nodo sugar;
    private Nodo cant_stop;
    private Nodo sweet_child_on_mine;
    private Nodo vertigo;
    private Nodo moriro_da_re;
    private Albero albero;
    private Nodo[] soluzioni;

    public AlberoCanzoni() {
        super();
        back_in_black = new Nodo(null, null,  "Ascolta: 'Back in Black' degli ACDC",1, 1);
        sugar = new Nodo(null, null, "Ascolta: 'Sugar' dei Maroon 5",1,2 );
        its_my_life = new Nodo(null, null,  "Ascolta: 'It's My Life' di Bon Jovi",3,3);
        sweet_child_on_mine = new Nodo(null, null,  "Ascolta: 'Sweet Child O Mine' dei Guns N Roses",2,4);
        cant_stop = new Nodo(null, null,  "Ascolta: 'Can't Stop' dei Red Hot Chili Peppers",1,5);
        l_amour_toujours = new Nodo(null, null,  "Ascolta: 'L'amour Toujours' di Gigi D'agostino",1,6);
        albachiara = new Nodo(null, null,  "Ascolta: 'Albachiara' di Vasco Rossi",2,7);
        vieni_a_ballare_in_puglia = new Nodo(null, null,  "Ascolta: 'Vieni a ballare in Puglia' di Caparezza",1,8);
        perfect = new Nodo(null, null,  "Ascolta: 'Perfect' di Ed Sheeran",1,9);
        vertigo = new Nodo(null, null,  "Ascolta: 'Vertigo' deglu U2",1,10);
        moriro_da_re = new Nodo(null, null,  "Ascolta: 'Morirò da Re' dei Maneskin",1,11);
        black_or_white = new Nodo(null, null,  "Ascolta: 'Black or White' di Michael Jackson",1,12);
        let_her_go = new Nodo(null, null,  "Ascolta: 'Let her go' di Passenger",1,13);
        i_gotta_feeling = new Nodo(null, null,  "Ascolta: 'I Gotta Feeling' dei Black eye piece",1,14);
        you_are_beautiful = new Nodo(null, null,  "Ascolta: 'You are Beautiful' di James Blunt",1,15);
        piazza_grande = new Nodo(null, null, "Ascolta: 'Piazza Grande' di Lucio Dalla",1,16);

        triste = new Nodo(piazza_grande, albachiara, "Vuoi una canzone triste?",0,0);
        ottanta = new Nodo(its_my_life, let_her_go, "Vuoi una canzone degli anni '80 '90? ",0,0);
        recente = new Nodo(perfect, dolce, "Vuoi una canzone recente? ",0,0);
        dance = new Nodo(l_amour_toujours, triste,"Vuoi una canzone dance?",0,0);
        americano = new Nodo(cant_stop, vertigo, "Vuoi un artista americano? ",0,0);
        dolce = new Nodo(you_are_beautiful, ottanta, "Vuoi una canzone con un testo dolce? ",0,0);
        fantastica = new Nodo( sweet_child_on_mine, americano, "Vuoi una canzone fantastica? ",0,0);
        acdc = new Nodo(back_in_black, fantastica, "Ti piacciono gli ACDC? ",0,0);
        
        
        pugliese = new Nodo(vieni_a_ballare_in_puglia, dance, "Sei pugliese? ",0,0);
        pugliese.getFoglie().add(vieni_a_ballare_in_puglia);
        pugliese.getFoglie().add(albachiara);
        pugliese.getFoglie().add(piazza_grande);
        pugliese.getFoglie().add(l_amour_toujours);
        
        
        pop = new Nodo(black_or_white, recente, "Ti piace il pop?",0,0);
        pop.getFoglie().add(black_or_white);
        pop.getFoglie().add(perfect);
        pop.getFoglie().add(its_my_life);
        pop.getFoglie().add(let_her_go);
        pop.getFoglie().add(you_are_beautiful);
        
        
        rock = new Nodo(acdc, sugar, "Ti piace il rock? ",0, 0);
        rock.getFoglie().add(back_in_black);
        rock.getFoglie().add(vertigo);
        rock.getFoglie().add(sweet_child_on_mine);
        rock.getFoglie().add(cant_stop);
        rock.getFoglie().add(sugar);
        
        
        moderno = new Nodo(moriro_da_re, pugliese, "Vuoi un artista moderno? ",0,0);
        gruppo = new Nodo(rock, pop,"Vuoi un gruppo?" ,0,0);
        
        straniero = new Nodo(gruppo, moderno, "Ti piacciono gli artisti stranieri?",0, 0); 
        
        setRadice(straniero);
        setTaglio(2);

    }

   

}
