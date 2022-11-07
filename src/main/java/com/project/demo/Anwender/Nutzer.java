package com.project.demo.Anwender;

import com.project.demo.DataManager.PostgresDataManager;

import java.util.Collection;

public class Nutzer {
    private String email;


    private int praefverein;
    private int praefliga;


    public Nutzer (String email, int praefverein, int praefliga){
    this.email=email;
    this.praefverein=praefverein;
    this.praefliga=praefliga;
    }

    public String getNutzerEmail(){return email;}
    public int getNutzerPraefVerein(){return praefverein;}
    public int getNutzerPraefLiga(){return praefliga;}
    public static void addNutzer(Nutzer n){PostgresDataManager.getPostgresDataManger().addNutzerToTab(n);}
    public static Collection<Nutzer> getNutzer() {return PostgresDataManager.getPostgresDataManger().getAllNutzer();}

}
