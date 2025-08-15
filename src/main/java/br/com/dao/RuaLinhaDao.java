package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.RuaLinha;
import br.com.relatorios.RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade;
import br.com.relatorios.RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RuaLinhaDao extends GenericDao<RuaLinha> {

    public RuaLinhaDao(EntityManager em) {
        super(em, RuaLinha.class);
    }

    public List<RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade){
        try {
            String jpql = "SELECT new br.com.relatorios.RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade("+
                    "rl.nomeRua, " +
                    "lo.nomeLocalidade, " +
                    "untc.nomeUnidade, " +
                    "untc.idUnidadeTratamento, " +
                    "csprl.diasColeta, " +
                    "csprl.inicioColeta) " +
                    "FROM ColetaSeletivaPorRuaLinha csprl " +
                    "JOIN csprl.unidadeTratamento untc " +
                    "JOIN csprl.ruaLinha rl " +
                    "JOIN rl.localidade lo " +
                    "WHERE lo.nomeLocalidade = :nomeLocalidade";
            return em.createQuery(jpql, RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade.class)
                    .setParameter("nomeLocalidade", nomeLocalidade)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de ruas - linhas atendidas por coleta seletiva de lixo.", e);
        }
    }

    public List<RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade) {
        try{
            String jpql = "SELECT new br.com.relatorios.RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(" +
                    "rl.nomeRua, " +
                    "rl.cepRua, " +
                    "lo.nomeLocalidade) " +
                    "FROM RuaLinha rl " +
                    "JOIN rl.localidade lo " +
                    "WHERE lo.nomeLocalidade = :nomeLocalidade " +
                    "AND rl.idRuaLinha NOT IN (" +
                    "   SELECT c.ruaLinha.idRuaLinha FROM ColetaSeletivaPorRuaLinha c" +
                    ")";
            return em.createQuery(jpql, RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade.class)
                    .setParameter("nomeLocalidade", nomeLocalidade)
                    .getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao gerar relatório de ruas - linhas não atendidas por coleta seletiva de lixo.", e);
        }
    }


}
