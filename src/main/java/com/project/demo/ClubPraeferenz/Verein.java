package com.project.demo.ClubPraeferenz;

public class Verein {
    private String clubName;
    private int clubID;
    String liga;
    int ligaID;
    public Liga ligaObjekt;

    public Verein(String name, int clubID, Liga ligaObjekt){
        this.clubName = name;
        this.clubID = clubID;
        this.liga = ligaObjekt.getLiga();
        this.ligaID = ligaObjekt.getligaID();
    }
    public void zeigeVereinInfo(int clubID){
        //DetailPage Infos
    }
    public String getVerein(){
        return clubName;
    }
    public int getClubID(){
        return clubID;
    }
}
