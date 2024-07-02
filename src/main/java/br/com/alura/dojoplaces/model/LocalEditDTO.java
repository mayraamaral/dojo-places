package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LocalEditDTO {
    private Long id;

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

    private boolean isDirty;

    public LocalEditDTO(Long id, String nome, String codigo, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void markAsDirty() {
        this.isDirty = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
