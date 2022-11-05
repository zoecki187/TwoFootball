package com.project.demo.ClubPraeferenz;

import com.project.demo.DataManager.PostgresDataManager;

import java.util.Collection;

public class Liga {
    private int ligaID;
    private String name = "";

    int anzvereine = 18;

    public Liga(int id, String name, int anzvereine){
        this.ligaID = id;
        this.name = name;
        this.anzvereine = anzvereine;
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
        return anzvereine;
    }
    public static Collection<Liga> getLigen() {
        Collection<Liga> list = PostgresDataManager.getPostgresDataManger().getAllLigen();

        return list;}
}
