package br.com.relatorios;

import java.io.Serializable;
import java.time.LocalDate;

public class ConexoesUnidadeConsumidoraTratamentoPorPeriodo implements Serializable {
    private int identificadorUnidadeConsumidora;
    private int idUnidadeTratamento;
    private String nomeUnidadeTratamento;
    private String contatoResponsavelUnidadeConsumidora;
    private LocalDate dataConexao;

    public ConexoesUnidadeConsumidoraTratamentoPorPeriodo(int identificadorUnidadeConsumidora, int idUnidadeTratamento, String nomeUnidadeTratamento,
                                                         String contatoResponsavelUnidadeConsumidora, LocalDate dataConexao) {
        this.identificadorUnidadeConsumidora = identificadorUnidadeConsumidora;
        this.idUnidadeTratamento = idUnidadeTratamento;
        this.nomeUnidadeTratamento = nomeUnidadeTratamento;
        this.contatoResponsavelUnidadeConsumidora = contatoResponsavelUnidadeConsumidora;
        this.dataConexao = dataConexao;
    }

    @Override
    public String toString() {
        return  "\nIdentificador da Unidade Consumidora: " + identificadorUnidadeConsumidora +
                "\nContato Unidade Consumidora: '" + contatoResponsavelUnidadeConsumidora + '\'' +
                "\nUnidade de Tratamento: " + nomeUnidadeTratamento + " || Identificador: " + idUnidadeTratamento +
                "\nData da realização da conexão: " + dataConexao + "\n";
    }


}
