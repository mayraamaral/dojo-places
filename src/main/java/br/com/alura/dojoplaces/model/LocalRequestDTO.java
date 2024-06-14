package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class LocalRequestDTO {

    @Size(max = 100, message = "São permitidos nomes com até 100 caracteres")
    @NotBlank(message = "O nome não pode ficar em branco")
    private String nome;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Não são permitidos caracteres especiais, nem espaços")
    @NotBlank(message = "O código não pode ficar em branco")
    private String codigo;

    @Size(max = 100, message = "São permitidos nomes de bairros com até 100 caracteres")
    @NotBlank(message = "O bairro não pode ficar em branco")
    private String bairro;

    @Size(max = 100, message = "São permitidos nomes de cidades com até 100 caracteres")
    @NotBlank(message = "A cidade não pode ficar em branco")
    private String cidade;

    @PastOrPresent(message = "A data precisa ser no passado ou no presente")
    @NotNull(message = "A data não pode ficar em branco")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;

    public LocalRequestDTO(String nome, String codigo, String bairro, String cidade, LocalDate dataCriacao) {
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dataCriacao = dataCriacao;
    }

    public Local toModel() {
        return new Local(nome, codigo, bairro, cidade, dataCriacao);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
