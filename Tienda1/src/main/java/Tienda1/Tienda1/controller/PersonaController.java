/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda1.Tienda1.controller;

import Tienda1.Tienda1.entily.Pais;
import Tienda1.Tienda1.entily.Persona;
import Tienda1.Tienda1.service.IPaisService;
import Tienda1.Tienda1.service.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author aldav
 */
@Controller
public class PersonaController {

    @Autowired
    /*permite resolver la inyección de dependencias de los siguiente modos. En el constructor de la clase. En un atributo. En un método setter.*/
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("/persona")
    /*Esta anotación se utiliza para asignar solicitudes HTTP GET a métodos de controlador específicos. @GetMapping es una anotación compuesta que actúa como un acceso directo para @RequestMapping (method = RequestMethod. GET)*/
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");/*Aqui le ponemos nombre a la tabla*/
 /*Donde se envia info de bank a frone*/
        model.addAttribute("personas", listaPersona);
        return "persona";
    }

    /*Metodo para crear*/
    @GetMapping("/personaN")
    public String crearPersonas(Model model) {

        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("personas", new Persona());/*model .addAttribute es para enviar info de banker a fonnen*/
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    /*Metodo para eliminar*/
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";

    }

    /*Metodo para guardar , Post lo utlizamos para almacenar INFO*/
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect: /persona";

    }

    /*Metodo para editar*/
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("personas", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";

    }

}
