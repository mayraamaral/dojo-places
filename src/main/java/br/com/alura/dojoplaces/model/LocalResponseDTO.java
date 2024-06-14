package br.com.alura.dojoplaces.model;

import br.com.alura.dojoplaces.utils.DateUtils;

import java.time.LocalDate;
import java.util.Optional;

public class LocalResponseDTO {
    private Long id;
    private String nome;
    private String codigo;
    private String bairro;
    private String cidade;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;

    public LocalResponseDTO(Long id, String nome, String codigo, String bairro, String cidade, LocalDate dataCriacao, LocalDate dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
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

    public String getDataCriacaoFormatada() {
        return DateUtils.formatDate(dataCriacao);
    }

    public String getDataAtualizacaoFormatada() {
        if(Optional.ofNullable(dataAtualizacao).isEmpty()) {
            return "";
        }

        return DateUtils.formatDate(dataAtualizacao);
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

}
