package com.project;

import com.project.demo.Anwender.Nutzer;
import com.project.demo.ClubPraeferenz.Liga;
import com.project.demo.ClubPraeferenz.Verein;
import com.project.demo.DataManager.PostgresDataManager;
import com.project.demo.alexa.AlexaRO;
import com.project.demo.alexa.OutputSpeechRO;
import com.project.demo.alexa.ResponseRO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/twofootball")
public class MappingController {

    // DB-Tabellen erzeugen
    @PostMapping(
            path = "/nutzer/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createNutzerTable() {
        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableNutzer();
        return "Datenbank Nutzer-Tabelle erstellt";
    }

    @PostMapping(
            path = "/liga/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createLigaTable() {
        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableLigen();
        return "Datenbank Liga-Tabelle erstellt";
    }
    @PostMapping(
            path = "/verein/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createVereinTable() {
        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableVereine();
        return "Datenbank Vereine-Tabelle erstellt";
    }

    //Einträge in die jeweiligen Tabellen schreiben
    @PostMapping(
            path = "/liga",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addLiga(@RequestBody Liga liga) {
         Liga.addLiga(liga);
        return "Liga "+liga.getLiga()+" zur DB hinzugefügt mit ID / Vereine: "+liga.getligaID()+" / "+liga.getVereine();

    }

    @PostMapping(
            path = "/verein",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addVerein(@RequestBody Verein verein) {
        Verein.addVerein(verein);
        return "Verein "+verein.getVerein()+" zur DB hinzugefügt aus Liga: "+verein.getLigaID()+"; ID / externAPI: "+verein.getVereinID();
    }

    @PostMapping(
            path = "/nutzer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addNutzer(@RequestBody Nutzer nutzer) {
        Nutzer.addNutzer(nutzer);
        return "Nutzer "+nutzer.getNutzerEmail()+ "Verein "+nutzer.getNutzerPraefVerein()+" / Liga "+nutzer.getNutzerPraefLiga();
    }

    //Get-Mapping

    @GetMapping("/liga/all")
    public Collection<Liga> getLigen() {
      return Liga.getLigen();
    }
    @GetMapping("/nutzer/all")
    public Collection<Nutzer> getNutzer() {
        return Nutzer.getNutzer();
    }
    @GetMapping("/verein/all")
    public Collection<Verein> getVereine() {
        return Verein.getVereine();
    }

    @PostMapping(
            path = "/alexa",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AlexaRO getLieblingsVerein(@RequestBody AlexaRO alexaRO) {
        if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest")) {
            return
                    prepareResponse(alexaRO, "Wilkommen bei TwoFootball. ", false);
        }

        if (alexaRO.getRequest().getType().equals("IntentRequest") &&
                (alexaRO.getRequest().getIntent().getName().equals("prefReadIntent"))) {
            StringBuilder outText = new StringBuilder("Dein Lieblingsverein ist ");
            try {
                // String mail wird aus der Alexa-Anfrage geholt
                String nutzerMail = alexaRO.getRequest().getIntent().getSlots().getEmailRO().getEmail();
                // hier Präferenz holen
                String nutzerPraef = PostgresDataManager.getPostgresDataManger().getLiebVerein(nutzerMail).getVerein();
                // hier ausgeben mit Alexa
                outText.append(nutzerPraef);
                //outText.append("1860 bis in den Tod! ");
            } catch (Exception e) {
               outText.append("Dieser Nutzer ist bei uns nicht registriert! ");
                //outText.append(e.toString());
            }
            return
                    prepareResponse(alexaRO, outText.toString(), true);
        }
        return
                prepareResponse(alexaRO, "Wir können dir leider nicht helfen. ", true);
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

}

