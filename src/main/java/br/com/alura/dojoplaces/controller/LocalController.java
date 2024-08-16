package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import br.com.alura.dojoplaces.model.LocalResponseDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;

import br.com.alura.dojoplaces.utils.validator.CodigoEditValidator;
import br.com.alura.dojoplaces.utils.validator.CodigoRequestValidator;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class LocalController {

    private final LocalRepository localRepository;
    private final CodigoRequestValidator codigoRequestValidator;
    private final CodigoEditValidator codigoEditValidator;

    public LocalController(LocalRepository localRepository, CodigoRequestValidator codigoValidator, CodigoEditValidator codigoEditValidator) {
        this.localRepository = localRepository;
        this.codigoRequestValidator = codigoValidator;
        this.codigoEditValidator = codigoEditValidator;
    }

    @InitBinder("localRequestDTO")
    public void initBinderRequest(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(codigoRequestValidator);
    }

    @InitBinder("localEditDTO")
    public void initBinderEdit(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(codigoEditValidator);
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
        if(result.hasErrors()) {
            return formAdicionar(localRequestDTO, model);
        }

        localRepository.save(localRequestDTO.toModel());

        redirectAttributes.addFlashAttribute("foiAdicionadoLocal", true);

        return "redirect:/local";
    }

    @GetMapping("/local-editar")
    public String formEdicao(@RequestParam("id") Long id, LocalEditDTO localEditDTO, Model model) {
        if(localEditDTO.isDirty()) {
            model.addAttribute("localEditDTO", localEditDTO);

            return "local-edicao";
        }

        Optional<Local> localToBeEdited = localRepository.findById(id);

        if(localToBeEdited.isEmpty()) {
            return "redirect:/local-nao-encontrado";
        }

        LocalEditDTO local = localToBeEdited.get().toEditDTO();
        model.addAttribute("localEditDTO", local);

        return "local-edicao";
    }

    @PostMapping("/local-editar")
    public String editar(@Valid LocalEditDTO localEditDTO, BindingResult result, Model model, Long id) {
        if(result.hasErrors()) {
            localEditDTO.markAsDirty();
            return formEdicao(localEditDTO.getId(), localEditDTO, model);
        }

        Local localToBeEdited = localRepository.findById(id).get();
        localToBeEdited.edit(localEditDTO);

        localRepository.save(localToBeEdited);

        return "redirect:/local";
    }

    @PostMapping("/local-deletar")
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
