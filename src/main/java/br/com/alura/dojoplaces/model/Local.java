package br.com.alura.dojoplaces.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Local {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String codigo;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    public Local() {}

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

    public LocalRequestDTO toRequestDTO() {
        return new LocalRequestDTO(nome, codigo, bairro, cidade, dataCriacao);
    }

    public LocalResponseDTO toResponseDTO() {
        return new LocalResponseDTO(id, nome, codigo, bairro, cidade, dataCriacao, dataAtualizacao);
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
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
