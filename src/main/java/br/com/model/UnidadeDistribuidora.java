package br.com.model;

import br.com.enums.Tipo_Distribuicao;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "unidade_distribuidora")
public class UnidadeDistribuidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadeDistribuidora;

    private String nomeUnidade;
    private String descricaoUnidade;
    private String localizacaoUnidade;
    private boolean status;
    private LocalDate dataAtivacao;
    private String responsavelTecnico;

    @Enumerated(EnumType.STRING)
    private Tipo_Distribuicao tipoDistribuicao;

    private float capacidadeOperacionalMaxima;

    public UnidadeDistribuidora() {}

    public UnidadeDistribuidora(String nomeUnidade, String descricaoUnidade, String localizacaoUnidade, boolean status,
                                LocalDate dataAtivacao, String responsavelTecnico, Tipo_Distribuicao tipoDistribuicao,
                                float capacidadeOperacionalMaxima) {
        this.nomeUnidade = nomeUnidade;
        this.descricaoUnidade = descricaoUnidade;
        this.localizacaoUnidade = localizacaoUnidade;
        this.status = status;
        this.dataAtivacao = dataAtivacao;
        this.responsavelTecnico = responsavelTecnico;
        this.tipoDistribuicao = tipoDistribuicao;
        this.capacidadeOperacionalMaxima = capacidadeOperacionalMaxima;
    }

    // Getters e setters

    public int getId() {
        return idUnidadeDistribuidora;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    public String getLocalizacaoUnidade() {
        return localizacaoUnidade;
    }

    public void setLocalizacaoUnidade(String localizacaoUnidade) {
        this.localizacaoUnidade = localizacaoUnidade;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public String getResponsavelTecnico() {
        return responsavelTecnico;
    }

    public void setResponsavelTecnico(String responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    public Tipo_Distribuicao getTipoDistribuicao() {
        return tipoDistribuicao;
    }

    public void setTipoDistribuicao(Tipo_Distribuicao tipoDistribuicao) {
        this.tipoDistribuicao = tipoDistribuicao;
    }

    public float getCapacidadeOperacionalMaxima() {
        return capacidadeOperacionalMaxima;
    }

    public void setCapacidadeOperacionalMaxima(float capacidadeOperacionalMaxima) {
        this.capacidadeOperacionalMaxima = capacidadeOperacionalMaxima;
    }

    @Override
    public String toString() {
        return  "\nID: " + idUnidadeDistribuidora + "\n" +
                "Unidade Distribuidora: " + nomeUnidade
                + "\nID: " + idUnidadeDistribuidora
                + "\nDescrição: " + descricaoUnidade
                + "\nLocalização: " + localizacaoUnidade
                + "\nStatus: " + (status ? "Ativo" : "Inativo")
                + "\nData de Ativação: " + dataAtivacao
                + "\nResponsável Técnico: " + responsavelTecnico
                + "\nTipo de Distribuição: " + tipoDistribuicao
                + "\nCapacidade Operacional Máxima: " + capacidadeOperacionalMaxima + "\n";
    }
}
