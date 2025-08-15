package br.com.relatorios;

import java.io.Serializable;
import java.time.LocalDate;

public class RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade implements Serializable {
    private String nomeRuaLinha;
    private String cepRua;
    private String nomeLocalidade;

    public RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeRuaLinha, String cepRua, String nomeLocalidade) {
        this.nomeRuaLinha = nomeRuaLinha;
        this.cepRua = cepRua;
        this.nomeLocalidade = nomeLocalidade;
    }

    public String getNomeRuaLinha() {
        return nomeRuaLinha;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    @Override
    public String toString() {
        return  "\nNome da Rua/Linha: " + nomeRuaLinha
                + " || CEP: " + cepRua +
                "\nLocalizada em: " + nomeLocalidade  + "\n";
    }
}
