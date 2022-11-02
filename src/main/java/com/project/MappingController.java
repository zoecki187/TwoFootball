package com.project;

import com.project.demo.ClubPraeferenz.Liga;
import com.project.demo.DataManager.PostgresDataManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/twofootball")
public class MappingController {



  /*  @GetMapping("/user/all")
    public NutzerListe getNutzerAll() {

        NutzerListe nutzerListe = new NutzerListe(
                new Student("me", name)
        );
        taskList.setTasks();

        return taskList;
    }*/

/*
    @PostMapping(
            path = "/user/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String createUser(@RequestBody String email, String passwort) {

       ArrayList nl = NutzerListe.getNutzerAll();

     int  id= nl.get(nl.size()-1).getNutzerID();

        Nutzer neuerUser = new Nutzer(email, passwort, id);
        return "Neuer User erstellt: "+email+"ID: "+id;
    }

*/
    @PostMapping(
            path = "/user/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createUserTable() {

        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableUser();

        return "Database User-Table created";
    }

    @PostMapping(
            path = "/liga/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createLigaTable() {

        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableLigen();

        return "Database Liga-Table created";
    }

    @PostMapping(
            path = "/liga",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addLigaTable(@RequestBody Liga liga) {

        //  Liga.addLiga(liga);
        return liga.getLiga() + liga.getVereine() + liga.getligaID();

    }

    @PutMapping(
            path = "/verein/all",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addVereineTable(@RequestParam String name, int anzahlvereine) {

    /*Liga liga = new Liga (name, anzahlvereine);
     //  Liga.addLiga(liga);

        return liga.getLiga() + liga.getVereine();*/
return "hallo falsch";
    }




/*
    @PostMapping(
            path = "/alexa",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AlexaRO getTasks(@RequestBody AlexaRO alexaRO) {

        String outText = "";


        return alexaRO;
    }

    private AlexaRO prepareResponse(AlexaRO alexaRO, String outText, boolean shouldEndSession) {

        alexaRO.setRequest(null);
        alexaRO.setSession(null);
        alexaRO.setContext(null);
        OutputSpeechRO outputSpeechRO = new OutputSpeechRO();
        outputSpeechRO.setType("PlainText");
        outputSpeechRO.setText(outText);
        ResponseRO response = new ResponseRO(outputSpeechRO, shouldEndSession);
        alexaRO.setResponse(response);
        return alexaRO;
    }
*/
}

