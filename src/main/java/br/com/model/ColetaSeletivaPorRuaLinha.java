package br.com.model;

import br.com.enums.Tipo_Tratamento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "coleta_seletiva_rua_linha")
public class ColetaSeletivaPorRuaLinha{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUnidadeTratamento")
    private UnidadeTratamento unidadeTratamento;

    @ManyToOne
    @JoinColumn(name = "idRuaLinha")
    private RuaLinha ruaLinha;

    private LocalDate inicioColeta;
    private String diasColeta;

    public ColetaSeletivaPorRuaLinha() {
    }

    public ColetaSeletivaPorRuaLinha(UnidadeTratamento unidadeTratamento, RuaLinha ruaLinha, LocalDate inicioColeta, String diaColeta) {
        if (unidadeTratamento.getTipoTratamento() != Tipo_Tratamento.LIXO) {
            throw new Error("Apenas unidades de tratamento de lixo são permitidas.");
        }
        this.unidadeTratamento = unidadeTratamento;
        this.ruaLinha = ruaLinha;
        this.inicioColeta = inicioColeta;
        this.diasColeta = diaColeta;
    }

    public int getId() {
        return id;
    }

    public UnidadeTratamento getUnidadeTratamento() {
        return unidadeTratamento;
    }

    public void setUnidadeTratamento(UnidadeTratamento unidadeTratamento) {
        if (unidadeTratamento.getTipoTratamento() != Tipo_Tratamento.LIXO) {
            throw new Error("Apenas unidades de tratamento de lixo são permitidas.");
        }
        this.unidadeTratamento = unidadeTratamento;
    }

    public RuaLinha getRuaLinha() {
        return ruaLinha;
    }

    public void setRuaLinha(RuaLinha ruaLinha) {
        this.ruaLinha = ruaLinha;
    }

    public LocalDate getInicioColeta() {
        return inicioColeta;
    }

    public void setInicioColeta(LocalDate inicioColeta) {
        this.inicioColeta = inicioColeta;
    }

    public String getDiasColeta() {
        return diasColeta;
    }

    public void setDiasColeta(String diasColeta) {
        this.diasColeta = diasColeta;
    }

    @Override
    public String toString() {
        return  "\nID:" + id +
                "\nUnidade de Tratamento de Lixo: " + unidadeTratamento.getNomeUnidade() +
                "\nRua - Comunidade Rural: " + ruaLinha.getNomeRua() +
                "\nData de inicio da coleta: " + inicioColeta +
                "\nDias semanis da coleta: '" + diasColeta;
    }
}
