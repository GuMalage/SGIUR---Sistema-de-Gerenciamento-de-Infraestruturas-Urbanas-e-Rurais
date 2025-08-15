package br.com.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(
    name = "unidade_consumidora_tratamento"
)
public class ConexaoUnidadeConsumidoraTratamento {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private int idUnidadeConsumidoraTratamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idUnidadeTratamento"
    )
    private UnidadeTratamento unidadeTratamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idUnidadeConsumidora"
    )
    private UnidadeConsumidora unidadeConsumidora;

    private LocalDate dataConexao;

    public ConexaoUnidadeConsumidoraTratamento(){

    }

    public ConexaoUnidadeConsumidoraTratamento(UnidadeTratamento unidadeTratamento, UnidadeConsumidora unidadeConsumidora,
                                               LocalDate dataConexao) {
        this.unidadeTratamento = unidadeTratamento;
        this.unidadeConsumidora = unidadeConsumidora;
        this.dataConexao = dataConexao;
    }

    public int getIdUnidadeConsumidoraTratamento() {
        return idUnidadeConsumidoraTratamento;
    }

    public UnidadeTratamento getIdUnidadeTratamento() {
        return unidadeTratamento;
    }

    public void setUnidadeTratamento(UnidadeTratamento unidadeTratamento) {
        this.unidadeTratamento = unidadeTratamento;
    }

    public UnidadeConsumidora getIdUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setIdUnidadeConsumidora(UnidadeConsumidora idUnidadeConsumidora) {
        this.unidadeConsumidora = idUnidadeConsumidora;
    }

    public LocalDate getDataConexao() {
        return dataConexao;
    }

    public void setDataConexao(LocalDate dataConexao) {
        this.dataConexao = dataConexao;
    }

    @Override
    public String toString() {
        return "Unidade Consumidora: " + unidadeConsumidora.getId() + " || Responsavel: " + unidadeConsumidora.getNomeResponsavel()
                + "\nUnidade_Tratamento: " + unidadeTratamento.getNomeUnidade() + " || Identificador: " + unidadeTratamento.getId()
                + "\nLocalização: " + unidadeTratamento.getLocalizacaoUnidade() + "|| Tipo: "  + unidadeTratamento.getTipoTratamento()
                + "\nData da conexão: " + dataConexao;
    }
}
