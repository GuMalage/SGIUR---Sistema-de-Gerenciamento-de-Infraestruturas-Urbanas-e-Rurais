package br.com.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "manutencao_unidade_tratamento")
public class ManutencaoUnidadeTratamento {
    @Id
    @GeneratedValue(
      strategy = GenerationType.IDENTITY
    )
    private int idManutencaoUnidadeTratamento;

    private String descricaoManutencao;
    private LocalDate dataManutencaoUnidadadeTratamento;

    @ManyToOne
    @JoinColumn(
            name = "idUnidadeTratamento"
    )
    private UnidadeTratamento unidade_tratamento;

    public ManutencaoUnidadeTratamento() {

    }

    public ManutencaoUnidadeTratamento(String descricaoManutencao, LocalDate dataManutencaoUnidadadeTratamento, UnidadeTratamento unidade_tratamento) {
        this.descricaoManutencao = descricaoManutencao;
        this.dataManutencaoUnidadadeTratamento = dataManutencaoUnidadadeTratamento;
        this.unidade_tratamento = unidade_tratamento;
    }

    public int getIdManutencaoUnidadeTratamento() {
        return idManutencaoUnidadeTratamento;
    }

    public String getDescricaoManutencao() {
        return descricaoManutencao;
    }

    public void setDescricaoManutencao(String descricaoManutencao) {
        this.descricaoManutencao = descricaoManutencao;
    }

    public LocalDate getDataManutencaoUnidadadeTratamento() {
        return dataManutencaoUnidadadeTratamento;
    }

    public void setDataManutencaoUnidadadeTratamento(LocalDate dataManutencaoUnidadadeTratamento) {
        this.dataManutencaoUnidadadeTratamento = dataManutencaoUnidadadeTratamento;
    }

    public UnidadeTratamento getUnidade_tratamento() {
        return unidade_tratamento;
    }

    public void setUnidade_tratamento(UnidadeTratamento unidade_tratamento) {
        this.unidade_tratamento = unidade_tratamento;
    }

    @Override
    public String toString() {
        return "\nUnidade Distribuidora: " + unidade_tratamento.getNomeUnidade() + " || ID: "  + unidade_tratamento.getId() +
                "\nDescrição da Manutenção: " + descricaoManutencao +
                "\nData: " + dataManutencaoUnidadadeTratamento + "\n";
    }
}
