package br.com.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rua_linha")
public class RuaLinha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuaLinha;

    private String nomeRua;
    private String cepRua;
    private float extensao;
    private boolean possuiAsfaltamento;
    private String criticidadeLocomocao;
    private String tipoLogradouro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idLocalidade"
    )
    private Localidade localidade;

    public RuaLinha() {}

    public RuaLinha(String nomeRua, String cepRua, float extensao, boolean possuiAsfaltamento,
                    String criticidadeLocomocao, String tipoLogradouro, Localidade localidade) {
        this.nomeRua = nomeRua;
        this.cepRua = cepRua;
        this.extensao = extensao;
        this.possuiAsfaltamento = possuiAsfaltamento;
        this.criticidadeLocomocao = criticidadeLocomocao;
        this.tipoLogradouro = tipoLogradouro;
        this.localidade = localidade;
    }

    public int getId() {
        return idRuaLinha;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getCepRua() {
        return cepRua;
    }

    public void setCepRua(String cepRua) {
        this.cepRua = cepRua;
    }

    public float getExtensao() {
        return extensao;
    }

    public void setExtensao(float extensao) {
        this.extensao = extensao;
    }

    public boolean isPossuiAsfaltamento() {
        return possuiAsfaltamento;
    }

    public void setPossuiAsfaltamento(boolean possuiAsfaltamento) {
        this.possuiAsfaltamento = possuiAsfaltamento;
    }

    public String getCriticidadeLocomocao() {
        return criticidadeLocomocao;
    }

    public void setCriticidadeLocomocao(String criticidadeLocomocao) {
        this.criticidadeLocomocao = criticidadeLocomocao;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return  "\nID: " + idRuaLinha + "\n" +
                nomeRua + "\nExtensão: " + extensao
                + "\nCEP: " + cepRua
                + "\nPossui asfaltamento: " + (possuiAsfaltamento ? "Sim" : "Não")
                + "\nTipo de logradouro: " + tipoLogradouro
                + "\nCriticidade de locomoção: " + criticidadeLocomocao
                + "\nBairro: " + localidade.getNomeLocalidade() + "\n";
    }
}
