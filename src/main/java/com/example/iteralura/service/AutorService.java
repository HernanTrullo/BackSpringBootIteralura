package com.example.iteralura.service;
import com.example.iteralura.model.Autor;
import com.example.iteralura.model.AutorModel;
import com.example.iteralura.repository.AutorRepository;
import com.example.iteralura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {


    private AutorRepository autorRepository;
    private LibroRepository libroRepository;

    public AutorService(AutorRepository autorRepository, LibroRepository libroRepository){
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public void insertarAutor(AutorModel autorModel) {
        Autor autor = new Autor();
        autor.setNombre(autorModel.nombre());
        if (autorModel.fechaDeNacimiento() != null){
            autor.setFechaDeNacimiento(Integer.parseInt(autorModel.fechaDeNacimiento()));
        }
        else {
            autor.setFechaDeNacimiento(0);
        }
        if (autorModel.fechaDeFallecimiento() != null){
            autor.setFechaDeFallecimiento(Integer.parseInt(autorModel.fechaDeFallecimiento()));
        }
        else {
            autor.setFechaDeFallecimiento(0);
        }
        autorRepository.save(autor);
    }

    public List<Autor> obtenerAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> obtenerAutoresVivosEnDeterminadoAnio(int anio) {
        return autorRepository.findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThan(anio, anio);
    }
}
