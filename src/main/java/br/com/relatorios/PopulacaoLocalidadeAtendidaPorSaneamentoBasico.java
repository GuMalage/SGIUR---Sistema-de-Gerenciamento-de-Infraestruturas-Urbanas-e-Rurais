package br.com.relatorios;

import java.io.Serializable;

public class PopulacaoLocalidadeAtendidaPorSaneamentoBasico implements Serializable {
    private String nomeRuaLinha;
    private int idCidade;
    private Integer populacaoEstimada;
    private Long populacaoComSaneamentoBasico;

    public PopulacaoLocalidadeAtendidaPorSaneamentoBasico(String nomeRuaLinha, int idCidade, Integer populacaoEstimada, Long populacaoComSaneamentoBasico) {
        this.nomeRuaLinha = nomeRuaLinha;
        this.idCidade = idCidade;
        this.populacaoEstimada = populacaoEstimada;
        this.populacaoComSaneamentoBasico = populacaoComSaneamentoBasico;
    }

    public Long getPopulacaoComSaneamentoBasico() {
        return populacaoComSaneamentoBasico;
    }

    public String getNomeRuaLinha() {
        return nomeRuaLinha;
    }

    public Integer getPopulacaoEstimada() {
        return populacaoEstimada;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public String calculaPorcentagemPopulacaoSaneamento(Integer populacaoEstimada, Long populacaoComSaneamentoBasico, String nomeRuaLinha) {
        double porcentagem = (populacaoComSaneamentoBasico.doubleValue() / populacaoEstimada) * 100;

        if (porcentagem == 100) {
            return "\nTodos os residentes da Rua - Comunidade Rural " + nomeRuaLinha + " possuem saneamneto basico.";
        }else{
            return "\nApenas " + porcentagem + " dos residentes da Rua - Comunidade Rural " + nomeRuaLinha + " possuem saneamneto basico.";
        }
    }

    @Override
    public String toString() {
        return  "\nRua - Comunidade Rural: " + nomeRuaLinha +
                "\nPopulaçãp Estimada: " + populacaoEstimada
                + calculaPorcentagemPopulacaoSaneamento(populacaoEstimada, populacaoComSaneamentoBasico, nomeRuaLinha)  + "\n";
    }

}
