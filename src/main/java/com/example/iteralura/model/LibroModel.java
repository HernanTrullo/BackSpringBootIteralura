package com.example.iteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroModel (
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AutorModel> authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer download_count
){

    @Override
    public String toString() {
        return  "------- Libro --------\n " +
                "Titulo: "+title+" \n" +
                "Autor: "+authors.get(0).nombre() + " \n" +
                "Idioma: "+ languages.get(0) + " \n" +
                "Numero de descargas: " + download_count +" \n" +
                "-----------------------";
    }
}
