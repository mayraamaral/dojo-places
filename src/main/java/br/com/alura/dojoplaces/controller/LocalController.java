package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalDTO;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Controller
public class LocalController {

    private ArrayList<Local> locais;

    public LocalController() {
        locais = new ArrayList<>();
    }

    @GetMapping("/local")
    public String formCadastro(LocalDTO localDTO, Model model) {
        model.addAttribute("localDTO", localDTO);

        return "/local-cadastro";
    }

    @PostMapping("/local")
    public String adicionar(@Valid LocalDTO localDTO, Model model) {

        locais.add(localDTO.toModel());

        return "/local-adicionado-sucesso";
    }

    @GetMapping("/local-listar")
    public String listar(Model model) {
        model.addAttribute("locais", locais);

        return "local-listagem";
    }

    @GetMapping("/local-editar")
    public String formEdicao(LocalEditDTO localEditDTO, Model model) {
        model.addAttribute("localEditDTO", localEditDTO);

        return "/local-edicao";
    }

    @PutMapping("/local-editar")
    public String editar(@Valid LocalEditDTO localEditDTO, Model model, @Param("id") int id) {
        int indexDefault = id-1;

        Local localToBeEdited = locais.get(indexDefault);

        localToBeEdited.edit(localEditDTO);

        return "/local-listagem";
    }
}
