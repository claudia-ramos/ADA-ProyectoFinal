package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.modelo.Autor;
import com.example.ProyectoFinal.repositorio.AutorRepositorio;
import com.example.ProyectoFinal.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicioImp implements AutorServicio{

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> listarTodasLosAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor obtenerPorId(Integer id) {
        return autorRepositorio.findById(id).get();
    }

    @Override
    public Autor actualizarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public void eliminarAutor(Autor autor) {
        autorRepositorio.delete(autor);
    }
}
