package com.project.demo.ClubPraeferenz;

import com.project.demo.DataManager.PostgresDataManager;

import java.util.Collection;

public class Verein {
    private String clubName;
    private int id;
    String name;
    int ligaID;


    public Verein(int id, String name, int ligaID){
       this.id=id;
       this.name=name;
       this.ligaID=ligaID;

    }
    public static void addVerein(Verein v){
        PostgresDataManager.getPostgresDataManger().addVereinToTab(v);
    }
    public String getVerein(){
        return name;
    }
    public int getVereinID(){
        return id;
    }
    public int getLigaID(){return ligaID;}

    public static Collection<Verein> getVereine() {return PostgresDataManager.getPostgresDataManger().getAllVereine();}
}
