package com.example.ProyectoFinal.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Debe ingresar un nombre")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar un apellido")
    private String apellido;

    @NotBlank(message = "Debe ingresar un lugar de nacimiento")
    private String lugarNacimiento;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @Past
    @NotNull(message = "Debe insegrar su fecha de nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Integer id, String nombre, String apellido, String lugarNacimiento, LocalDate fechaNacimiento, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = libros;
    }

    public Autor(String nombre, String apellido, String lugarNacimiento, LocalDate fechaNacimiento, List<Libro> libros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
