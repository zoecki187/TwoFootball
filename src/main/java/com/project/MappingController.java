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
            path = "/verein/createtable"
    )
    @ResponseStatus(HttpStatus.OK)
    public String createVereinTable() {

        final PostgresDataManager postgresDataManager =
                PostgresDataManager.getPostgresDataManger();
        postgresDataManager.createTableVereine();

        return "Database Verein-Table created";
    }

    @PostMapping(
            path = "/liga",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public String addLiga(@RequestBody Liga liga) {

         Liga.addLiga(liga);
        return liga.getLiga() + liga.getVereine() + liga.getligaID() + "DatabaseCreatedLiga";

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

}

