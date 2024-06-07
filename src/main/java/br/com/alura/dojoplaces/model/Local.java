package br.com.alura.dojoplaces.model;

import br.com.alura.dojoplaces.utils.DateUtils;

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

    public void edit(LocalEditDTO localEdited) {
        this.nome = localEdited.getNome();
        this.codigo = localEdited.getCodigo();
        this.bairro = localEdited.getBairro();
        this.cidade = localEdited.getCidade();
        this.dataAtualizacao = LocalDate.now();
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

    public String getDataFormatada() {
        return DateUtils.formatDate(dataCriacao);
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
