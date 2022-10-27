package com.project;

import com.project.demo.DataManager.PostgresDataManager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/twofootball")
public class MappingController {

    // TODO
    // The student is completely ignored.
    //

    // TODO
    // delete, update, get by id, get sorted, ...
    //

    // TODO
    // Set the used DataProvider (ProperyFileManager, PostgresMaganer) here and not in TaskList
    //


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

