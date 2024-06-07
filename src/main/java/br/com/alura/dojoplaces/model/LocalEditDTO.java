package br.com.alura.dojoplaces.model;

public class LocalEditDTO {
    private String nome;
    private String codigo;
    private String bairro;
    private String cidade;

    public LocalEditDTO(String nome, String codigo, String bairro, String cidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
