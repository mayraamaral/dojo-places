package br.com.alura.dojoplaces.utils.validator;

import br.com.alura.dojoplaces.model.LocalRequestDTO;
import br.com.alura.dojoplaces.repository.LocalRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CodigoValidator implements Validator {

    private final LocalRepository localRepository;

    public CodigoValidator(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LocalRequestDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalRequestDTO localRequestDTO = (LocalRequestDTO) target;

        if(localRepository.findByCodigo(localRequestDTO.getCodigo()).isPresent()) {
            errors.rejectValue("codigo", "codigo.exist", "O código já existe");
        }
    }
}
