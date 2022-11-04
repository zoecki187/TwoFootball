package com.project;

import com.project.demo.ClubPraeferenz.Liga;
import com.project.demo.ClubPraeferenz.Verein;
import com.project.demo.DataManager.PostgresDataManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.project.demo.Anwender.Nutzer;


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
            path = "/verein/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createVereinTable() {

        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableVereine();

        return "Database Verein-Table created";
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
        return "Verein "+verein.getVerein()+" zur DB hinzugefügt aus Liga: "+verein.getLigaID()+"; ID / externAPI: "+verein.getVereinID()+" / "+verein.getExterneID();
    }

    @PostMapping(
            path = "/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addNutzer(@RequestParam Nutzer nutzer) {

        Nutzer.addNutzer(nutzer);
        return "Nutzer "+nutzer.getNutzerEmail()+" zur DB hinzugefügt per ID: "+nutzer.getNutzerID()+"; Verein "+nutzer.getNutzerPraefVerein()+" / Liga "+nutzer.getNutzerPraefLiga();
    }

}

