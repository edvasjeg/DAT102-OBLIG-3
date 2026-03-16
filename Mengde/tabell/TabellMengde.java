package dat102.uke10.oppg4_mengder.Mengde.tabell;


import dat102.uke10.oppg4_mengder.ADT.MengdeADT;

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
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> resultat = new TabellMengde<>();

        for (int i = 0; i < antall; i++) {
            resultat.leggTil(tabell[i]);
        }
        resultat.leggTilAlleFra(annenMengde);
        return resultat;
    }
    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde){
        TabellMengde<T> resultat = new TabellMengde<>();

        for (int i = 0; i<antall; i++){
            if (!annenMengde.inneholder(tabell[i])){
                resultat.leggTil(tabell[i]);
            }
        }
        return resultat;
    }
   @Override
    public void leggTil(T element){
        if (!inneholder(element)){
            utvidKapasitet();

            tabell[antall]= element;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra (MengdeADT<T> annenMengde){

        T[] andre = annenMengde.tilTabell();

        for (T element : andre){
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element){
        for (int i = 0;i<antall; i++){
            if (tabell[i].equals(element)){

                T fjernet = tabell[i];
                tabell[i] = tabell[antall - 1];
                tabell[antall-1] = null;

                antall--;
                return fjernet;
            }

        }
        return null;
    }
    @Override
    public T[] tilTabell(){
        return Arrays.copyOf(tabell, antall);
    }
    @Override
    public int antallElementer(){
        return antall;
    }
    private void utvidKapasitet(){
        if (antall == tabell.length){
            tabell = Arrays.copyOf(tabell, tabell.length * 2);
        }
    }
}
