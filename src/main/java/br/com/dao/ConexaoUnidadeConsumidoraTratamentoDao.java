package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.ConexaoUnidadeConsumidoraTratamento;
import br.com.relatorios.ConexoesUnidadeConsumidoraTratamentoPorPeriodo;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ConexaoUnidadeConsumidoraTratamentoDao extends GenericDao<ConexaoUnidadeConsumidoraTratamento> {

    public ConexaoUnidadeConsumidoraTratamentoDao(EntityManager em) {
        super(em, ConexaoUnidadeConsumidoraTratamento.class);
    }

    public List<ConexoesUnidadeConsumidoraTratamentoPorPeriodo> listaConexoesUnidadeConsumidoraTratamentoPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        try{
            String jpql = "SELECT new br.com.relatorios.ConexoesUnidadeConsumidoraTratamentoPorPeriodo(" +
                    "unc.idUnidadeConsumidora, " +
                    "unt.idUnidadeTratamento, " +
                    "unt.nomeUnidade, " +
                    "unc.contato, " +
                    "cuncunt.dataConexao) " +
                    "FROM ConexaoUnidadeConsumidoraTratamento cuncunt " +
                    "JOIN cuncunt.unidadeConsumidora unc " +
                    "JOIN cuncunt.unidadeTratamento unt " +
                    "WHERE cuncunt.dataConexao BETWEEN :dataInicial AND :dataFinal";

            return em.createQuery(jpql, ConexoesUnidadeConsumidoraTratamentoPorPeriodo.class)
                    .setParameter("dataInicial", dataInicial)
                    .setParameter("dataFinal", dataFinal)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de conexoes unidade consumidora/unidade de tratamento por periodo.", e);
        }
    }
}
