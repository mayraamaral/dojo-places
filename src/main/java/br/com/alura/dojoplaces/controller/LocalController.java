package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import br.com.alura.dojoplaces.model.LocalResponseDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LocalController {

    private final LocalRepository localRepository;

    public LocalController(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @GetMapping("/local")
    public String formCadastro(LocalRequestDTO localDTO, Model model) {
        model.addAttribute("localDTO", localDTO);

        return "/local-cadastro";
    }

    @PostMapping("/local")
    public String adicionar(@Valid LocalRequestDTO localDTO, Model model) {

        localRepository.save(localDTO.toModel());

        return "/local-adicionado-sucesso";
    }

    @GetMapping("/local-listar")
    public String listar(Model model) {
        List<LocalResponseDTO> locais = localRepository.findAll()
            .stream().map(Local::toResponseDTO)
            .toList();

        model.addAttribute("locais", locais);

        return "/local-listagem";
    }

    @GetMapping("/local-editar")
    public String formEdicao(LocalEditDTO localEditDTO, @RequestParam("id") Long id, Model model) {
        model.addAttribute("localEditDTO", localEditDTO);
        model.addAttribute("id", id);

        return "/local-edicao";
    }

    @PostMapping("/local-editar")
    public String editar(@Valid LocalEditDTO localEditDTO, Long id) {

        Local localToBeEdited = localRepository.findById(id).get();
        localToBeEdited.edit(localEditDTO);
        localRepository.save(localToBeEdited);

        return "redirect:/local-listar";
    }

    @GetMapping("/local-deletar")
    public String deletar(@RequestParam("id") Long id) {
        localRepository.deleteById(id);

        return "/local-deletado-sucesso";
    }
}
