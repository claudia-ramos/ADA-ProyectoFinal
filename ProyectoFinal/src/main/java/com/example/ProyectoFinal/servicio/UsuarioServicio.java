package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.dto.UsuarioRegistroDTO;
import com.example.ProyectoFinal.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UsuarioServicio extends UserDetailsService {
    Usuario guardar(UsuarioRegistroDTO usuarioRegistroDTO);
    public List<Usuario> listarUsuarios();

}
