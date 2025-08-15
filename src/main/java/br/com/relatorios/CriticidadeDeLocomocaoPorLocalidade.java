package br.com.relatorios;

import java.io.Serializable;

public class CriticidadeDeLocomocaoPorLocalidade implements Serializable {
    private String nomeLocalidade;
    private String nomeRua;
    private String tipoLogradouro;
    private String nomeAtividade;
    private String criticidadeLocomocao;

    public CriticidadeDeLocomocaoPorLocalidade(String nomeLocalidade, String nomeRua, String tipoLogradouro, String nomeAtividade, String criticidadeLocomocao) {
        this.nomeLocalidade = nomeLocalidade;
        this.nomeRua = nomeRua;
        this.tipoLogradouro = tipoLogradouro;
        this.nomeAtividade = nomeAtividade;
        this.criticidadeLocomocao = criticidadeLocomocao;
    }

    @Override
    public String toString() {
        return "\nLocalidade: " + nomeLocalidade +
                "\nRua - Linha: '" + nomeRua +
                "\nLogradouro: " + tipoLogradouro +
                "Atividade Principal da Localidade: " + nomeAtividade +
                "\nCriticidade Locomocao da Rua - Linha: " + criticidadeLocomocao  + "\n";
    }

}
