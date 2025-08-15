package br.com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atividades_principai")
public class AtividadePrincipal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtividadePrincipal;

    private String nomeAtividade;
    private String descricaoAtividade;

    public AtividadePrincipal() {}

    public AtividadePrincipal(String nomeAtividade, String descricaoAtividade) {
        this.nomeAtividade = nomeAtividade;
        this.descricaoAtividade = descricaoAtividade;
    }

    public int getId() {
        return idAtividadePrincipal;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    @Override
    public String toString() {
        return "ID: " + idAtividadePrincipal + "\n" + nomeAtividade + ": " + descricaoAtividade + "\n";
    }
}
