package com.example.ProyectoFinal.servicio;


import com.example.ProyectoFinal.modelo.Libro;

import java.util.List;

public interface LibroServicio {
    List<Libro> listarTodasLosLibros();

    Libro guardarLibro(Libro libro);

    Libro obtenerPorId(Integer id);

    Libro actualizarLibro(Libro libro);

    void eliminarLibro(Libro libro);
}
