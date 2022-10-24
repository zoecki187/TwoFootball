package model.ClubPraeferenz;

public class Liga {
    private int ligaID;
    private String name;

    public Liga(int ligaID, String name){
        this.ligaID = ligaID;
        this.name = name;
    }

    public void zeigeLigaInfo(int ligaID){
        //Was genau soll hier passieren?
    }
    public void setTable(){
        //Tabelle aktualisieren
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

}
