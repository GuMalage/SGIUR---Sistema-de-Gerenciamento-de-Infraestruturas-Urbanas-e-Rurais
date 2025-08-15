package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.Localidade;
import br.com.relatorios.CriticidadeDeLocomocaoPorLocalidade;
import br.com.relatorios.FalhasUnidadeDistribuidoraDeLuzPorLocalidade;
import br.com.relatorios.PopulacaoLocalidadeAtendidaPorSaneamentoBasico;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LocalidadeDao extends GenericDao<Localidade> {

    public LocalidadeDao(EntityManager em) {
        super(em, Localidade.class);
    }

    public List<FalhasUnidadeDistribuidoraDeLuzPorLocalidade> listarFalhasUnidadeDistribuidoraDeLuzPorLocalidade(){
        try{
            String jpql = "SELECT new br.com.relatorios.FalhasUnidadeDistribuidoraDeLuzPorLocalidade(" +
                    "und.nomeUnidade, " +
                    "und.localizacaoUnidade, " +
                    "loc.nomeLocalidade, " +
                    "atv.nomeAtividade, " +
                    "atv.descricaoAtividade, " +
                    "COUNT(mund.idManutencaoUnidadeDistribuidora)) " +
                    "FROM ConexaoUnidadeConsumidoraDistribuidora cuncund " +
                    "JOIN cuncund.unidadeDistribuidora und " +
                    "JOIN ManutencaoUnidadeDistribuidora mund ON mund.unidade_distribuidora.idUnidadeDistribuidora = und.idUnidadeDistribuidora " +
                    "JOIN cuncund.unidadeConsumidora unc " +
                    "JOIN unc.ruaLinha rl " +
                    "JOIN rl.localidade loc " +
                    "JOIN loc.atividadePrincipal atv " +
                    "WHERE und.tipoDistribuicao = 'LUZ' " +
                    "GROUP BY " +
                    "und.nomeUnidade, " +
                    "und.localizacaoUnidade, " +
                    "loc.nomeLocalidade, " +
                    "atv.nomeAtividade, " +
                    "atv.descricaoAtividade";
            return em.createQuery(jpql, FalhasUnidadeDistribuidoraDeLuzPorLocalidade.class)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de falhas por unidade distribuidora de luz por localidade", e);
        }
    }

    public List<CriticidadeDeLocomocaoPorLocalidade> listarCriticidadeDeLocomocaoPorLocalidade(String nomeLocalidade){
        try{
            String jpql = "SELECT new br.com.relatorios.CriticidadeDeLocomocaoPorLocalidade("+
                    "lo.nomeLocalidade, " +
                    "rl.nomeRua, " +
                    "rl.tipoLogradouro, " +
                    "atv.nomeAtividade, " +
                    "rl.criticidadeLocomocao) " +
                    "FROM RuaLinha rl " +
                    "JOIN rl.localidade lo " +
                    "JOIN lo.atividadePrincipal atv " +
                    "WHERE lo.nomeLocalidade = :nomeLocalidade";
            return em.createQuery(jpql, CriticidadeDeLocomocaoPorLocalidade.class)
                    .setParameter("nomeLocalidade", nomeLocalidade)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de criticidade de locomocao por localidade", e);
        }

    }
}
