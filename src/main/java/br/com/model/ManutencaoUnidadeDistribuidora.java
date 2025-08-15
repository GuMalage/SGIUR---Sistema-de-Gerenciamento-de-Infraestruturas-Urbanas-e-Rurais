package br.com.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "manutencao_unidade_distribuidora")
public class ManutencaoUnidadeDistribuidora {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idManutencaoUnidadeDistribuidora;

    private String descricaoManutencao;
    private LocalDate dataManutencaoUnidadadeDistribuidora;

    @ManyToOne
    @JoinColumn(
            name = "idUnidadeDistribuidora"
    )
    private UnidadeDistribuidora unidade_distribuidora;

    public ManutencaoUnidadeDistribuidora() {

    }

    public ManutencaoUnidadeDistribuidora(String descricaoManutencao, LocalDate dataManutencaoUnidadadeDistribuidora, UnidadeDistribuidora unidade_distribuidora) {
        this.descricaoManutencao = descricaoManutencao;
        this.dataManutencaoUnidadadeDistribuidora = dataManutencaoUnidadadeDistribuidora;
        this.unidade_distribuidora = unidade_distribuidora;
    }

    public int getIdManutencaoUnidadeTratamento() {
        return idManutencaoUnidadeDistribuidora;
    }

    public String getDescricaoManutencao() {
        return descricaoManutencao;
    }

    public void setDescricaoManutencao(String descricaoManutencao) {
        this.descricaoManutencao = descricaoManutencao;
    }

    public LocalDate getDataManutencaoUnidadadeDistribuidora() {
        return dataManutencaoUnidadadeDistribuidora;
    }

    public void setDataManutencaoUnidadadeDistribuidora(LocalDate dataManutencaoUnidadadeDistribuidora) {
        this.dataManutencaoUnidadadeDistribuidora = dataManutencaoUnidadadeDistribuidora;
    }

    public UnidadeDistribuidora getUnidade_distribuidora() {
        return unidade_distribuidora;
    }

    public void setUnidade_distribuidora(UnidadeDistribuidora unidade_distribuidora) {
        this.unidade_distribuidora = unidade_distribuidora;
    }

    @Override
    public String toString() {
        return "\nUnidade Distribuidora: " + unidade_distribuidora.getNomeUnidade() + " || ID: "  + unidade_distribuidora.getId() +
                "\nDescrição da Manutenção: " + descricaoManutencao +
                "\nData: " + dataManutencaoUnidadadeDistribuidora + "\n";
    }
}
