package br.com.model;

import br.com.enums.Tipo_Localidade;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "localidade")
public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocalidade;

    private String nomeLocalidade;
    private String cep;

    @Enumerated(EnumType.STRING)
    private Tipo_Localidade tipoLocalidade;

    private int populacaoEstimada;
    private float areaEstimada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idCidade"
    )
    private Cidade cidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idAtividadePrincipal"
    )
    private AtividadePrincipal atividadePrincipal;

    public Localidade() {}

    public Localidade(String nomeLocalidade, String cep, Tipo_Localidade tipoLocalidade, int populacaoEstimada,
                      float areaEstimada, Cidade cidade, AtividadePrincipal atividadePrincipal) {
        this.nomeLocalidade = nomeLocalidade;
        this.cep = cep;
        this.tipoLocalidade = tipoLocalidade;
        this.populacaoEstimada = populacaoEstimada;
        this.areaEstimada = areaEstimada;
        this.cidade = cidade;
        this.atividadePrincipal = atividadePrincipal;
    }

    public int getIdBairro() {
        return idLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public Tipo_Localidade getTipoLocalidade() {
        return tipoLocalidade;
    }

    public void setTipoLocalidade(Tipo_Localidade tipoLocalidade) {
        this.tipoLocalidade = tipoLocalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getPopulacaoEstimada() {
        return populacaoEstimada;
    }

    public void setPopulacaoEstimada(int populacaoEstimada) {
        this.populacaoEstimada = populacaoEstimada;
    }

    public float getAreaEstimada() {
        return areaEstimada;
    }

    public void setAreaEstimada(float areaEstimada) {
        this.areaEstimada = areaEstimada;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public AtividadePrincipal getAtividadePrincipal() {
        return atividadePrincipal;
    }

    public void setAtividadePrincipal(AtividadePrincipal atividadePrincipal) {
        this.atividadePrincipal = atividadePrincipal;
    }

    @Override
    public String toString() {
        return "\nID: " + idLocalidade + "\n" +
                nomeLocalidade + "\nCEP: " + cep
                + "\nZona: " + tipoLocalidade
                + "\nPopulacao: " + populacaoEstimada
                + "\nArea: " + areaEstimada
                + "\nAtividade Principal Desenvolvida: " + atividadePrincipal
                + "\nCidade: " + cidade + "\n";
    }
}
