package br.com.alura.dojoplaces.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LocalRequestDTOTest {

    private final Validator validator;

    public LocalRequestDTOTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @ParameterizedTest
    @ValueSource(strings =
        {"codigovalido123",
        "CodigoValido123",
        "codigovalido",
        "CodigoValido"})
    public void should_accept_codigo_that_follows_pattern(String codigo) {
        LocalRequestDTO localRequestDTO = new LocalRequestDTO("nome", codigo, "bairro", "cidade", LocalDate.now());

        Set<ConstraintViolation<LocalRequestDTO>> violations = validator.validate(localRequestDTO);

        assertThat(violations.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings =
        {"codigo_nao_valido123",
        "Codigo Nao Valido123",
        "codigo nao valido",
        "Codigo_Nao_Valido"})
    public void should_reject_codigo_that_follows_pattern(String codigo) {
        LocalRequestDTO localRequestDTO = new LocalRequestDTO("nome", codigo, "bairro", "cidade", LocalDate.now());

        Set<ConstraintViolation<LocalRequestDTO>> violations = validator.validate(localRequestDTO);

        assertThat(violations.isEmpty()).isFalse();
        assertThat(violations
            .stream().anyMatch(violation ->
                violation.getMessage().equals("Não são permitidos caracteres especiais, nem espaços")))
            .isTrue();
    }

}