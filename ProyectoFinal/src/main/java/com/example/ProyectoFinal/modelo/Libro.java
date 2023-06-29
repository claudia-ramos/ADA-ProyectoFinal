package com.example.ProyectoFinal.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Debe ingresar un titulo")
    private String titulo;

    @NotBlank(message = "Debe ingresar un isbn")
    private String isbn;

    @NotNull(message = "Debe ingresar un año")
    private Integer anio;

    @NotNull(message = "Debe ingresar cantidad de ejemplares")
    private Integer ejemplares;

    @NotNull(message = "Debe ingresar la cantidad de ejemplares prestados")
    private  Integer ejemplaresPrestados;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(Integer id, String titulo, String isbn, Integer anio, Integer ejemplares,Integer ejemplaresPrestados, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.autor = autor;
    }

    public Libro(String titulo, String isbn, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }
}
