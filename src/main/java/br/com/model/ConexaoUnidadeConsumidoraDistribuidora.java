package br.com.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "unidade_consumidora_distribuidora")
public class ConexaoUnidadeConsumidoraDistribuidora {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private int idUnidadeConsumidoraDistribuidora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idUnidadeTratamento"
    )
    private UnidadeDistribuidora unidadeDistribuidora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idUnidadeConsumidora"
    )
    private UnidadeConsumidora unidadeConsumidora;

    private LocalDate dataConexao;

    public ConexaoUnidadeConsumidoraDistribuidora(){

    }

    public ConexaoUnidadeConsumidoraDistribuidora(UnidadeDistribuidora unidadeDistribuidora, UnidadeConsumidora unidadeConsumidora,
                                                  LocalDate dataConexao) {
        this.unidadeDistribuidora = unidadeDistribuidora;
        this.unidadeConsumidora = unidadeConsumidora;
        this.dataConexao = dataConexao;
    }

    public int getIdUnidadeConsumidoraTratamento() {
        return idUnidadeConsumidoraDistribuidora;
    }

    public UnidadeDistribuidora getIdUnidadeDistribuidora() {
        return unidadeDistribuidora;
    }

    public void setUnidadeDistribuidora(UnidadeDistribuidora unidadeDistribuidora) {
        this.unidadeDistribuidora = unidadeDistribuidora;
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
                + "\nUnidade_Tratamento: " + unidadeDistribuidora.getNomeUnidade() + " || Identificador: " + unidadeDistribuidora.getId()
                + "\nLocalização: " + unidadeDistribuidora.getLocalizacaoUnidade() + "|| Tipo: "  + unidadeDistribuidora.getTipoDistribuicao()
                + "\nData da conexão: " + dataConexao;
    }
}
