package com.example.iteralura.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String titulo;
    private String idioma;
    private Double numeroDeDescargas;

    @ManyToOne
    private Autor autor;


    public Libro(){} // Contructor por defecto necesario

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return  "------- Libro --------\n " +
                "Titulo: "+titulo+" \n" +
                "Autor: "+ autor.getNombre() + " \n" +
                "Idioma: "+ idioma + " \n" +
                "Numero de descargas: " + numeroDeDescargas +" \n" +
                "-----------------------";
    }
}
