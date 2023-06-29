package com.example.ProyectoFinal.repositorio;

import com.example.ProyectoFinal.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Integer> {
}
