package br.com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCidade;

    private String nomeCidade;
    private String uf;
    @Column(name = "populacao")
    private Integer populacaoEstimada;

    public Cidade() {}

    public Cidade(String nomeCidade, String uf, int populacaoEstimada) {
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.populacaoEstimada = populacaoEstimada;
    }

    public int getId() {
        return idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getPopulacaoEstimada() {
        return populacaoEstimada;
    }

    public void setPopulacao(int populacaoEstimada) {
        this.populacaoEstimada = populacaoEstimada;
    }

    @Override
    public String toString() {
        return "ID: " + idCidade + "\n" + nomeCidade + " || Estado: " + uf + " || Populacao: " + populacaoEstimada + "\n";
    }
}
