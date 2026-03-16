package Mengde.tabell;


import dat102.uke10.oppg4_mengder.MengdeADT;
import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {

    private static final int START_KAPASITET = 10;
    private T[] tabell;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde(){
        tabell = (T[]) new Object[START_KAPASITET];
        antall = 0;
    }

    @Override
    public boolean erTom(){
        return antall == 0;
    }
    @Override
    public boolean inneholder(T element){
        for (int i = 0; i <antall; i++){
            if(tabell [i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde){
        for (int i = 0; i<antall; i++){
            if (!annenMengde.inneholder(tabell[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde){
        if (this.antallElementer() !=annenMengde.antallElementer()){
            return false;
        }
        return this.erDelmengdeAv(annenMengde);
    }
    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde){
        for (int i = 0; i<antall; i++){
            if (annenMengde.inneholder(tabell[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde){
        TabellMengde<T> resultat = new TabellMengde<>();

        for (int i = 0; i<antall; i++){
            if (annenMengde.inneholder(tabell[i])){
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde){
        TabellMengde<T> 
    }

}
