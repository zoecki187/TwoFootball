package com.project.demo.ClubPraeferenz;

import com.project.demo.DataManager.PostgresDataManager;

import java.util.Collection;

public class Verein {
    private String clubName;
    private int id;
    String name;
    int ligaID;
    int externeID;

    public Verein(int id, String name, int ligaID, int externeID){
       this.id=id;
       this.name=name;
       this.ligaID=ligaID;
       this.externeID=externeID;
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
    public int getExterneID(){return externeID;}
    public static Collection<Verein> getVereine() {return PostgresDataManager.getPostgresDataManger().getAllVereine();}
}
