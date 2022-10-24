package model.Anwender;

public class Nutzer {
    private String email;
    private String passwort;
    private int id;

    public Nutzer (String email, String passwort, int id){
        this.email = email;
        this.passwort = passwort;
        this.id = id;
    }
    public  static int getNutzerID(String email){
        int idret;
        //DB abruf nutzer id anhand email
        idret = 1;
        return idret;
    }
}
