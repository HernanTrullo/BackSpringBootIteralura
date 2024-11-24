package com.example.iteralura.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;
    private int fechaDeNacimiento;
    private int fechaDeFallecimiento;

    @OneToMany
    private List<Libro> libro;

    public Autor(){} // Contructor por defecto necesario

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(int fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(int fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "---------- Autor ------------\n " +
                "Nombre: "+nombre + " \n" +
                "Fecha de nacimiento: "+ fechaDeNacimiento+ "\n " +
                "Fecha de fallecimiento: "+ fechaDeFallecimiento +" \n" +
                "---------------------------- ";
    }

}
