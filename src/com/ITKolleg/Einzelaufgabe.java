package com.ITKolleg;

/**
 * Einzellne Aufgabe subTyp von Aufgabe
 *
 * @author Bastian Schwaighofer
 * @version 1.0
 */
public class Einzelaufgabe extends Aufgabe {
        private boolean erledigt;

        public Einzelaufgabe(String beschreibung){
            super(beschreibung);
        }

        @Override
        public void wirdErledigt()
        {
            this.erledigt = true;
            System.out.println("Teilaufgabe "+getBeschreibung()+" soeben erledigt");
        }

        @Override
        public boolean istErledigt(){
        return  erledigt;
        }
}
