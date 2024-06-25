package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import br.com.alura.dojoplaces.model.LocalResponseDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LocalController {

    private final LocalRepository localRepository;

    public LocalController(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @GetMapping("/local")
    public String listar(Model model) {
        List<LocalResponseDTO> locais = localRepository.findAll()
            .stream().map(Local::toResponseDTO)
            .toList();

        model.addAttribute("locais", locais);

        return "local-listagem";
    }

    @GetMapping("/local-adicionar")
    public String formAdicionar(LocalRequestDTO localRequestDTO, Model model) {
        model.addAttribute("localRequestDTO", localRequestDTO);

        return "local-cadastro";
    }

    @PostMapping("/local-salvar")
    public String adicionar(@Valid LocalRequestDTO localRequestDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if(localRepository.findByCodigo(localRequestDTO.getCodigo()).isPresent()) {
            result.addError(new FieldError("localRequestDTO", "codigo", "O código já existe"));
        }

        if(result.hasErrors()) {
            return formAdicionar(localRequestDTO, model);
        }

        localRepository.save(localRequestDTO.toModel());

        redirectAttributes.addFlashAttribute("foiAdicionadoLocal", true);

        return "redirect:/local";
    }

    @GetMapping("/local-editar")
    public String formEdicao(LocalEditDTO localEditDTO, @RequestParam("id") Long id, Model model) {
        model.addAttribute("localEditDTO", localEditDTO);
        model.addAttribute("id", id);

        if(localRepository.findById(id).isEmpty()) {
            return "local-nao-encontrado";
        }

        return "local-edicao";
    }

    @PostMapping("/local-editar")
    public String editar(@Valid LocalEditDTO localEditDTO, Long id) {
        Local localToBeEdited = localRepository.findById(id).get();
        localToBeEdited.edit(localEditDTO);
        localRepository.save(localToBeEdited);

        return "redirect:/local";
    }

    @GetMapping("/local-deletar")
    public String deletar(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        localRepository.deleteById(id);

        redirectAttributes.addFlashAttribute("foiDeletadoLocal", true);

        return "redirect:/local";
    }

    @GetMapping("/local-nao-encontrado")
    public String localNaoEncontrado() {

        return "local-nao-encontrado";
    }
}
