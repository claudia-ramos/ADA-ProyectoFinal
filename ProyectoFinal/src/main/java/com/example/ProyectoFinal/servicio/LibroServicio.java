package com.example.ProyectoFinal.servicio;


import com.example.ProyectoFinal.modelo.Libro;

import java.util.List;

public interface LibroServicio {
    List<Libro> listarTodasLosLibro();

    Libro guardarLibro(Libro libro);

    Libro obtenerPorId(Long id);

    Libro actualizarLibro(Libro libro);

    void eliminarLibro(Libro libro);
}
