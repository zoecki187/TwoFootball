package com.project.demo.ClubPraeferenz;

import com.project.demo.DataManager.PostgresDataManager;

public class Liga {
    private int ligaID;
    private String name = "";

    int anzahlvereine = 18;

    public Liga(int id, String name, int anzahlvereine){
        this.ligaID = id;
        this.name = name;
        this.anzahlvereine = anzahlvereine;
    }

    public void zeigeLigaInfo(int ligaID){
        //Was genau soll hier passieren?
    }
    public static void addLiga(Liga l){
        PostgresDataManager.getPostgresDataManger().addLigaTab(l);
    }

    public void getSpieltagsergebnis(){
        //Spieltagsergebnisse einblenden
    }

    public int getligaID(){
        return ligaID;
    }
    public String getLiga(){
        return name;
    }
    public int getVereine(){
        return anzahlvereine;
    }

}
