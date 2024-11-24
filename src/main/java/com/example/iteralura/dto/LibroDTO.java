package com.example.iteralura.dto;

public record LibroDTO(
        Long Id,
        String titulo,
        String idioma,
        Double numeroDeDescargas
) {
}
