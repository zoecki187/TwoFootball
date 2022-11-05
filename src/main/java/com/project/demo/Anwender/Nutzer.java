package com.project.demo.Anwender;

import com.project.demo.DataManager.PostgresDataManager;

import java.util.Collection;

public class Nutzer {
    private String email;

    private int id;
    private int praefverein;
    private int praefliga;


    public Nutzer (int id, String email, int praefverein, int praefliga){
    this.id=id;
    this.email=email;
    this.praefverein=praefverein;
    this.praefliga=praefliga;
    }
    public int getNutzerID(){return id;}
    public String getNutzerEmail(){return email;}
    public int getNutzerPraefVerein(){return praefverein;}
    public int getNutzerPraefLiga(){return praefliga;}
    public static void addNutzer(Nutzer n){PostgresDataManager.getPostgresDataManger().addNutzerToTab(n);}
    public static Collection<Nutzer> getNutzer() {return PostgresDataManager.getPostgresDataManger().getAllNutzer();}
}
