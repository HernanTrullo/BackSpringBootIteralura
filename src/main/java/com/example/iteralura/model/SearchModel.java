package com.example.iteralura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchModel(
        @JsonAlias("results")List<LibroModel> libros
        ) {
}
