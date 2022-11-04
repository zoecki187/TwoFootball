package com.project.demo.Anwender;

import com.project.demo.DataManager.PostgresDataManager;

public class Nutzer {
    private String email;

    private int id;
    private int PraefVerein;
    private int PraefLiga;


    public Nutzer (int id, String email, int PraefVerein, int PraefLiga){
    this.id=id;
    this.email=email;
    this.PraefVerein=PraefVerein;
    this.PraefLiga=PraefLiga;
    }

    public int getNutzerID(){return id;}
    public String getNutzerEmail(){return email;}
    public int getNutzerPraefVerein(){return PraefVerein;}
    public int getNutzerPraefLiga(){return PraefLiga;}
    public static void addNutzer(Nutzer n){
        PostgresDataManager.getPostgresDataManger().addNutzerToTab(n);
    }
}
