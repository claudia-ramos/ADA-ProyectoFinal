package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.modelo.Libro;
import com.example.ProyectoFinal.servicio.AutorServicio;
import com.example.ProyectoFinal.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;
    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/listar/libro")
    public String verPaginaDeInicioLibro(Model model) {
        model.addAttribute("libros",libroServicio.listarTodasLosLibros());
        return "listarLibros";
    }

    @GetMapping("/nuevo/libro")
    public String mostrarFormularioDeRegistroLibro(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("autores",autorServicio.listarTodasLosAutores());
        return "crear_libro";
    }

    @PostMapping("/guardar/libro")
    public String guardarLibro(@Validated Libro libro, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("libro",libro);
            return "crear_libro";
        }
        libroServicio.guardarLibro(libro);
        redirectAttributes.addFlashAttribute("msgExito","El libro ha sido agregado con exito");
        return "redirect:/";
    }

    @GetMapping("/editar/libro/{id}")
    public String mostrarFormularioDeEditarLibro(@PathVariable Integer id, Model model) {
        Libro libro  = libroServicio.obtenerPorId(id);
        model.addAttribute("libro",libro);
        return "editar_libro";
    }

    @PostMapping("/editar/libro/{id}")
    public String actualizarLibro(@PathVariable Integer id, @Validated Libro libro, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        Libro libroDB = libroServicio.obtenerPorId(id);
        if(bindingResult.hasErrors()) {
            model.addAttribute("libro",libro);
            return "editar_libro";
        }
        libroDB.setId(id);
        libroDB.setTitulo(libro.getTitulo());
        libroDB.setIsbn(libro.getIsbn());
        libroDB.setAnio(libro.getAnio());
        libroDB.setEjemplares(libro.getEjemplares());
        libroDB.setEjemplaresPrestados(libro.getEjemplaresPrestados());
        libroDB.setAutor(libro.getAutor());

        libroServicio.actualizarLibro(libroDB);

        redirectAttributes.addFlashAttribute("msgExito","El libro ha sido actualizado exitosamente");
        return "redirect:/";
    }

    @PostMapping("/eliminar/libro/{id}")
    public String eliminarAutor(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Libro libro = libroServicio.obtenerPorId(id);
        libroServicio.eliminarLibro(libro);
        redirectAttributes.addFlashAttribute("msgExito","El libro ha sido eliminado exitosamente");
        return "redirect:/";
    }
}
