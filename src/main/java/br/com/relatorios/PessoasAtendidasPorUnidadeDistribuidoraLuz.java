package br.com.relatorios;

import java.io.Serializable;

public class PessoasAtendidasPorUnidadeDistribuidoraLuz implements Serializable {

    private String nomeUnidadeDistribuidora;
    private String localizacaoUnidadeDistribuidora;
    private float capacidadeOperacionalMaxima;
    private Long qntPessoasUnidadeConsumidora;
    private String conclusao;

    public PessoasAtendidasPorUnidadeDistribuidoraLuz(String nomeUnidadeDistribuidora, String localizacaoUnidadeDistribuidora,
                                                      float capacidadeOperacionalMaxima, Long qntPessoasUnidadeConsumidora) {
        this.nomeUnidadeDistribuidora = nomeUnidadeDistribuidora;
        this.localizacaoUnidadeDistribuidora = localizacaoUnidadeDistribuidora;
        this.capacidadeOperacionalMaxima = capacidadeOperacionalMaxima;
        this.qntPessoasUnidadeConsumidora = qntPessoasUnidadeConsumidora;
        this.conclusao = capacidadeRestanteSobressalente(capacidadeOperacionalMaxima, qntPessoasUnidadeConsumidora);
    }

    public String capacidadeRestanteSobressalente(float capacidadeOperacionalMaxima, Long qntPessoasUnidadeConsumidora) {
        long capacidadeMaxPessoas = Math.round(capacidadeOperacionalMaxima * 2640);
        long restante = capacidadeMaxPessoas - qntPessoasUnidadeConsumidora;

        if (restante >= 0) {
            return "Resta capacidade para: " + restante + " pessoas.";
        } else {
            return "Capacidade excedida em: " + Math.abs(restante) + " pessoas.";
        }
    }

    @Override
    public String toString() {
        return "Unidade Distribuidora de Luz: " + nomeUnidadeDistribuidora +
                "\nLocalizacao da Unidade Distribuidora: " + localizacaoUnidadeDistribuidora +
                "\nCapacidade Maxima de distribuição (MVA): " + capacidadeOperacionalMaxima +
                "\nQuantidade de Pessoas que atende: " + qntPessoasUnidadeConsumidora +
                "\nConclusão: " + conclusao  + "\n";
    }
}
