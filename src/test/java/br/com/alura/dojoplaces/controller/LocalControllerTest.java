package br.com.alura.dojoplaces.controller;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class LocalControllerTest {

    private LocalRepository localRepository;
    private LocalController localController;

    @BeforeEach
    void setUp() {
        localRepository = mock(LocalRepository.class);
        localController = new LocalController(localRepository);
    }

    @Test
    void shouldAddPlace_when_local_is_not_repeated() {
        LocalRequestDTO local = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());

        when(localRepository.findByCodigo(anyString())).thenReturn(Optional.empty());

        localController.adicionar(local, mock(BindingResult.class), mock(Model.class), mock(RedirectAttributes.class));

        verify(localRepository).save(any());
    }

    @Test
    void shouldNotAddPlace_when_local_is_repeated() {
        LocalRequestDTO localRequestDTO = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());
        Local local = localRequestDTO.toModel();
        BindingResult bindingResult = new BeanPropertyBindingResult(localRequestDTO, "localRequestDTO");

        when(localRepository.findByCodigo(anyString())).thenReturn(Optional.of(local));

        localController.adicionar(localRequestDTO, bindingResult, mock(Model.class), mock(RedirectAttributes.class));

        verify(localRepository, never()).save(any());
    }
}