package br.com.model;

import br.com.enums.Tipo_Tratamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "unidade_de_tratamento")
public class UnidadeTratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadeTratamento;

    private String nomeUnidade;
    private String descricaoUnidade;
    private String localizacaoUnidade;
    private boolean status;
    private LocalDate dataAtivacao;
    private String responsavelTecnico;

    @Enumerated(EnumType.STRING)
    private Tipo_Tratamento tipoTratamento;

    private float capacidadeTratamento;
    private float nivelEficiencia;

    public UnidadeTratamento() {}

    public UnidadeTratamento(String nomeUnidade, String descricaoUnidade, String localizacaoUnidade, boolean status,
                             LocalDate dataAtivacao, String responsavelTecnico, Tipo_Tratamento tipoTratamento,
                             float capacidadeTratamento, float nivelEficiencia) {
        this.nomeUnidade = nomeUnidade;
        this.descricaoUnidade = descricaoUnidade;
        this.localizacaoUnidade = localizacaoUnidade;
        this.status = status;
        this.dataAtivacao = dataAtivacao;
        this.responsavelTecnico = responsavelTecnico;
        this.tipoTratamento = tipoTratamento;
        this.capacidadeTratamento = capacidadeTratamento;
        this.nivelEficiencia = nivelEficiencia;
    }

    // Getters e setters

    public int getId() {
        return idUnidadeTratamento;
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

    public Tipo_Tratamento getTipoTratamento() {
        return tipoTratamento;
    }

    public void setTipoTratamento(Tipo_Tratamento tipoTratamento) {
        this.tipoTratamento = tipoTratamento;
    }

    public float getCapacidadeTratamento() {
        return capacidadeTratamento;
    }

    public void setCapacidadeTratamento(float capacidadeTratamento) {
        this.capacidadeTratamento = capacidadeTratamento;
    }

    public float getNivelEficiencia() {
        return nivelEficiencia;
    }

    public void setNivelEficiencia(float nivelEficiencia) {
        this.nivelEficiencia = nivelEficiencia;
    }

    @Override
    public String toString() {
        return  "\nID: " + idUnidadeTratamento + "\n" +
                "Unidade Tratamento: " + nomeUnidade
                + "\nID: " + idUnidadeTratamento
                + "\nDescrição: " + descricaoUnidade
                + "\nLocalização: " + localizacaoUnidade
                + "\nStatus: " + (status ? "Ativo" : "Inativo")
                + "\nData de Ativação: " + dataAtivacao
                + "\nResponsável Técnico: " + responsavelTecnico
                + "\nTipo de Tratamento: " + tipoTratamento
                + "\nCapacidade de Tratamento: " + capacidadeTratamento
                + "\nNível de Eficiência: " + nivelEficiencia + "\n";
    }
}
