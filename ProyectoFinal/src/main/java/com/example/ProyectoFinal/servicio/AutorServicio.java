package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.modelo.Autor;

import java.util.List;

public interface AutorServicio {
    List<Autor> listarTodasLosAutores();

    Autor guardarAutor(Autor autor);

    Autor obtenerPorId(Integer id);

    Autor actualizarAutor(Autor autor);

    void eliminarAutor(Autor autor);
}
