package br.com.relatorios;

import java.io.Serializable;
import java.time.LocalDate;

public class RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade implements Serializable {
    private String nomeRuaLinha;
    private String nomeLocalidade;
    private String nomeUnidadeTratamentoColetora;
    private int identificadorUnidadeTratamentoColetora;
    private String diasColeta;
    private LocalDate dataInicioColeta;

    public RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeRuaLinha, String nomeLocalidade, String nomeUnidadeTratamentoColetora,
                                                                      int identificadorUnidadeTratamentoColetora, String diasColeta,
                                                                      LocalDate dataInicioColeta) {
        this.nomeRuaLinha = nomeRuaLinha;
        this.nomeLocalidade = nomeLocalidade;
        this.nomeUnidadeTratamentoColetora = nomeUnidadeTratamentoColetora;
        this.identificadorUnidadeTratamentoColetora = identificadorUnidadeTratamentoColetora;
        this.diasColeta = diasColeta;
        this.dataInicioColeta = dataInicioColeta;
    }

    public String getNomeRuaLinha() {
        return nomeRuaLinha;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    @Override
    public String toString() {
        return  "\nNome da Rua/Linha: " + nomeRuaLinha +
                "\nLocalizada em: " + nomeLocalidade +
                "\nUnidade responsavel pela coleta: " + nomeUnidadeTratamentoColetora +
                " || Identificador da unidade: " + identificadorUnidadeTratamentoColetora +
                "\nDias de coleta na Rua/linha " + nomeRuaLinha + ": " + diasColeta +
                "\nA coleta iniciou-se em: " + dataInicioColeta  + "\n";
    }
}
