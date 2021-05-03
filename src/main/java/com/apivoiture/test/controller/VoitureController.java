package com.apivoiture.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VoitureController {

    @GetMapping("/")
    public String index(Model model ) {
        model.addAttribute("test", "Phrase de bienvenue - Test de configuration");
        model.addAttribute("title", "Voitures");
        return "index";
    }

    @GetMapping("/voiture/{idVoiture}")
    public String findById(@PathVariable("idVoiture") Integer id, Model model ) {
        model.addAttribute("id", id);
        return "detail";
    }
}
