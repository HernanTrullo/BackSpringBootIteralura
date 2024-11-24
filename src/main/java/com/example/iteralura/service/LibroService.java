package com.example.iteralura.service;

import com.example.iteralura.model.Autor;
import com.example.iteralura.model.AutorModel;
import com.example.iteralura.model.Libro;
import com.example.iteralura.model.LibroModel;
import com.example.iteralura.repository.AutorRepository;
import com.example.iteralura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {


    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository){
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void insertarLibro(LibroModel libroModel, AutorModel autorModel) {
        Autor autor = autorRepository.findByNombre(autorModel.nombre()).orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        // Crear el libro y establecer los atributos
        Libro libro = new Libro();
        libro.setTitulo(libroModel.title());
        libro.setIdioma(libroModel.languages().get(0));
        libro.setNumeroDeDescargas(Double.valueOf(libroModel.download_count()));
        libro.setAutor(autor);

        // Guardar el libro en la base de datos
        libroRepository.save(libro);
    }

    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> obtenerLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
