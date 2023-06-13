package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.modelo.Libro;
import com.example.ProyectoFinal.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    //@GetMapping("/login")
    //public String iniciarSesion(){
     //   return "login";
    //}

    @GetMapping("hola")
    public String verPaginaInicio(Model model) {
        model.addAttribute("libro",libroServicio.listarTodasLosLibro());
        //model.addAttribute("usuarios",usuarioServicio.listarTodos());
        return "listarLibros";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/new/libro")
    public String agregar(Model model) {
        Libro libro = new Libro();

        model.addAttribute("libro",libro);
        return "crear_libro";

    }

    @PostMapping("/save/libro")
    public String guardar(@ModelAttribute("libro") Libro libro) {
        libroServicio.guardarLibro(libro);
        return "redirect:/";
    }
}
