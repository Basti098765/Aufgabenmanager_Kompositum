package com.ITKolleg;

import java.util.ArrayList;
import java.util.List;

public class AufgabenListe extends Aufgabe{

    private List<Aufgabe> aufgaben;

    public AufgabenListe(String beschreibung){
        super(beschreibung);
        aufgaben = new ArrayList<>();
    }
    @Override
    public void wirdErledigt()
    {
        for(Aufgabe aufgabe: aufgaben)
        {
            aufgabe.wirdErledigt();
        }


    }
    @Override
    public boolean istErledigt()
    {
        for(Aufgabe aufgabe: aufgaben)
        {
            if (!aufgabe.istErledigt()) {
                return false;
            }
        }
        return true;

    }
    public void hinzufuegen(Aufgabe aufgabe)
    {
        aufgaben.add(aufgabe);
    }



    public List<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(List<Aufgabe> aufgaben) {
        this.aufgaben = aufgaben;
    }
}
