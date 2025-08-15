package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.Cidade;
import br.com.relatorios.PopulacaoLocalidadeAtendidaPorSaneamentoBasico;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CidadeDao extends GenericDao<Cidade> {

    public CidadeDao(EntityManager em) {
        super(em, Cidade.class);
    }

    public List<PopulacaoLocalidadeAtendidaPorSaneamentoBasico> porcentagemPopulacaoCidadeAtendidaPorSaneamentoBasico(String nomeCidade){
        try{
            String jpql = "SELECT new br.com.relatorios.PopulacaoLocalidadeAtendidaPorSaneamentoBasico(" +
                    "lo.nomeLocalidade, " +
                    "cd.idCidade, " +
                    "lo.populacaoEstimada, " +
                    "SUM(unc.qntPessoas)) " +
                    "FROM ConexaoUnidadeConsumidoraTratamento cuntunc " +
                    "JOIN UnidadeTratamento unt ON cuntunc.unidadeTratamento.idUnidadeTratamento = unt.idUnidadeTratamento " +
                    "JOIN cuntunc.unidadeConsumidora unc " +
                    "JOIN unc.ruaLinha rl " +
                    "JOIN rl.localidade lo " +
                    "JOIN lo.cidade cd " +
                    "WHERE unc.status = true AND cd.nomeCidade = :nomeCidade AND unt.tipoTratamento = 'ESGOTO' " +
                    "GROUP BY lo.nomeLocalidade, " +
                    "lo.populacaoEstimada, " +
                    "cd.idCidade " +
                    "ORDER BY SUM(unc.qntPessoas) ASC";
            return em.createQuery(jpql, PopulacaoLocalidadeAtendidaPorSaneamentoBasico.class)
                    .setParameter("nomeCidade", nomeCidade)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de pessoas atendidas por saneamento por cidade", e);
        }

    }


}
