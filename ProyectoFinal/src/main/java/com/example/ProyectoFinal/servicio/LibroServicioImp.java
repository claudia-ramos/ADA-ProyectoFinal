package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.modelo.Libro;
import com.example.ProyectoFinal.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicioImp implements LibroServicio{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarTodasLosLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public Libro obtenerPorId(Integer id) {
        return libroRepositorio.findById(id).get();
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
