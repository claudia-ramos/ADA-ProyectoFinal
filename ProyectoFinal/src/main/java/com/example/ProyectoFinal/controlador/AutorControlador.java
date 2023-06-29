package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.modelo.Autor;
import com.example.ProyectoFinal.servicio.AutorServicio;
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
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/listar/autor")
    public String verPaginaDeInicioAutor(Model model) {
        model.addAttribute("autores",autorServicio.listarTodasLosAutores());
        return "listarAutor";
    }

    @GetMapping("/nuevo/autor")
    public String mostrarFormularioDeRegistroAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "crear_autor";
    }

    @PostMapping("/guardar/autor")
    public String guardarAutor(@Validated Autor autor, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("autor",autor);
            return "crear_autor";
        }
        autorServicio.guardarAutor(autor);
        redirectAttributes.addFlashAttribute("msgExito","El autor ha sido agregado con exito");
        return "redirect:/";
    }

    @GetMapping("/editar/autor/{id}")
    public String mostrarFormularioDeEditarAutor(@PathVariable Integer id,Model model) {
        Autor autor = autorServicio.obtenerPorId(id);
        model.addAttribute("autor",autor);
        return "editar_autor";
    }

    @PostMapping("/editar/autor/{id}")
    public String actualizarAutor(@PathVariable Integer id, @Validated Autor autor, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        Autor autorDB = autorServicio.obtenerPorId(id);
        if(bindingResult.hasErrors()) {
            model.addAttribute("autor",autor);
            return "editar_autor";
        }
        autorDB.setId(id);
        autorDB.setNombre(autor.getNombre());
        autorDB.setApellido(autor.getApellido());
        autorDB.setFechaNacimiento(autor.getFechaNacimiento());
        autorDB.setLugarNacimiento(autor.getLugarNacimiento());

        autorServicio.actualizarAutor(autorDB);

        redirectAttributes.addFlashAttribute("msgExito","El autor ha sido actualizado exitosamente");
        return "redirect:/";
    }

    @PostMapping("/eliminar/autor/{id}")
    public String eliminarAutor(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Autor autor = autorServicio.obtenerPorId(id);
        autorServicio.eliminarAutor(autor);
        redirectAttributes.addFlashAttribute("msgExito","El autor ha sido eliminado exitosamente");
        return "redirect:/";
    }





}
