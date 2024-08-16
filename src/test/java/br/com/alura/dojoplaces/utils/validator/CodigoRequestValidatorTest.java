package br.com.alura.dojoplaces.utils.validator;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CodigoRequestValidatorTest {

    private LocalRepository localRepository;
    private CodigoRequestValidator codigoValidator;

    @BeforeEach
    void setUp() {
        localRepository = mock(LocalRepository.class);
        codigoValidator = new CodigoRequestValidator(localRepository);
    }

    @Test
    void validate_should_return_true_when_codigo_is_repeated() {
        LocalRequestDTO localDto = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());
        Local local = localDto.toModel();
        Errors errors = new BeanPropertyBindingResult(localDto, "localRequestDTO");

        when(localRepository.existsByCodigo(any())).thenReturn(true);
        codigoValidator.validate(localDto, errors);

        assertThat(errors.hasFieldErrors("codigo")).isTrue();
        assertThat("codigo.exist").isEqualTo(errors.getFieldError("codigo").getCode());
    }

    @Test
    void validate_should_return_false_when_codigo_is_not_repeated() {
        LocalRequestDTO localDto = new LocalRequestDTO("nome", "codigo", "bairro", "cidade", LocalDate.now());
        Errors errors = new BeanPropertyBindingResult(localDto, "localRequestDTO");

        when(localRepository.existsByCodigo(any())).thenReturn(false);
        codigoValidator.validate(localDto, errors);

        assertThat(errors.hasFieldErrors("codigo")).isFalse();
    }
}