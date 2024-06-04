package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class LocalDTO {
//    @Max(value = 100, message = "São permitidos nomes com até 100 caracteres")
    private String nome;

//    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Não são permitidos caracteres especiais, nem espaços")
    private String codigo;

//    @Max(value = 100, message = "São permitidos bairros com até 100 caracteres")
    private String bairro;

//    @Max(value = 100, message = "São permitidos cidades com até 100 caracteres")
    private String cidade;

    private LocalDate dataCriacao;

    public LocalDTO() {}

    public LocalDTO(String nome, String codigo, String bairro, String cidade, String dataCriacao) {
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dataCriacao = LocalDate.parse(dataCriacao);
    }

    public Local toModel() {
        return new Local(nome, codigo, bairro, cidade, dataCriacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = LocalDate.parse(dataCriacao);
    }
}
