package br.com.relatorios;

import br.com.enums.Tipo_Tratamento;

import java.io.Serializable;

public class ManutencoesPorUnidadeDeTratamento implements Serializable {
    private int idUnidade;
    private String nomeUnidade;
    private String localizacao;
    private Tipo_Tratamento tipoTratamento;
    private Long qntManutencoes;


    public ManutencoesPorUnidadeDeTratamento(int idUnidade, String nomeUnidade, String localizacao,
                                             Tipo_Tratamento tipoTratamento, Long qntManutencoes) {
        this.idUnidade = idUnidade;
        this.nomeUnidade = nomeUnidade;
        this.tipoTratamento = tipoTratamento;
        this.localizacao = localizacao;
        this.qntManutencoes = qntManutencoes;
    }

    @Override
    public String toString() {
        return  "\nUnidade: " + nomeUnidade +
                "\nIdentificador: " + idUnidade +
                "\nLocalização: " + localizacao +
                "\nTipo de Tratamento: " + tipoTratamento +
                "\nTotal de Manutenções Realizadas: " + qntManutencoes +
                "\n";
    }
}
