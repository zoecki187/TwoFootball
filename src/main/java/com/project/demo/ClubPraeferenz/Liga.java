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

    public static void addLiga(Liga l){
        PostgresDataManager.getPostgresDataManger().addLigaToTab(l);
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
