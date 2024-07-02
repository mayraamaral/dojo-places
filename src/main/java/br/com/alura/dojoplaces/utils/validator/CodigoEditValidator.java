package br.com.alura.dojoplaces.utils.validator;

import br.com.alura.dojoplaces.model.Local;
import br.com.alura.dojoplaces.model.LocalEditDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CodigoEditValidator implements Validator {

    private final LocalRepository localRepository;

    public CodigoEditValidator(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LocalEditDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalEditDTO localEditDTO = (LocalEditDTO) target;

        if(localRepository.existsByCodigoAndIdNot(localEditDTO.getCodigo(), localEditDTO.getId())) {
            errors.rejectValue("codigo", "codigo.exist", "O código já existe");
        }
    }
}
