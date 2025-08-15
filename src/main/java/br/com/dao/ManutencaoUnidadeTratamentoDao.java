package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.ManutencaoUnidadeTratamento;
import br.com.relatorios.ManutencoesPorUnidadeDeTratamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ManutencaoUnidadeTratamentoDao extends GenericDao<ManutencaoUnidadeTratamento> {

   public ManutencaoUnidadeTratamentoDao(EntityManager em) {
       super(em, ManutencaoUnidadeTratamento.class);
   }

    public List<ManutencoesPorUnidadeDeTratamento> quantidadedeManutencoesPorUnidadeDeTratamento() {
        try {
            String jpql = "SELECT new br.com.relatorios.ManutencoesPorUnidadeDeTratamento ( " +
                    "unt.idUnidadeTratamento, " +
                    "unt.nomeUnidade, " +
                    "unt.localizacaoUnidade, " +
                    "unt.tipoTratamento, " +
                    "COUNT(munt.idManutencaoUnidadeTratamento)) " +
                    "FROM ManutencaoUnidadeTratamento munt " +
                    "JOIN munt.unidade_tratamento unt " +
                    "GROUP BY unt.nomeUnidade, unt.localizacaoUnidade, unt.idUnidadeTratamento, unt.tipoTratamento "+
                    "ORDER BY COUNT(munt.idManutencaoUnidadeTratamento) ASC";
            return em.createQuery(jpql, ManutencoesPorUnidadeDeTratamento.class)
                    .getResultList();
        }catch (Exception e) {
            throw new DataException("Erro ao gerar Relatorio de Manutenções por unidade de tratamento.", e);
        }
    }
}
