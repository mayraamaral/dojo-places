package br.com.alura.dojoplaces.model;

import java.time.LocalDate;

public class Local {
    private String nome;
    private String codigo;
    private String bairro;
    private String cidade;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public Local(String nome, String codigo, String bairro, String cidade, LocalDate dataCriacao) {
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dataCriacao = dataCriacao;
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

    private void setDataCriacao() {
        this.dataCriacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Local{" +
            "nome='" + nome + '\'' +
            ", codigo='" + codigo + '\'' +
            ", bairro='" + bairro + '\'' +
            ", cidade='" + cidade + '\'' +
            ", dataCriacao=" + dataCriacao +
            '}';
    }
}
