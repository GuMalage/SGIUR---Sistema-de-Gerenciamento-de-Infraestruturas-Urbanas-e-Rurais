package br.com.service;

import br.com.dao.ManutencaoUnidadeDistribuidoraDao;
import br.com.model.ManutencaoUnidadeDistribuidora;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ManutencaoUnidadeDistribuidoraService {
    private ManutencaoUnidadeDistribuidoraDao manutencaoUnidadeDistribuidoraDao;

    public ManutencaoUnidadeDistribuidoraService(EntityManager em) {
        manutencaoUnidadeDistribuidoraDao = new ManutencaoUnidadeDistribuidoraDao(em);
    }

    public void cadastrarManutencaoUnidadeDistribuidora(ManutencaoUnidadeDistribuidora manutencaoUnidadeDistribuidora){
        manutencaoUnidadeDistribuidoraDao.cadastrar(manutencaoUnidadeDistribuidora);
    }

    public void atualizarManutencaoUnidadeDistribuidora(ManutencaoUnidadeDistribuidora manutencaoUnidadeDistribuidora){
        manutencaoUnidadeDistribuidoraDao.atualizar(manutencaoUnidadeDistribuidora);
    }

    public void removerManutencaoUnidadeDistribuidora(ManutencaoUnidadeDistribuidora manutencaoUnidadeDistribuidora){
        manutencaoUnidadeDistribuidoraDao.remover(manutencaoUnidadeDistribuidora);
    }

    public ManutencaoUnidadeDistribuidora buscarManutencaoUnidadeDistribuidoraPorId(int id) {
        return manutencaoUnidadeDistribuidoraDao.buscarPorId(id);
    }

    public List<ManutencaoUnidadeDistribuidora> listarTodasAsManutencoesUnidadeDistribuidora() {
        return manutencaoUnidadeDistribuidoraDao.buscarTodos();
    }

    public void salvarManutencaoUnidadeDistribuidoraEmArquivoBinario(String nomeArquivoBinario) {
        manutencaoUnidadeDistribuidoraDao.salvarEmArquivoBinario(nomeArquivoBinario,listarTodasAsManutencoesUnidadeDistribuidora());
    }

}
