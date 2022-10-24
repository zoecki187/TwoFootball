package model.Anwender;

public class Registrierung {

    private boolean registriert;

    private Registrierung(){};
    public static boolean istregistriert(String email){
        //DB eintrag prüfen
      if (Nutzer.getNutzerID ("vogel@mail.de") == 1){
          return true;
      }
      else{
          return false;
      }
    }

    public boolean registrieren(String email,String passwort){

        if(istregistriert(email) == false){
            //register to DB with mail and PW
            return true;
        }
        else{ return false;} //User kann nicht registriert werden, da bereits registriert
    }
}
