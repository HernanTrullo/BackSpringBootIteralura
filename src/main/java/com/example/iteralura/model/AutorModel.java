package com.example.iteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorModel(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento,
        @JsonAlias("death_year") String fechaDeFallecimiento
) {
    @Override
    public String toString() {
        return "---------- Autor ------------\n " +
                "Nombre: "+nombre + " \n" +
                "Fecha de nacimiento: "+ fechaDeNacimiento+ "\n " +
                "Fecha de fallecimiento: "+ fechaDeFallecimiento +" \n" +
                "---------------------------- ";
    }
}
