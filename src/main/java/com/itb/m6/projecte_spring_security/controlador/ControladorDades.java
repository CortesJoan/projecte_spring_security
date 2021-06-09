package com.itb.m6.projecte_spring_security.controlador;

import com.itb.m6.projecte_spring_security.model.Manga;
import com.itb.m6.projecte_spring_security.servei.ServeiManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorDades {
    @Autowired
    private ServeiManga serveiManga;
    String nom;


    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String eliminarPersonatgePerNom(@PathVariable("name") String nomManga){
        serveiManga.eliminatPerNom(nomManga);
        return "redirect:/home";
    }

    @RequestMapping("/afegir")
    public String afegirPersonatge(Model model) {
        model.addAttribute("Manga", new Manga());
        return "afegirManga";
    }

    @GetMapping("/home")
    public String llistarPersonatge(Model m){
        m.addAttribute("llistaManga", serveiManga.llistat());
        m.addAttribute("Manga",new Manga());
        return "home";
    }
    @PostMapping("/afegirPersonatge")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirPersonatgeSubmit(@ModelAttribute("Manga") Manga manga){
        serveiManga.afegir(manga);
        return "redirect:/home";
    }
    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updatePersonatge(@PathVariable("name") String manga, Model m){

        nom = manga;
        m.addAttribute("Manga", serveiManga.consultaMangaPerNom(manga));

        return "modificarManga";
    }

    @PostMapping("/actualitzarPersonatge")
    public String updatePersonatgeSubmit(@ModelAttribute("Manga") Manga e){
        serveiManga.actualitzarPersonatgePerNom(e, nom);
        return "redirect:/home";
    }
}
