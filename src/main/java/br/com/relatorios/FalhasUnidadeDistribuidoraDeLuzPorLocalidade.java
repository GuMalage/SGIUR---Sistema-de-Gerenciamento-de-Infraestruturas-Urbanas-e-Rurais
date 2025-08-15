package br.com.relatorios;

import java.io.Serializable;

public class FalhasUnidadeDistribuidoraDeLuzPorLocalidade implements Serializable {
    private String nomeUnidadeDistribuidora;
    private String localizacaoUnidadeDistribuidora;
    private String nomeLocalidade;
    private String nomeAtividade;
    private String descricaoAtividade;
    private Long qntFalhasUnidadeDistribuidora;

    public FalhasUnidadeDistribuidoraDeLuzPorLocalidade(String nomeUnidadeDistribuidora,
            String localizacaoUnidadeDistribuidora, String nomeLocalidade,
            String nomeAtividade, String descricaoAtividade, Long qntFalhasUnidadeDistribuidora) {
        this.nomeUnidadeDistribuidora = nomeUnidadeDistribuidora;
        this.localizacaoUnidadeDistribuidora = localizacaoUnidadeDistribuidora;
        this.nomeLocalidade = nomeLocalidade;
        this.nomeAtividade = nomeAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.qntFalhasUnidadeDistribuidora = qntFalhasUnidadeDistribuidora;
    }

    @Override
    public String toString() {
        return  "\nNome da Localidade Atendida: " + nomeLocalidade +
                "\nAtividade Principal desenvolvida na Localidade: " + nomeAtividade +
                "\nDescrição da Atividade: '" + descricaoAtividade +
                "\nNome da Unidade Distribuidota de Fornecimento: " + nomeUnidadeDistribuidora +
                "\nLocalização da Unidade Distribuidota de Fornecimento: " + localizacaoUnidadeDistribuidora +
                "\nQuantidade de Falhas na unidade Distribuidora: " + qntFalhasUnidadeDistribuidora + "\n";
    }



}
