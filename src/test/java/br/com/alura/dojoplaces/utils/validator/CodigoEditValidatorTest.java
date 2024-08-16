package br.com.alura.dojoplaces.utils.validator;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CodigoEditValidatorTest {

    private LocalRepository localRepository;
    private CodigoEditValidator codigoValidator;

    @BeforeEach
    void setUp() {
        localRepository = mock(LocalRepository.class);
        codigoValidator = new CodigoEditValidator(localRepository);
    }

    @Test
    void validate_should_return_true_when_codigo_is_repeated() {
        Local local = new Local("nome", "codigo", "bairro", "cidade", LocalDate.now());
        LocalEditDTO localEditDTO = local.toEditDTO();
        Errors errors = new BeanPropertyBindingResult(localEditDTO, "localEditDTO");

        when(localRepository.existsByCodigoAndIdNot(any(), any())).thenReturn(true);
        codigoValidator.validate(localEditDTO, errors);

        assertThat(errors.hasFieldErrors("codigo")).isTrue();
        assertThat("codigo.exist").isEqualTo(errors.getFieldError("codigo").getCode());
    }

    @Test
    void validate_should_return_false_when_codigo_is_not_repeated() {
        LocalEditDTO localDto = new LocalEditDTO(1L, "nome", "codigo", "bairro", "cidade");
        Errors errors = new BeanPropertyBindingResult(localDto, "localEditDTO");

        when(localRepository.existsByCodigoAndIdNot(any(), any())).thenReturn(false);
        codigoValidator.validate(localDto, errors);

        assertThat(errors.hasFieldErrors("codigo")).isFalse();
    }
}