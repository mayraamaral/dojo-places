package br.com.alura.dojoplaces.utils.validator;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CodigoValidatorTest {

    private LocalRepository localRepository;
    private CodigoValidator codigoValidator;

    @BeforeEach
    void setUp() {
        localRepository = mock(LocalRepository.class);
        codigoValidator = new CodigoValidator(localRepository);
    }

    @Test
    void validate_should_return_true_when_codigo_is_repeated() {
        LocalRequestDTO localDto = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());
        Local local = localDto.toModel();
        Errors errors = new BeanPropertyBindingResult(localDto, "localRequestDTO");

        when(localRepository.findByCodigo(any())).thenReturn(Optional.of(local));
        codigoValidator.validate(localDto, errors);

        assertThat(errors.hasFieldErrors("codigo")).isTrue();
        assertThat("codigo.exist").isEqualTo(errors.getFieldError("codigo").getCode());
    }

    @Test
    void validate_should_return_false_when_codigo_is_repeated() {
        LocalRequestDTO localDto = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());
        Errors errors = new BeanPropertyBindingResult(localDto, "localRequestDTO");

        when(localRepository.findByCodigo(any())).thenReturn(Optional.empty());
        codigoValidator.validate(localDto, errors);

        assertThat(errors.hasFieldErrors("codigo")).isFalse();
    }
}