package com.example.iteralura.principal;

import com.example.iteralura.model.*;
import com.example.iteralura.repository.AutorRepository;
import com.example.iteralura.repository.LibroRepository;
import com.example.iteralura.service.AutorService;
import com.example.iteralura.service.ConsumoAPI;
import com.example.iteralura.service.ConvierteDatos;
import com.example.iteralura.service.LibroService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroService libroService;
    private AutorService autorService;

    public Principal(AutorRepository autorRepository, LibroRepository libroRepository){

        this.libroService = new LibroService(libroRepository, autorRepository);
        this.autorService = new AutorService(autorRepository, libroRepository);
    }

    public void loop() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibrosPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnDetermiandoAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private LibroModel getDatosLibro(){
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+"?search=" + nombreLibro.replace(" ", "+"));
        SearchModel searchModel = conversor.obtenerDatos(json, SearchModel.class);
        return searchModel.libros().get(0);
    }


    private void listarLibrosPorIdioma() {
        System.out.println("Inserte el idioma: \n" +
                "en ingles \n" +
                "es español \n" +
                "fr fransés \n" +
                "pt portugués");

        String idioma = teclado.nextLine();


        List<Libro> libroList =  libroService.obtenerLibrosPorIdioma(idioma);
        if (libroList.isEmpty()){
            System.out.println("Los libros de ese idioma no estaán en la base de datos");
        }
        else {
            libroList.forEach(System.out::println);
        }

    }

    private void listarAutoresVivosEnDetermiandoAnio() {
        System.out.println("Inserte fecha de nacimiento: ");
        int anio = teclado.nextInt();

        List<Autor> autorList = autorService.obtenerAutoresVivosEnDeterminadoAnio(anio);
        if (autorList.isEmpty()){
            System.out.println("No se econtraron autores vivos en el año determiando");
        }
        else{
            autorList.forEach(System.out::println);
        }

    }

    private void listarAutoresRegistrados() {
        autorService.obtenerAutores().forEach(System.out::println);
    }

    private void listarLibrosRegistrados() {
        libroService.obtenerLibros().forEach(System.out::println);
    }

    private void buscarLibrosPorTitulo() {
        LibroModel libroModel = getDatosLibro();
        AutorModel autorModel = libroModel.authors().get(0);

        autorService.insertarAutor(autorModel);
        libroService.insertarLibro(libroModel, autorModel);

        System.out.println(libroModel);
        System.out.println("Libro insertado correctamente");
    }



}

