package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LocalController {

    private ArrayList<Local> locais;

    public LocalController() {
        locais = new ArrayList<>();
    }

    @GetMapping("/local")
    public String form(LocalDTO localDTO, Model model) {
        model.addAttribute("localDTO", localDTO);

        return "/local-cadastro";
    }

    @PostMapping("/local")
    public String adicionar(@Valid LocalDTO localDTO, Model model) {

        locais.add(localDTO.toModel());

        return "/local-adicionado-sucesso";
    }

    @GetMapping("/local-listar")
    public void listar() {
        locais.forEach(System.out::println);
    }
}
