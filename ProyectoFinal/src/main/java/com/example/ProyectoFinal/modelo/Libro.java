package com.example.ProyectoFinal.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar un titulo")
    private String titulo;

    @NotBlank(message = "Debe ingresar un isbn")
    private String isbn;

    @NotBlank(message = "Debe ingresar un año")
    private Integer anio;

    @NotBlank(message = "Debe ingresar cantidad de ejemplares")
    private Integer ejemplares;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, Integer anio, Integer ejemplares, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.autor = autor;
    }

    public Libro(String titulo, String isbn, Integer anio, Integer ejemplares, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
